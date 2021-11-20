package io.obswebsocket.community.client.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.config.CurrentProfileChangedEvent;
import io.obswebsocket.community.client.message.event.config.CurrentSceneCollectionChangedEvent;
import io.obswebsocket.community.client.message.event.config.ProfileListChangedEvent;
import io.obswebsocket.community.client.message.event.config.SceneCollectionListChangedEvent;
import io.obswebsocket.community.client.message.event.general.CustomEvent;
import io.obswebsocket.community.client.message.event.general.ExitStartedEvent;
import io.obswebsocket.community.client.message.event.general.StudioModeStateChangedEvent;
import io.obswebsocket.community.client.message.event.highvolume.InputActiveStateChangedEvent;
import io.obswebsocket.community.client.message.event.highvolume.InputShowStateChangedEvent;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObsCommunicatorEventIT {

  @Test
  void currentProfileChangedEventTriggered() {
    // Given the communicator is initialized with a CurrentProfileChangedEvent listener
    AtomicReference<CurrentProfileChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(CurrentProfileChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid CurrentProfileChanged JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'CurrentProfileChanged',\n"
        + "\t\t'eventIntent': " + (1 << 1) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'currentProfileName': 'Profile 1'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
//    assertTrue(isDeserializable(eventMessage));
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Event.Type.CurrentProfileChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getCurrentProfileName(),
        "Profile 1");
    // Serialization and Deserialization works
//    assertSerializationAndDeserialization(eventMessage, actualTestResult.get());
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
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'CurrentSceneCollectionChanged',\n"
        + "\t\t'eventIntent': " + (1 << 1) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'currentSceneCollectionName': 'Scene Collection 1'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Event.Type.CurrentSceneCollectionChanged);
    // And the contained eventData is right
    assertEquals(
        actualTestResult.get().getMessageData().getEventData().getCurrentSceneCollectionName(),
        "Scene Collection 1");
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
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'ProfileListChanged',\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'profiles': [\n"
        // TODO: Add at least 1 profile
        + "\t\t\t]\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Event.Type.ProfileListChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getProfiles().size(), 0);
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
        + "\t'op': 5,\n"
        + "\t'd': {,\n"
        + "\t\t'eventType': 'SceneCollectionListChanged',\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneCollections': [\n"
        // TODO: Add at least 1 scene collection
        + "\t\t\t]\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Event.Type.SceneCollectionListChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneCollections().size(), 0);
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
        + "\t'op': 5,\n"
        + "\t'eventType': 'CustomEvent',\n"
        + "\t'eventData': {\n"
        + "\t\t'customField': 'customValue'\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Event.Type.CustomEvent);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getEventData().get("customField").getAsString(),
        "customValue");
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
        + "\t'op': 5,\n"
        + "\t'eventType': 'ExitStarted'\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Event.Type.ExitStarted);
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
        + "\t'op': 5,\n"
        + "\t'eventType': 'StudioModeStateChanged',\n"
        + "\t'eventData': {\n"
        + "\t\t'studioModeEnabled': true\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Event.Type.StudioModeStateChanged);
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
        + "\t'op': 5,\n"
        + "\t'eventType': 'InputActiveStateChanged',\n"
        + "\t'eventData': {\n"
        + "\t\t'inputName': 'input-1',\n"
        + "\t\t'videoActive': true\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Event.Type.InputActiveStateChanged);
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
        + "\t'op': 5,\n"
        + "\t'eventType': 'InputShowStateChanged',\n"
        + "\t'eventData': {\n"
        + "\t\t'inputName': 'input-1',\n"
        + "\t\t'videoShowing': true\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Event.Type.InputShowStateChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getEventData().getInputName(), "input-1");
    assertEquals(actualTestResult.get().getEventData().getVideoShowing(), true);
  }

}
