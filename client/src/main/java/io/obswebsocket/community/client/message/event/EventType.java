// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event;

import io.obswebsocket.community.client.message.event.config.CurrentProfileChangedEvent;
import io.obswebsocket.community.client.message.event.config.CurrentProfileChangingEvent;
import io.obswebsocket.community.client.message.event.config.CurrentSceneCollectionChangedEvent;
import io.obswebsocket.community.client.message.event.config.CurrentSceneCollectionChangingEvent;
import io.obswebsocket.community.client.message.event.config.ProfileListChangedEvent;
import io.obswebsocket.community.client.message.event.config.SceneCollectionListChangedEvent;
import io.obswebsocket.community.client.message.event.filters.SourceFilterCreatedEvent;
import io.obswebsocket.community.client.message.event.filters.SourceFilterEnableStateChangedEvent;
import io.obswebsocket.community.client.message.event.filters.SourceFilterListReindexedEvent;
import io.obswebsocket.community.client.message.event.filters.SourceFilterNameChangedEvent;
import io.obswebsocket.community.client.message.event.filters.SourceFilterRemovedEvent;
import io.obswebsocket.community.client.message.event.general.CustomEventEvent;
import io.obswebsocket.community.client.message.event.general.ExitStartedEvent;
import io.obswebsocket.community.client.message.event.general.VendorEventEvent;
import io.obswebsocket.community.client.message.event.inputs.InputActiveStateChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputAudioBalanceChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputAudioMonitorTypeChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputAudioSyncOffsetChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputAudioTracksChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputCreatedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputMuteStateChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputNameChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputRemovedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputShowStateChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputVolumeChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputVolumeMetersEvent;
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
import io.obswebsocket.community.client.message.event.sceneitems.SceneItemSelectedEvent;
import io.obswebsocket.community.client.message.event.sceneitems.SceneItemTransformChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.CurrentPreviewSceneChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.CurrentProgramSceneChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.SceneCreatedEvent;
import io.obswebsocket.community.client.message.event.scenes.SceneListChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.SceneNameChangedEvent;
import io.obswebsocket.community.client.message.event.scenes.SceneRemovedEvent;
import io.obswebsocket.community.client.message.event.transitions.CurrentSceneTransitionChangedEvent;
import io.obswebsocket.community.client.message.event.transitions.CurrentSceneTransitionDurationChangedEvent;
import io.obswebsocket.community.client.message.event.transitions.SceneTransitionEndedEvent;
import io.obswebsocket.community.client.message.event.transitions.SceneTransitionStartedEvent;
import io.obswebsocket.community.client.message.event.transitions.SceneTransitionVideoEndedEvent;
import io.obswebsocket.community.client.message.event.ui.ScreenshotSavedEvent;
import io.obswebsocket.community.client.message.event.ui.StudioModeStateChangedEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventType {
  CurrentSceneCollectionChanging(CurrentSceneCollectionChangingEvent.class),

  CurrentSceneCollectionChanged(CurrentSceneCollectionChangedEvent.class),

  SceneCollectionListChanged(SceneCollectionListChangedEvent.class),

  CurrentProfileChanging(CurrentProfileChangingEvent.class),

  CurrentProfileChanged(CurrentProfileChangedEvent.class),

  ProfileListChanged(ProfileListChangedEvent.class),

  SourceFilterListReindexed(SourceFilterListReindexedEvent.class),

  SourceFilterCreated(SourceFilterCreatedEvent.class),

  SourceFilterRemoved(SourceFilterRemovedEvent.class),

  SourceFilterNameChanged(SourceFilterNameChangedEvent.class),

  SourceFilterEnableStateChanged(SourceFilterEnableStateChangedEvent.class),

  ExitStarted(ExitStartedEvent.class),

  InputCreated(InputCreatedEvent.class),

  InputRemoved(InputRemovedEvent.class),

  InputNameChanged(InputNameChangedEvent.class),

  InputActiveStateChanged(InputActiveStateChangedEvent.class),

  InputShowStateChanged(InputShowStateChangedEvent.class),

  InputMuteStateChanged(InputMuteStateChangedEvent.class),

  InputVolumeChanged(InputVolumeChangedEvent.class),

  InputAudioBalanceChanged(InputAudioBalanceChangedEvent.class),

  InputAudioSyncOffsetChanged(InputAudioSyncOffsetChangedEvent.class),

  InputAudioTracksChanged(InputAudioTracksChangedEvent.class),

  InputAudioMonitorTypeChanged(InputAudioMonitorTypeChangedEvent.class),

  InputVolumeMeters(InputVolumeMetersEvent.class),

  MediaInputPlaybackStarted(MediaInputPlaybackStartedEvent.class),

  MediaInputPlaybackEnded(MediaInputPlaybackEndedEvent.class),

  MediaInputActionTriggered(MediaInputActionTriggeredEvent.class),

  StreamStateChanged(StreamStateChangedEvent.class),

  RecordStateChanged(RecordStateChangedEvent.class),

  ReplayBufferStateChanged(ReplayBufferStateChangedEvent.class),

  VirtualcamStateChanged(VirtualcamStateChangedEvent.class),

  ReplayBufferSaved(ReplayBufferSavedEvent.class),

  SceneItemCreated(SceneItemCreatedEvent.class),

  SceneItemRemoved(SceneItemRemovedEvent.class),

  SceneItemListReindexed(SceneItemListReindexedEvent.class),

  SceneItemEnableStateChanged(SceneItemEnableStateChangedEvent.class),

  SceneItemLockStateChanged(SceneItemLockStateChangedEvent.class),

  SceneItemSelected(SceneItemSelectedEvent.class),

  SceneItemTransformChanged(SceneItemTransformChangedEvent.class),

  SceneCreated(SceneCreatedEvent.class),

  SceneRemoved(SceneRemovedEvent.class),

  SceneNameChanged(SceneNameChangedEvent.class),

  CurrentProgramSceneChanged(CurrentProgramSceneChangedEvent.class),

  CurrentPreviewSceneChanged(CurrentPreviewSceneChangedEvent.class),

  SceneListChanged(SceneListChangedEvent.class),

  CurrentSceneTransitionChanged(CurrentSceneTransitionChangedEvent.class),

  CurrentSceneTransitionDurationChanged(CurrentSceneTransitionDurationChangedEvent.class),

  SceneTransitionStarted(SceneTransitionStartedEvent.class),

  SceneTransitionEnded(SceneTransitionEndedEvent.class),

  SceneTransitionVideoEnded(SceneTransitionVideoEndedEvent.class),

  StudioModeStateChanged(StudioModeStateChangedEvent.class),

  ScreenshotSaved(ScreenshotSavedEvent.class),

  VendorEvent(VendorEventEvent.class),

  CustomEvent(CustomEventEvent.class);

  private final Class<? extends Event> eventClass;

  static EventType from(Class<? extends Event> eventClass) {
    for (EventType type : values()) {
      if (type.eventClass.equals(eventClass)) {
        return type;
      }
    }
    return null;
  }
}
