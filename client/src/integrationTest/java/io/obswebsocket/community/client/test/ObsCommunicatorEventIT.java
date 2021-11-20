package io.obswebsocket.community.client.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.Event.Type;
import io.obswebsocket.community.client.message.event.config.CurrentProfileChangedEvent;
import io.obswebsocket.community.client.message.event.config.CurrentSceneCollectionChangedEvent;
import io.obswebsocket.community.client.message.event.config.ProfileListChangedEvent;
import io.obswebsocket.community.client.message.event.config.SceneCollectionListChangedEvent;
import io.obswebsocket.community.client.message.event.filters.FilterCreatedEvent;
import io.obswebsocket.community.client.message.event.filters.FilterNameChangedEvent;
import io.obswebsocket.community.client.message.event.general.CustomEvent;
import io.obswebsocket.community.client.message.event.general.ExitStartedEvent;
import io.obswebsocket.community.client.message.event.general.StudioModeStateChangedEvent;
import io.obswebsocket.community.client.message.event.highvolume.InputActiveStateChangedEvent;
import io.obswebsocket.community.client.message.event.highvolume.InputShowStateChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputAudioSyncOffsetChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputAudioTracksChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputCreatedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputMuteStateChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputNameChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputRemovedEvent;
import java.util.ArrayList;
import java.util.Arrays;
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
        + "\t\t'eventIntent': " + (1 << 1) + ",\n"
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
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneCollectionListChanged',\n"
        + "\t\t'eventIntent': " + (1 << 1) + ",\n"
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
    assertEquals(
        actualTestResult.get().getMessageData().getEventData().getSceneCollections().size(), 0);
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
        + "\t'd': {\n"
        + "\t\t'eventType': 'CustomEvent',\n"
        + "\t\t'eventIntent': 1,\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'customField': 'customValue'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Event.Type.CustomEvent);
    // And the contained eventData is right
    assertEquals(
        actualTestResult.get().getMessageData().getEventData().get("customField").getAsString(),
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
        + "\t'd': {\n"
        + "\t\t'eventType': 'ExitStarted',\n"
        + "\t\t'eventIntent': 1\n"
        + "\t}\n"
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
        + "\t'd': {\n"
        + "\t\t'eventType': 'StudioModeStateChanged',\n"
        + "\t\t'eventIntent': 1,\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'studioModeEnabled': true\n"
        + "\t\t}\n"
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
    assertEquals(actualTestResult.get().getMessageData().getEventData().getStudioModeEnabled(),
        true);
  }

  @Test
  void filterNameChangedEventTriggered() {
    // Given the communicator is initialized with a FilterNameChangedEvent listener
    AtomicReference<FilterNameChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(FilterNameChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid StudioModeStateChanged JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'FilterNameChanged',\n"
        + "\t\t'eventIntent': 1,\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'filterName': 'new',\n"
        + "\t\t\t'oldFilterName': 'old'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Type.FilterNameChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getFilterName(), "new");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOldFilterName(), "old");
  }

  @Test
  void filterCreatedEventTriggered() {
    // Given the communicator is initialized with a filterCreatedEvent listener
    AtomicReference<FilterCreatedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(FilterCreatedEvent.class, actualTestResult::set)
        .build();

    // When a valid ExitStarted JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'FilterCreated',\n"
        + "\t\t'eventIntent': " + (1 << 5) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'filterName': 'filterName'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Event.Type.FilterCreated);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getFilterName(),
        "filterName");
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
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputActiveStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 10) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputName': 'input-1',\n"
        + "\t\t\t'videoActive': true\n"
        + "\t\t}\n"
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
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(), "input-1");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getVideoActive(), true);
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
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputShowStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 11) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputName': 'input-1',\n"
        + "\t\t\t'videoShowing': true\n"
        + "\t\t}\n"
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
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(), "input-1");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getVideoShowing(), true);
  }

  @Test
  void inputAudioSyncOffsetChangedEventTriggered() {
    // Given the communicator is initialized with a InputAudioSyncOffsetChangedEvent listener
    AtomicReference<InputAudioSyncOffsetChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(InputAudioSyncOffsetChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid InputAudioSyncOffsetChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputAudioSyncOffsetChanged',\n"
        + "\t\t'eventIntent': " + (1 << 3) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputAudioSyncOffset': 9\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Type.InputAudioSyncOffsetChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputAudioSyncOffset(),
        9L);
  }

  @Test
  void inputAudioTracksChangedEventTriggered() {
    // Given the communicator is initialized with a inputAudioTracksChangedEventTriggered listener
    AtomicReference<InputAudioTracksChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(InputAudioTracksChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid InputAudioTracksChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputAudioTracksChanged',\n"
        + "\t\t'eventIntent': " + (1 << 3) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputAudioTracks': [\n"
        + "\t\t\t\t1,\n"
        + "\t\t\t\t2,\n"
        + "\t\t\t\t3\n"
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
            Type.InputAudioTracksChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputAudioTracks(),
        new ArrayList<>(Arrays.asList(1, 2, 3)));
  }

  @Test
  void inputCreatedEventTriggered() {
    // Given the communicator is initialized with a InputCreatedEvent listener
    AtomicReference<InputCreatedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(InputCreatedEvent.class, actualTestResult::set)
        .build();

    // When a valid inputCreatedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputCreated',\n"
        + "\t\t'eventIntent': " + (1 << 3) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputName': 'someInput',\n"
        + "\t\t\t'inputKind': 'inputKind',\n"
        + "\t\t\t'inputSettings': {\n"
        + "\t\t\t\t'settingName': 'settingValue'\n"
        + "\t\t\t},\n"
        + "\t\t\t'defaultInputSettings': {\n"
        + "\t\t\t\t'defaultSettingName': 'defaultSettingValue'\n"
        + "\t\t\t}\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Type.InputCreated);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(),
        "someInput");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputKind(),
        "inputKind");
    assertEquals(
        actualTestResult.get().getMessageData().getEventData().getInputSettings().get("settingName")
            .getAsString(), "settingValue");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getDefaultInputSettings()
        .get("defaultSettingName").getAsString(), "defaultSettingValue");
  }

  @Test
  void inputMuteStateChangedEventTriggered() {
    // Given the communicator is initialized with a InputMuteStateChangedEvent listener
    AtomicReference<InputMuteStateChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(InputMuteStateChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid InputMuteStateChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputMuteStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 3) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputName': 'someInput',\n"
        + "\t\t\t'inputMuted': false\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Type.InputMuteStateChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(),
        "someInput");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputMuted(), false);
  }

  @Test
  void inputNameChangedEventTriggered() {
    // Given the communicator is initialized with a inputNameChangedEvent listener
    AtomicReference<InputNameChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(InputNameChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid InputNameChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputNameChanged',\n"
        + "\t\t'eventIntent': " + (1 << 3) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputName': 'someInput',\n"
        + "\t\t\t'oldInputName': 'oldNameOfSomeInput'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions
        .assertEquals(actualTestResult.get().getMessageData().getEventType(),
            Type.InputNameChanged);
    // And the contained eventData is right
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(),
        "someInput");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOldInputName(),
        "oldNameOfSomeInput");
  }

  @Test
  void inputRemovedEventTriggered() {
    // Given the communicator is initialized with a InputRemovedEvent listener
    AtomicReference<InputRemovedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(InputRemovedEvent.class, actualTestResult::set)
        .build();

    // When a valid InputRemovedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputRemoved',\n"
        + "\t\t'eventIntent': " + (1 << 3) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputName': 'inputName'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Event.Type.InputRemoved);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(), "inputName");
  }

}
