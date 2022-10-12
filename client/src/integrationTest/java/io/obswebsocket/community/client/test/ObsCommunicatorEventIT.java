package io.obswebsocket.community.client.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.Event.Type;
import io.obswebsocket.community.client.message.event.config.CurrentProfileChangedEvent;
import io.obswebsocket.community.client.message.event.config.CurrentSceneCollectionChangedEvent;
import io.obswebsocket.community.client.message.event.config.ProfileListChangedEvent;
import io.obswebsocket.community.client.message.event.config.SceneCollectionListChangedEvent;
import io.obswebsocket.community.client.message.event.filters.FilterCreatedEvent;
import io.obswebsocket.community.client.message.event.filters.FilterNameChangedEvent;
import io.obswebsocket.community.client.message.event.general.ExitStartedEvent;
import io.obswebsocket.community.client.message.event.general.StudioModeStateChangedEvent;
import io.obswebsocket.community.client.message.event.general.VendorEvent;
import io.obswebsocket.community.client.message.event.highvolume.InputActiveStateChangedEvent;
import io.obswebsocket.community.client.message.event.highvolume.InputShowStateChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputAudioSyncOffsetChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputAudioTracksChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputCreatedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputMuteStateChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputNameChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputRemovedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputVolumeChangedEvent;
import io.obswebsocket.community.client.message.event.mediainputs.MediaInputActionTriggeredEvent;
import io.obswebsocket.community.client.message.event.mediainputs.MediaInputPlaybackEndedEvent;
import io.obswebsocket.community.client.message.event.mediainputs.MediaInputPlaybackStartedEvent;
import io.obswebsocket.community.client.message.event.outputs.RecordStateChangedEvent;
import io.obswebsocket.community.client.message.event.outputs.ReplayBufferSavedEvent;
import io.obswebsocket.community.client.message.event.outputs.ReplayBufferStateChangedEvent;
import io.obswebsocket.community.client.message.event.outputs.StreamStateChangedEvent;
import io.obswebsocket.community.client.message.event.outputs.VirtualcamStateChangedEvent;
import io.obswebsocket.community.client.message.event.sceneitems.SceneItemCreatedEvent;
import io.obswebsocket.community.client.message.event.sceneitems.SceneItemEnableStateChangedEvent;
import io.obswebsocket.community.client.message.event.sceneitems.SceneItemListReindexedEvent;
import io.obswebsocket.community.client.message.event.sceneitems.SceneItemLockStateChangedEvent;
import io.obswebsocket.community.client.message.event.sceneitems.SceneItemRemovedEvent;
import io.obswebsocket.community.client.message.event.scenes.CurrentPreviewSceneChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.CurrentProgramSceneChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.SceneCreatedEvent;
import io.obswebsocket.community.client.message.event.scenes.SceneListChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.SceneNameChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.SceneRemovedEvent;
import io.obswebsocket.community.client.message.event.transitions.CurrentTransitionChangedEvent;
import io.obswebsocket.community.client.message.event.transitions.TransitionCreatedEvent;
import io.obswebsocket.community.client.message.event.transitions.TransitionEndedEvent;
import io.obswebsocket.community.client.message.event.transitions.TransitionNameChangedEvent;
import io.obswebsocket.community.client.message.event.transitions.TransitionRemovedEvent;
import io.obswebsocket.community.client.message.event.transitions.TransitionStartedEvent;
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
    AtomicReference<VendorEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(VendorEvent.class, actualTestResult::set)
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
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(),
        "inputName");
  }

  @Test
  void inputVolumeChangedEventTriggered() {
    // Given the communicator is initialized with a InputVolumeChangedEvent listener
    AtomicReference<InputVolumeChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(InputVolumeChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid InputVolumeChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'InputVolumeChanged',\n"
        + "\t\t'eventIntent': " + (1 << 3) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputName': 'inputName',\n"
        + "\t\t\t'inputVolumeMul': 3.9,\n"
        + "\t\t\t'inputVolumeDb': 6.6\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Event.Type.InputVolumeChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(),
        "inputName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputVolumeMul(), 3.9f);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputVolumeDb(), 6.6f);
  }

  @Test
  void mediaInputActionTriggeredEventTriggered() {
    // Given the communicator is initialized with a MediaInputActionTriggeredEvent listener
    AtomicReference<MediaInputActionTriggeredEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(MediaInputActionTriggeredEvent.class, actualTestResult::set)
        .build();

    // When a valid MediaInputActionTriggeredEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'MediaInputActionTriggered',\n"
        + "\t\t'eventIntent': " + (1 << 8) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'inputName': 'inputName',\n"
        + "\t\t\t'mediaAction': 'action'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.MediaInputActionTriggered);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(),
        "inputName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getMediaAction(),
        "action");
  }

  @Test
  void mediaInputPlaybackEndedEventTriggered() {
    // Given the communicator is initialized with a MediaInputPlaybackEndedEvent listener
    AtomicReference<MediaInputPlaybackEndedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(MediaInputPlaybackEndedEvent.class, actualTestResult::set)
        .build();

    // When a valid MediaInputPlaybackEndedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'MediaInputPlaybackEnded',\n"
        + "\t\t'eventIntent': " + (1 << 8) + ",\n"
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
        Type.MediaInputPlaybackEnded);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(),
        "inputName");
  }

  @Test
  void mediaInputPlaybackStartedEventTriggered() {
    // Given the communicator is initialized with a MediaInputPlaybackStartedEvent listener
    AtomicReference<MediaInputPlaybackStartedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(MediaInputPlaybackStartedEvent.class, actualTestResult::set)
        .build();

    // When a valid MediaInputPlaybackStartedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'MediaInputPlaybackStarted',\n"
        + "\t\t'eventIntent': " + (1 << 8) + ",\n"
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
        Type.MediaInputPlaybackStarted);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getInputName(),
        "inputName");
  }

  @Test
  void recordStateChangedEventTriggered() {
    // Given the communicator is initialized with a RecordStateChangedEvent listener
    AtomicReference<RecordStateChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(RecordStateChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid RecordStateChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'RecordStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 6) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'outputActive': true,\n"
        + "\t\t\t'outputState': 'state1'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.RecordStateChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOutputActive(), true);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOutputState(), "state1");
  }

  @Test
  void replayBufferSavedEventTriggered() {
    // Given the communicator is initialized with a ReplayBufferSavedEvent listener
    AtomicReference<ReplayBufferSavedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(ReplayBufferSavedEvent.class, actualTestResult::set)
        .build();

    // When a valid ReplayBufferSavedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'ReplayBufferSaved',\n"
        + "\t\t'eventIntent': " + (1 << 6) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'savedReplayPath': 'path/to/replay'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.ReplayBufferSaved);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSavedReplayPath(), "path/to/replay");
  }

  @Test
  void replayBufferStateChangedEventTriggered() {
    // Given the communicator is initialized with a ReplayBufferStateChangedEvent listener
    AtomicReference<ReplayBufferStateChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(ReplayBufferStateChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid ReplayBufferStateChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'ReplayBufferStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 6) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'outputActive': true,\n"
        + "\t\t\t'outputState': 'state2'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.ReplayBufferStateChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOutputActive(), true);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOutputState(), "state2");
  }

  @Test
  void streamStateChangedEventTriggered() {
    // Given the communicator is initialized with a StreamStateChangedEvent listener
    AtomicReference<StreamStateChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(StreamStateChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid StreamStateChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'StreamStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 6) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'outputActive': false,\n"
        + "\t\t\t'outputState': 'state3'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.StreamStateChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOutputActive(), false);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOutputState(), "state3");
  }

  @Test
  void virtualcamStateChangedEventTriggered() {
    // Given the communicator is initialized with a VirtualcamStateChangedEvent listener
    AtomicReference<VirtualcamStateChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(VirtualcamStateChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid VirtualcamStateChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'VirtualcamStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 6) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'outputActive': true,\n"
        + "\t\t\t'outputState': 'state4'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.VirtualcamStateChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOutputActive(), true);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOutputState(), "state4");
  }

  @Test
  void sceneItemCreatedEvent() {
    // Given the communicator is initialized with a SceneItemCreatedEvent listener
    AtomicReference<SceneItemCreatedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneItemCreatedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneItemCreatedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneItemCreated',\n"
        + "\t\t'eventIntent': " + (1 << 7) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneItemCreated);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
  }

  @Test
  void sceneItemEnableStateChangedEventTriggered() {
    // Given the communicator is initialized with a SceneItemEnableStateChangedEvent listener
    AtomicReference<SceneItemEnableStateChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneItemEnableStateChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneItemEnableStateChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneItemEnableStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 7) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName',\n"
        + "\t\t\t'sceneItemId': 73354,\n"
        + "\t\t\t'sceneItemEnabled': false\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneItemEnableStateChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneItemId(), 73354);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneItemEnabled(), false);
  }

  @Test
  void sceneItemListReindexedEventTriggered() {
    // Given the communicator is initialized with a SceneItemListReindexedEvent listener
    AtomicReference<SceneItemListReindexedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneItemListReindexedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneItemCreatedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneItemListReindexed',\n"
        + "\t\t'eventIntent': " + (1 << 7) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName',\n"
        + "\t\t\t'sceneItems': [\n"
        + "\t\t\t\t{\n"
        + "\t\t\t\t\t'sceneItemId': 9732,\n"
        + "\t\t\t\t\t'sceneItemIndex': 5\n"
        + "\t\t\t\t}\n"
        + "\t\t\t]\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneItemListReindexed);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneItems().get(0).getSceneItemId(), 9732);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneItems().get(0).getSceneItemIndex(), 5);
  }

  @Test
  void sceneItemLockStateChangedEventTriggered() {
    // Given the communicator is initialized with a SceneItemLockStateChangedEvent listener
    AtomicReference<SceneItemLockStateChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneItemLockStateChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneItemLockStateChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneItemLockStateChanged',\n"
        + "\t\t'eventIntent': " + (1 << 7) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName',\n"
        + "\t\t\t'sceneItemId': 38854,\n"
        + "\t\t\t'sceneItemLocked': true\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneItemLockStateChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneItemId(), 38854);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneItemLocked(), true);
  }

  @Test
  void sceneItemRemovedEventTriggered() {
    // Given the communicator is initialized with a SceneItemRemovedEvent listener
    AtomicReference<SceneItemRemovedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneItemRemovedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneItemRemovedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneItemRemoved',\n"
        + "\t\t'eventIntent': " + (1 << 7) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneItemRemoved);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
  }

  @Test
  void currentPreviewSceneChangedEventTriggered() {
    // Given the communicator is initialized with a CurrentPreviewSceneChangedEvent listener
    AtomicReference<CurrentPreviewSceneChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(CurrentPreviewSceneChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid CurrentPreviewSceneChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'CurrentPreviewSceneChanged',\n"
        + "\t\t'eventIntent': " + (1 << 2) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.CurrentPreviewSceneChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
  }

  @Test
  void currentProgramSceneChangedEventTriggered() {
    // Given the communicator is initialized with a CurrentProgramSceneChangedEvent listener
    AtomicReference<CurrentProgramSceneChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(CurrentProgramSceneChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid CurrentProgramSceneChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'CurrentProgramSceneChanged',\n"
        + "\t\t'eventIntent': " + (1 << 2) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.CurrentProgramSceneChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
  }

  @Test
  void sceneCreatedEventTriggered() {
    // Given the communicator is initialized with a SceneCreatedEvent listener
    AtomicReference<SceneCreatedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneCreatedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneCreatedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneCreated',\n"
        + "\t\t'eventIntent': " + (1 << 2) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName',\n"
        + "\t\t\t'isGroup': false\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneCreated);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getIsGroup(), false);
  }

  @Test
  void sceneListChangedEventTriggered() {
    // Given the communicator is initialized with a SceneListChangedEvent listener
    AtomicReference<SceneListChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneListChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneListChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneListChanged',\n"
        + "\t\t'eventIntent': " + (1 << 2) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'scenes': [\n"
        + "\t\t\t\t{\n"
        + "\t\t\t\t'sceneName': 'sceneName',\n"
        + "\t\t\t\t'sceneIndex': 5,\n"
        + "\t\t\t\t'isGroup': true\n"
        + "\t\t\t\t}\n"
        + "\t\t\t]\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneListChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getScenes().get(0).getSceneName(), "sceneName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getScenes().get(0).getSceneIndex(), 5);
    assertTrue(actualTestResult.get().getMessageData().getEventData().getScenes().get(0).isGroup());
  }

  @Test
  void sceneNameChangedEventTriggered() {
    // Given the communicator is initialized with a SceneNameChangedEvent listener
    AtomicReference<SceneNameChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneNameChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneNameChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneNameChanged',\n"
        + "\t\t'eventIntent': " + (1 << 2) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName',\n"
        + "\t\t\t'oldSceneName': 'oldSceneName'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneNameChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(), "sceneName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOldSceneName(), "oldSceneName");
  }

  @Test
  void sceneRemovedEventTriggered() {
    // Given the communicator is initialized with a SceneRemovedEvent listener
    AtomicReference<SceneRemovedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(SceneRemovedEvent.class, actualTestResult::set)
        .build();

    // When a valid SceneNameChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'SceneRemoved',\n"
        + "\t\t'eventIntent': " + (1 << 2) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'sceneName': 'sceneName',\n"
        + "\t\t\t'isGroup': false\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.SceneRemoved);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getSceneName(),
        "sceneName");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getIsGroup(), false);
  }

  @Test
  void currentTransitionChangedEventTriggered() {
    // Given the communicator is initialized with a CurrentTransitionChangedEvent listener
    AtomicReference<CurrentTransitionChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(CurrentTransitionChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid CurrentTransitionChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'CurrentTransitionChanged',\n"
        + "\t\t'eventIntent': " + (1 << 4) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'transitionName': 'transition-changed'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.CurrentTransitionChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getTransitionName(),
        "transition-changed");
  }

  @Test
  void transitionCreatedEventTriggered() {
    // Given the communicator is initialized with a TransitionCreatedEvent listener
    AtomicReference<TransitionCreatedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(TransitionCreatedEvent.class, actualTestResult::set)
        .build();

    // When a valid TransitionCreatedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'TransitionCreated',\n"
        + "\t\t'eventIntent': " + (1 << 4) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'transitionName': 'transition-created'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.TransitionCreated);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getTransitionName(),
        "transition-created");
  }

  @Test
  void transitionEndedEventTriggered() {
    // Given the communicator is initialized with a TransitionEndedEvent listener
    AtomicReference<TransitionEndedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(TransitionEndedEvent.class, actualTestResult::set)
        .build();

    // When a valid TransitionEndedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'TransitionEnded',\n"
        + "\t\t'eventIntent': " + (1 << 4) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'transitionName': 'transition-ended'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.TransitionEnded);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getTransitionName(),
        "transition-ended");
  }

  @Test
  void transitionNameChangedEventTriggered() {
    // Given the communicator is initialized with a TransitionNameChangedEvent listener
    AtomicReference<TransitionNameChangedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(TransitionNameChangedEvent.class, actualTestResult::set)
        .build();

    // When a valid TransitionNameChangedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'TransitionNameChanged',\n"
        + "\t\t'eventIntent': " + (1 << 4) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'transitionName': 'transition-new',\n"
        + "\t\t\t'oldTransitionName': 'transition-old'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.TransitionNameChanged);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getTransitionName(),
        "transition-new");
    assertEquals(actualTestResult.get().getMessageData().getEventData().getOldTransitionName(),
        "transition-old");
  }

  @Test
  void transitionRemovedEventTriggered() {
    // Given the communicator is initialized with a TransitionRemovedEvent listener
    AtomicReference<TransitionRemovedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(TransitionRemovedEvent.class, actualTestResult::set)
        .build();

    // When a valid TransitionRemovedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'TransitionRemoved',\n"
        + "\t\t'eventIntent': " + (1 << 4) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'transitionName': 'transition-removed'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.TransitionRemoved);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getTransitionName(),
        "transition-removed");
  }

  @Test
  void transitionStartedEventTriggered() {
    // Given the communicator is initialized with a TransitionStartedEvent listener
    AtomicReference<TransitionStartedEvent> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
        .registerEventListener(TransitionStartedEvent.class, actualTestResult::set)
        .build();

    // When a valid TransitionStartedEvent JSON object is supplied
    String eventMessage = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'TransitionStarted',\n"
        + "\t\t'eventIntent': " + (1 << 4) + ",\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'transitionName': 'transition-started'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";
    connector.onMessage(eventMessage);

    // Then the event listener will be called
    assertNotNull(actualTestResult.get());
    // And will receive the Event instance object
    Assertions.assertEquals(actualTestResult.get().getMessageData().getEventType(),
        Type.TransitionStarted);
    assertEquals(actualTestResult.get().getMessageData().getEventData().getTransitionName(),
        "transition-started");
  }
}
