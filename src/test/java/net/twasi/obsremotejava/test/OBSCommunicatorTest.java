package net.twasi.obsremotejava.test;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.authenticator.Authenticator;
import net.twasi.obsremotejava.listener.event.ObsEventListener;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.Message.Type;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.event.config.CurrentProfileChangedEvent;
import net.twasi.obsremotejava.message.event.config.CurrentSceneCollectionChangedEvent;
import net.twasi.obsremotejava.message.event.config.ProfileListChangedEvent;
import net.twasi.obsremotejava.message.event.config.SceneCollectionListChangedEvent;
import net.twasi.obsremotejava.message.event.general.CustomEvent;
import net.twasi.obsremotejava.message.event.general.ExitStartedEvent;
import net.twasi.obsremotejava.message.event.general.StudioModeStateChangedEvent;
import net.twasi.obsremotejava.message.event.highvolume.InputActiveStateChangedEvent;
import net.twasi.obsremotejava.message.event.highvolume.InputShowStateChangedEvent;
import net.twasi.obsremotejava.message.request.general.GetVersionRequest;
import net.twasi.obsremotejava.message.response.general.GetVersionResponse;
import net.twasi.obsremotejava.test.translator.AbstractSerializationTest;
import net.twasi.obsremotejava.translator.MessageTranslator;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
          eventListener
        );
        connector.onMessage("doesntmatter");

        // Then it is routed to the EventListener
        verify(eventListener).onEvent(eq(someEvent));

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
