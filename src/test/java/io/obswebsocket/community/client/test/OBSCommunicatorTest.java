package io.obswebsocket.community.client.test;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.authenticator.Authenticator;
import io.obswebsocket.community.client.listener.event.ObsEventListener;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import io.obswebsocket.community.client.listener.request.ObsRequestListener;
import io.obswebsocket.community.client.message.Message.Type;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestBatch;
import io.obswebsocket.community.client.message.request.general.GetVersionRequest;
import io.obswebsocket.community.client.message.response.RequestBatchResponse;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.general.GetVersionResponse;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import io.obswebsocket.community.client.translator.MessageTranslator;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class OBSCommunicatorTest extends AbstractSerializationTest {

    @Test
    void nullMessageTriggersOnErrorCallback() {
        // Given the communicator is listening for errors
        AtomicReference<String> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .lifecycle()
                  .onError((comm, reasonThrowable) -> {
                      System.out.println(reasonThrowable);
                      actualTestResult.set(reasonThrowable.getReason());
                  })
                  .and()
                .build();

        // When an null message is supplied
        String message = null;
        connector.onMessage(message);

        // Then an error will have been received
        assertThat(actualTestResult.get()).containsIgnoringCase("Received message was deserializable but had unknown format");
    }

    @Test
    void invalidJsonTriggersOnErrorCallback() {
        // Given the communicator is listening for errors
        AtomicReference<String> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .lifecycle()
                  .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
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
                  .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
                  .and()
                .build();

        // When a serializable (but unrecognized) object is supplied
        String message = "x";
        assertTrue(isDeserializable(message));
        connector.onMessage(message);

        // Then an error will be triggered
        assertEquals("Received message was deserializable but had unknown format", actualTestResult.get());
    }

    @Test
    void validButUnrecognizedMessageTypeTriggersOnErrorCallback() {
        // Given the communicator is listening for errors
        AtomicReference<String> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .lifecycle()
                  .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
                  .and()
                .build();

        // When a valid, but unrecognized, JSON object is supplied
        String message = "{\n"
                + "\t\"messageType\": \"SomethingGibberish\"\n"
                + "}";
        assertTrue(isDeserializable(message));
        connector.onMessage(message);

        // Then an error will be triggered
        assertEquals("Received message was deserializable but had unknown format", actualTestResult.get());
    }

    @Test
    void validButUnrecognizedEventTypeTriggersOnErrorCallback() {
        // Given the communicator is listening for errors
        AtomicReference<String> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .lifecycle()
                  .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
                  .and()
                .build();

        // When a valid, but unrecognized, JSON object is supplied
        String message = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"SomethingGibberish\"\n"
                + "}";
        assertTrue(isDeserializable(message));
        connector.onMessage(message);

        // Then an error will be triggered
        assertEquals("Received message was deserializable but had unknown format", actualTestResult.get());
    }

    @Test
    void eventsAreRoutedToEventListener() {

        // Given we have an event listener
        ObsEventListener eventListener = mock(ObsEventListener.class);

        // And given a message is serialized to an event
        MessageTranslator messageTranslator = mock(MessageTranslator.class);
        Event someEvent = mock(Event.class);
        when(someEvent.getMessageType()).thenReturn(Type.Event);
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
          mock(ObsEventListener.class)
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
          mock(ObsEventListener.class)
        );

        // and no session
        // (do nothing)

        // When a request is sent
        connector.sendRequest(mock(Request.class), mock(Consumer.class));

        // Then an error was invoked
        ArgumentCaptor<ReasonThrowable> captor = ArgumentCaptor.forClass(ReasonThrowable.class);
        verify(lifecycleListener).onError(any(), captor.capture());
        assertThat(captor.getValue().getReason()).isEqualTo("Could not send message; no session established");

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
          mock(ObsEventListener.class)
        );

        // and no session
        // (do nothing)

        // When a requestBatch is sent
        RequestBatch requestBatch = mock(RequestBatch.class);
        when(requestBatch.getRequests()).thenReturn(Arrays.asList(mock(Request.class)));
        connector.sendRequestBatch(requestBatch, mock(Consumer.class));

        // Then an error was invoked
        ArgumentCaptor<ReasonThrowable> captor = ArgumentCaptor.forClass(ReasonThrowable.class);
        verify(lifecycleListener).onError(any(), captor.capture());
        assertThat(captor.getValue().getReason()).isEqualTo("Could not send message; no session established");

    }

    @Test
    void requestResponsesAreRoutedToRequestListener() {

        // Given we have a request listener
        ObsRequestListener requestListener = mock(ObsRequestListener.class);

        // And given a message is serialized to a request
        MessageTranslator messageTranslator = mock(MessageTranslator.class);
        RequestResponse someRequest = mock(RequestResponse.class);
        when(someRequest.getMessageType()).thenReturn(Type.RequestResponse);
        when(messageTranslator.fromJson(anyString(), any())).thenReturn(someRequest);

        // When a message is provided to the communicator
        OBSCommunicator connector = new OBSCommunicator(
          messageTranslator,
          mock(Authenticator.class),
          mock(CommunicatorLifecycleListener.class),
          requestListener,
          mock(ObsEventListener.class)
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
          mock(ObsEventListener.class)
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
          mock(ObsEventListener.class)
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
        when(someRequest.getMessageType()).thenReturn(Type.RequestBatchResponse);
        when(messageTranslator.fromJson(anyString(), any())).thenReturn(someRequest);

        // When a message is provided to the communicator
        OBSCommunicator connector = new OBSCommunicator(
          messageTranslator,
          mock(Authenticator.class),
          mock(CommunicatorLifecycleListener.class),
          requestListener,
          mock(ObsEventListener.class)
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
            connector.sendRequest(getVersionRequest, getVersionResponse -> actualTestResult.set((GetVersionResponse) getVersionResponse));
        }
        catch (Exception ignored) {}

        // When a valid GetVersionResponse JSON object is supplied
        String message = "{\n"
                + "\t'messageType': 'RequestResponse',\n"
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

}
