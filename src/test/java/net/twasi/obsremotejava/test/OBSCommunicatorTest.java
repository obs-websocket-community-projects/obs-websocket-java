package net.twasi.obsremotejava.test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.Gson;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import net.twasi.obsremotejava.OBSCommunicator;
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
import org.junit.jupiter.api.Test;

class OBSCommunicatorTest {

    @Test
    void nullMessageTriggersOnErrorCallback() {
        // Given the communicator is listening for errors
        AtomicReference<String> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .lifecycle()
                  .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
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
    void currentProfileChangedEventTriggered() {
        // Given the communicator is initialized with a CurrentProfileChangedEvent listener
        AtomicReference<CurrentProfileChangedEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(CurrentProfileChangedEvent.class, actualTestResult::set)
                .build();

        // When a valid CurrentProfileChanged JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"CurrentProfileChanged\",\n"
                + "\t\"eventData\": {\n"
                + "\t\t\"currentProfileName\": \"Profile 1\"\n"
                + "\t}\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.CurrentProfileChanged);
        // And the contained eventData is right
        assertEquals(actualTestResult.get().getEventData().getCurrentProfileName(), "Profile 1");
    }

    @Test
    void currentSceneCollectionChangedEventTriggered() {
        // Given the communicator is initialized with a CurrentSceneCollectionChangedEvent listener
        AtomicReference<CurrentSceneCollectionChangedEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(CurrentSceneCollectionChangedEvent.class, actualTestResult::set)
                .build();

        // When a valid CurrentSceneCollectionChanged JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"CurrentSceneCollectionChanged\",\n"
                + "\t\"eventData\": {\n"
                + "\t\t\"currentSceneCollectionName\": \"Scene Collection 1\"\n"
                + "\t}\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.CurrentSceneCollectionChanged);
        // And the contained eventData is right
        assertEquals(actualTestResult.get().getEventData().getCurrentSceneCollectionName(), "Scene Collection 1");
    }

    @Test
    void profileListChangedEventTriggered() {
        // Given the communicator is initialized with a ProfileListChangedEvent listener
        AtomicReference<ProfileListChangedEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(ProfileListChangedEvent.class, actualTestResult::set)
                .build();

        // When a valid ProfileListChanged JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"ProfileListChanged\",\n"
                + "\t\"eventData\": {\n"
                + "\t\t\"profiles\": [\n"
                // TODO: Add at least 1 profile
                + "\t\t]\n"
                + "\t}\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.ProfileListChanged);
        // And the contained eventData is right
        assertEquals(actualTestResult.get().getEventData().getProfiles().size(), 0);
    }

    @Test
    void sceneCollectionListChangedEventTriggered() {
        // Given the communicator is initialized with a SceneCollectionListChangedEvent listener
        AtomicReference<SceneCollectionListChangedEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(SceneCollectionListChangedEvent.class, actualTestResult::set)
                .build();

        // When a valid SceneCollectionListChanged JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"SceneCollectionListChanged\",\n"
                + "\t\"eventData\": {\n"
                + "\t\t\"sceneCollections\": [\n"
                // TODO: Add at least 1 scene collection
                + "\t\t]\n"
                + "\t}\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.SceneCollectionListChanged);
        // And the contained eventData is right
        assertEquals(actualTestResult.get().getEventData().getSceneCollections().size(), 0);
    }

    @Test
    void customEventTriggered() {
        // Given the communicator is initialized with a CustomEvent listener
        AtomicReference<CustomEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(CustomEvent.class, actualTestResult::set)
                .build();

        // When a valid CustomEvent JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"CustomEvent\",\n"
                + "\t\"eventData\": {\n"
                + "\t\t\"customField\": \"customValue\"\n"
                + "\t}\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.CustomEvent);
        // And the contained eventData is right
        assertEquals(actualTestResult.get().getEventData().get("customField").getAsString(), "customValue");
    }

    @Test
    void exitStartedEventTriggered() {
        // Given the communicator is initialized with a ExitStartedEvent listener
        AtomicReference<ExitStartedEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(ExitStartedEvent.class, actualTestResult::set)
                .build();

        // When a valid ExitStarted JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"ExitStarted\"\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.ExitStarted);
    }

    @Test
    void studioModeStateChangedEventTriggered() {
        // Given the communicator is initialized with a StudioModeStateChangedEvent listener
        AtomicReference<StudioModeStateChangedEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(StudioModeStateChangedEvent.class, actualTestResult::set)
                .build();

        // When a valid StudioModeStateChanged JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"StudioModeStateChanged\",\n"
                + "\t\"eventData\": {\n"
                + "\t\t\"studioModeEnabled\": true\n"
                + "\t}\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.StudioModeStateChanged);
        // And the contained eventData is right
        assertEquals(actualTestResult.get().getEventData().getStudioModeEnabled(), true);
    }

    @Test
    void inputActiveStateChangedEventTriggered() {
        // Given the communicator is initialized with a InputActiveStateChangedEvent listener
        AtomicReference<InputActiveStateChangedEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(InputActiveStateChangedEvent.class, actualTestResult::set)
                .build();

        // When a valid InputActiveStateChangedEvent JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"InputActiveStateChanged\",\n"
                + "\t\"eventData\": {\n"
                + "\t\t\"inputName\": \"input-1\",\n"
                + "\t\t\"videoActive\": true\n"
                + "\t}\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.InputActiveStateChanged);
        // And the contained eventData is right
        assertEquals(actualTestResult.get().getEventData().getInputName(), "input-1");
        assertEquals(actualTestResult.get().getEventData().getVideoActive(), true);
    }

    @Test
    void inputShowStateChangedEventTriggered() {
        // Given the communicator is initialized with a InputShowStateChangedEvent listener
        AtomicReference<InputShowStateChangedEvent> actualTestResult = new AtomicReference<>();
        OBSCommunicator connector = OBSCommunicator.builder()
                .registerEventListener(InputShowStateChangedEvent.class, actualTestResult::set)
                .build();

        // When a valid InputShowStateChangedEvent JSON object is supplied
        String eventMessage = "{\n"
                + "\t\"messageType\": \"Event\",\n"
                + "\t\"eventType\": \"InputShowStateChanged\",\n"
                + "\t\"eventData\": {\n"
                + "\t\t\"inputName\": \"input-1\",\n"
                + "\t\t\"videoShowing\": true\n"
                + "\t}\n"
                + "}";
        assertTrue(isDeserializable(eventMessage));
        connector.onMessage(eventMessage);

        // Then the event listener will be called
        assertNotNull(actualTestResult.get());
        // And will receive the Event instance object
        assertEquals(actualTestResult.get().getEventType(), Event.Type.InputShowStateChanged);
        // And the contained eventData is right
        assertEquals(actualTestResult.get().getEventData().getInputName(), "input-1");
        assertEquals(actualTestResult.get().getEventData().getVideoShowing(), true);
    }

    private boolean isDeserializable(String json) {
        // We can use a generic gson object,
        // all we care about is if it is valid json
        Gson gson = new Gson();
        try {
            Object obj = gson.fromJson(json, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
