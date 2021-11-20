package io.obswebsocket.community.client;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.obswebsocket.community.client.authenticator.Authenticator;
import io.obswebsocket.community.client.listener.event.OBSEventListener;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import io.obswebsocket.community.client.listener.request.ObsRequestListener;
import io.obswebsocket.community.client.message.Message.OperationCode;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestBatch;
import io.obswebsocket.community.client.message.request.general.GetVersionRequest;
import io.obswebsocket.community.client.message.response.RequestBatchResponse;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.general.GetVersionResponse;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import io.obswebsocket.community.client.translator.MessageTranslator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class OBSCommunicatorTest extends AbstractSerializationTest {

  /**
   * on Hello, the server responds with the highest available RPC version. However, it does require
   * us to use that version and further if it is unsupported then the server will drop the
   * connection after an Identify request is received. See https://github.com/obsproject/obs-websocket/blob/master/docs/generated/protocol.md#connection-steps
   */
  @Test
  void unsupportedRpcVersion() {

    // given a communicator instance, with a known RPC version
    CommunicatorLifecycleListener lifecycleListener = mock(CommunicatorLifecycleListener.class);
    MessageTranslator messageTranslator = mock(MessageTranslator.class);
    OBSCommunicator obsCommunicator = spy(new OBSCommunicator(
        messageTranslator,
        mock(Authenticator.class),
        lifecycleListener,
        mock(ObsRequestListener.class),
        mock(OBSEventListener.class)
    ));

    // and given a session is established
    obsCommunicator.onConnect(mock(Session.class));

    // when a hello with a version less than ours is sent by the server
    int serverRpcVersion = 0;
    assertTrue(serverRpcVersion < OBSCommunicator.RPC_VERSION);
    obsCommunicator.onHello(Hello.builder().rpcVersion(serverRpcVersion).build());

    // then onError is called
    ArgumentCaptor<ReasonThrowable> captor = ArgumentCaptor.forClass(ReasonThrowable.class);
    verify(lifecycleListener).onError(captor.capture());
    assertThat(captor.getValue().getThrowable()).isInstanceOf(IllegalStateException.class);
    assertThat(captor.getValue().getThrowable())
        .hasMessage("Server doesn't support this client's RPC version");
  }

  @Test
  void nullMessageTriggersOnErrorCallback() {
    // Given the communicator is listening for errors
    AtomicReference<String> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .lifecycle()
        .onError((reasonThrowable) -> {
          System.out.println(reasonThrowable);
          actualTestResult.set(reasonThrowable.getReason());
        })
        .and()
        .build();

    // When a null message is supplied
    String message = null;
    connector.onMessage(message);

    // Then an error will have been received
    assertThat(actualTestResult.get())
        .containsIgnoringCase("Received message was deserializable but had unknown format");
  }

  @Test
  void invalidJsonTriggersOnErrorCallback() {
    // Given the communicator is listening for errors
    AtomicReference<String> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .lifecycle()
        .onError((reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
        .and()
        .build();

    // When an invalid JSON message is supplied
    String message = "{x}";
    assertFalse(isDeserializable(message));
    connector.onMessage(message);

    // Then an error will have been received
    assertThat(actualTestResult.get()).containsIgnoringCase("Message received was not valid json");
  }

  @Test
  void deserializableButUnrecognizedObjectsTriggerError() {
    // Given the communicator is listening for errors
    AtomicReference<String> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .lifecycle()
        .onError((reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
        .and()
        .build();

    // When a serializable (but unrecognized) object is supplied
    String message = "x";
    assertTrue(isDeserializable(message));
    connector.onMessage(message);

    // Then an error will be triggered
    assertEquals("Received message was deserializable but had unknown format",
        actualTestResult.get());
  }

  @Test
  void validButUnrecognizedMessageTypeTriggersOnErrorCallback() {
    // Given the communicator is listening for errors
    AtomicReference<String> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .lifecycle()
        .onError((reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
        .and()
        .build();

    // When a valid, but unrecognized, JSON object is supplied
    String message = "{\n"
        + "\t'op': -1\n"
        + "}";
    assertTrue(isDeserializable(message));
    connector.onMessage(message);

    // Then an error will be triggered
    assertEquals("Received message was deserializable but had unknown format",
        actualTestResult.get());
  }

  @Test
  void validButUnrecognizedEventTypeTriggersOnErrorCallback() {
    // Given the communicator is listening for errors
    AtomicReference<String> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .lifecycle()
        .onError((reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
        .and()
        .build();

    // When a valid, but unrecognized, JSON object is supplied
    String message = "{\n"
        + "\t'op': 5,\n"
        + "\t'eventType': 'SomethingGibberish'\n"
        + "}";
    assertTrue(isDeserializable(message));
    connector.onMessage(message);

    // Then an error will be triggered
    assertEquals("Received message was deserializable but had unknown format",
        actualTestResult.get());
  }

  @Test
  void eventsAreRoutedToEventListener() {

    // Given we have an event listener
    OBSEventListener eventListener = mock(OBSEventListener.class);

    // And given a message is serialized to an event
    MessageTranslator messageTranslator = mock(MessageTranslator.class);
    Event someEvent = mock(Event.class);
    when(someEvent.getOperationCode()).thenReturn(OperationCode.Event);
    when(messageTranslator.fromJson(anyString(), any())).thenReturn(someEvent);

    // When a message is provided to the communicator
    OBSCommunicator connector = new OBSCommunicator(
        messageTranslator,
        mock(Authenticator.class),
        mock(CommunicatorLifecycleListener.class),
        mock(ObsRequestListener.class),
        eventListener
    );
    connector.onMessage("doesntmatter");

    // Then it is routed to the EventListener
    verify(eventListener).onEvent(eq(someEvent));

  }

  @Test
  void requestsAreRoutedToRequestListener() {

    // Given we have a request listener
    ObsRequestListener requestListener = mock(ObsRequestListener.class);

    // And given a request
    Request someRequest = mock(Request.class);
    when(someRequest.getRequestId()).thenReturn(UUID.randomUUID().toString());
    Consumer callback = mock(Consumer.class);

    // And a communicator with a session
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        mock(CommunicatorLifecycleListener.class),
        requestListener,
        mock(OBSEventListener.class)
    );
    connector.onConnect(mock(Session.class, RETURNS_DEEP_STUBS));

    // When a message is provided to the communicator
    connector.sendRequest(someRequest, callback);

    // Then it is routed to the EventListener
    verify(requestListener).registerRequest(eq(someRequest), eq(callback));
  }

  @Test
  void sendRequestWithoutSession() {

    // Given a connector
    CommunicatorLifecycleListener lifecycleListener = mock(CommunicatorLifecycleListener.class);
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        lifecycleListener,
        mock(ObsRequestListener.class),
        mock(OBSEventListener.class)
    );

    // and no session
    // (do nothing)

    // When a request is sent
    connector.sendRequest(mock(Request.class), mock(Consumer.class));

    // Then an error was invoked
    ArgumentCaptor<ReasonThrowable> captor = ArgumentCaptor.forClass(ReasonThrowable.class);
    verify(lifecycleListener).onError(captor.capture());
    assertThat(captor.getValue().getReason())
        .isEqualTo("Could not send message; no session established");

  }

  @Test
  void sendRequestBatchWithoutSession() {

    // Given a connector
    CommunicatorLifecycleListener lifecycleListener = mock(CommunicatorLifecycleListener.class);
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        lifecycleListener,
        mock(ObsRequestListener.class),
        mock(OBSEventListener.class)
    );

    // and no session
    // (do nothing)

    // When a requestBatch is sent
    RequestBatch requestBatch = mock(RequestBatch.class);
    when(requestBatch.getRequests()).thenReturn(Arrays.asList(mock(Request.class)));
    connector.sendRequestBatch(requestBatch, mock(Consumer.class));

    // Then an error was invoked
    ArgumentCaptor<ReasonThrowable> captor = ArgumentCaptor.forClass(ReasonThrowable.class);
    verify(lifecycleListener).onError(captor.capture());
    assertThat(captor.getValue().getReason())
        .isEqualTo("Could not send message; no session established");

  }

  @Test
  void requestResponsesAreRoutedToRequestListener() {

    // Given we have a request listener
    ObsRequestListener requestListener = mock(ObsRequestListener.class);

    // And given a message is serialized to a request
    MessageTranslator messageTranslator = mock(MessageTranslator.class);
    RequestResponse someRequest = mock(RequestResponse.class);
    when(someRequest.getOperationCode()).thenReturn(OperationCode.RequestResponse);
    when(messageTranslator.fromJson(anyString(), any())).thenReturn(someRequest);

    // When a message is provided to the communicator
    OBSCommunicator connector = new OBSCommunicator(
        messageTranslator,
        mock(Authenticator.class),
        mock(CommunicatorLifecycleListener.class),
        requestListener,
        mock(OBSEventListener.class)
    );
    connector.onMessage("doesntmatter");

    // Then it is routed to the EventListener
    verify(requestListener).onRequestResponse(eq(someRequest));
  }

  @Test
  void batchRequestsAreRoutedToRequestListener() {

    // Given we have a request listener
    ObsRequestListener requestListener = mock(ObsRequestListener.class);

    // And given a batch request
    RequestBatch someRequest = mock(RequestBatch.class);
    when(someRequest.getRequestId()).thenReturn(UUID.randomUUID().toString());
    when(someRequest.getRequests()).thenReturn(Collections.singletonList(mock(Request.class)));
    Consumer callback = mock(Consumer.class);

    // And a communicator with a session
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        mock(CommunicatorLifecycleListener.class),
        requestListener,
        mock(OBSEventListener.class)
    );
    connector.onConnect(mock(Session.class, RETURNS_DEEP_STUBS));

    // When a message is provided to the communicator
    connector.sendRequestBatch(someRequest, callback);

    // Then it is routed to the EventListener
    verify(requestListener).registerRequestBatch(eq(someRequest), eq(callback));
  }

  @Test
  void invalidRequestBatchRequests() {

    // Given a connector
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        mock(CommunicatorLifecycleListener.class),
        mock(ObsRequestListener.class),
        mock(OBSEventListener.class)
    );

    // empty batch requests are invalid
    RequestBatch emptyRequestBatch = mock(RequestBatch.class);
    when(emptyRequestBatch.getRequests()).thenReturn(new ArrayList<>());
    assertThatThrownBy(() -> {
      connector.sendRequestBatch(emptyRequestBatch, mock(Consumer.class));
    }).isInstanceOf(IllegalArgumentException.class);

    // null batch requests are invalid
    RequestBatch nullRequestBatch = mock(RequestBatch.class);
    when(nullRequestBatch.getRequests()).thenReturn(null);
    assertThatThrownBy(() -> {
      connector.sendRequestBatch(nullRequestBatch, mock(Consumer.class));
    }).isInstanceOf(IllegalArgumentException.class);

  }

  @Test
  void requestRequestResponsesAreRoutedToRequestListener() {

    // Given we have a request listener
    ObsRequestListener requestListener = mock(ObsRequestListener.class);

    // And given a message is serialized to a request
    MessageTranslator messageTranslator = mock(MessageTranslator.class);
    RequestBatchResponse someRequest = mock(RequestBatchResponse.class);
    when(someRequest.getOperationCode()).thenReturn(OperationCode.RequestBatchResponse);
    when(messageTranslator.fromJson(anyString(), any())).thenReturn(someRequest);

    // When a message is provided to the communicator
    OBSCommunicator connector = new OBSCommunicator(
        messageTranslator,
        mock(Authenticator.class),
        mock(CommunicatorLifecycleListener.class),
        requestListener,
        mock(OBSEventListener.class)
    );
    connector.onMessage("doesntmatter");

    // Then it is routed to the EventListener
    verify(requestListener).onRequestBatchResponse(eq(someRequest));
  }

  @Test
  void requestAndResponse() {
    // Given a communicator
    AtomicReference<GetVersionResponse> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .build();

    // And a GetVersionRequest is sent through it
    GetVersionRequest getVersionRequest = GetVersionRequest.builder().build();
    try {
      connector.sendRequest(getVersionRequest,
          getVersionResponse -> actualTestResult.set((GetVersionResponse) getVersionResponse));
    } catch (Exception ignored) {
    }

    // When a valid GetVersionResponse JSON object is supplied
    String message = "{\n"
        + "\t'op': 7,\n"
        + "\t'requestType': 'GetVersion',\n"
        + "\t'requestId': '" + getVersionRequest.getRequestId() + "',\n"
        + "\t'responseData': {\n"
        + "\t\t'obsVersion': '27.0.0'\n"
        + "\t}\n"
        + "}";
    assertTrue(isDeserializable(message));
    connector.onMessage(message);

    // Then we will get the response
    assertEquals("27.0.0", actualTestResult.get().getResponseData().getObsVersion());
  }

  @Test
  void communicatorClosesConnectionOnError() {

    // Given a communicator
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        mock(CommunicatorLifecycleListener.class),
        mock(ObsRequestListener.class),
        mock(OBSEventListener.class)
    );

    // And given a session is established
    Session session = mock(Session.class);
    connector.onConnect(session);

    // When onError is invoked
    connector.onError(session, new Exception("some exception"));

    // Then the connection is closed
    verify(session).close(
        4000,
        "An exception was thrown with message: some exception"
    );

  }

  @Test
  void closeWithInvalidCodeDoesNotCauseError() {

    // Given a communicator
    CommunicatorLifecycleListener lifecycleListener = mock(CommunicatorLifecycleListener.class);
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        lifecycleListener,
        mock(ObsRequestListener.class),
        mock(OBSEventListener.class)
    );

    // And given a session is established
    Session session = mock(Session.class);
    connector.onConnect(session);

    // When onClose is invoked with an invalid code
    int invalidCode = 69696969;
    assertThatThrownBy(() -> {
      WebSocketCloseCode.fromCode(invalidCode);
    }).isInstanceOf(IllegalArgumentException.class);
    connector.onClose(invalidCode, "some reason");

    // Then onError is not invoked
    verify(lifecycleListener, times(0)).onError(any());

    // And onClose is invoked with Unknown
    verify(lifecycleListener).onClose(eq(WebSocketCloseCode.UnknownCode));

  }

  @Test
  void clientIsReadyWhenIdentified() {

    // Given a communicator
    CommunicatorLifecycleListener lifecycleListener = mock(CommunicatorLifecycleListener.class);
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        lifecycleListener,
        mock(ObsRequestListener.class),
        mock(OBSEventListener.class)
    );

    // And a session is established
    connector.onConnect(mock(Session.class, RETURNS_DEEP_STUBS));

    // When identified
    connector.onIdentified(mock(Identified.class));

    // Then it is ready
    verify(lifecycleListener).onReady();

  }

  @Test
  void clientDisconnectedAfterClose() {

    // Given a communicator
    CommunicatorLifecycleListener lifecycleListener = mock(CommunicatorLifecycleListener.class);
    OBSCommunicator connector = new OBSCommunicator(
        mock(MessageTranslator.class),
        mock(Authenticator.class),
        lifecycleListener,
        mock(ObsRequestListener.class),
        mock(OBSEventListener.class)
    );

    // And a session is established
    connector.onConnect(mock(Session.class, RETURNS_DEEP_STUBS));

    // When closed
    connector.onClose(WebSocketCloseCode.UnknownReason.getCode(), "foo");

    // Then it is disconnected
    verify(lifecycleListener).onDisconnect();

  }
}
