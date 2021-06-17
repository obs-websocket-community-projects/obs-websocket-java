package net.twasi.obsremotejava.message.event;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.event.config.CurrentProfileChangedEvent;
import net.twasi.obsremotejava.message.event.config.CurrentSceneCollectionChangedEvent;
import net.twasi.obsremotejava.message.event.config.ProfileListChangedEvent;
import net.twasi.obsremotejava.message.event.config.SceneCollectionListChangedEvent;
import net.twasi.obsremotejava.message.event.general.CustomEvent;
import net.twasi.obsremotejava.message.event.general.ExitStartedEvent;
import net.twasi.obsremotejava.message.event.general.StudioModeStateChangedEvent;
import net.twasi.obsremotejava.message.event.highvolume.InputActiveStateChangedEvent;
import net.twasi.obsremotejava.message.event.highvolume.InputShowStateChangedEvent;
import net.twasi.obsremotejava.message.event.inputs.*;
import net.twasi.obsremotejava.message.event.mediainputs.MediaInputActionTriggeredEvent;
import net.twasi.obsremotejava.message.event.mediainputs.MediaInputPlaybackEndedEvent;
import net.twasi.obsremotejava.message.event.mediainputs.MediaInputPlaybackStartedEvent;
import net.twasi.obsremotejava.message.event.outputs.*;
import net.twasi.obsremotejava.message.event.sceneitems.*;
import net.twasi.obsremotejava.message.event.scenes.*;

@Getter
@ToString(callSuper = true)
public abstract class Event extends Message {
    protected Type eventType;
    protected transient Category category;

    protected Event(Type eventType, Category category) {
        super(Message.Type.Event);

        this.eventType = eventType;
        this.category = category;
    }

    @Getter
    public enum Type {
        // General
        ExitStarted(ExitStartedEvent.class),
        StudioModeStateChanged(StudioModeStateChangedEvent.class),
        CustomEvent(CustomEvent.class),

        // Config
        CurrentSceneCollectionChanged(CurrentSceneCollectionChangedEvent.class),
        CurrentProfileChanged(CurrentProfileChangedEvent.class),
        SceneCollectionListChanged(SceneCollectionListChangedEvent.class),
        ProfileListChanged(ProfileListChangedEvent.class),

        // Scenes
        SceneCreated(SceneCreatedEvent.class),
        SceneRemoved(SceneRemovedEvent.class),
        SceneNameChanged(SceneNameChangedEvent.class),
        CurrentSceneChanged(CurrentSceneChangedEvent.class),
        CurrentPreviewSceneChanged(CurrentPreviewSceneChangedEvent.class),
        SceneListChanged(SceneListChangedEvent.class),

        // Inputs
        InputCreated(InputCreatedEvent.class),
        InputRemoved(InputRemovedEvent.class),
        InputNameChanged(InputNameChangedEvent.class),
        InputMuteStateChanged(InputMuteStateChangedEvent.class),
        InputVolumeChanged(InputVolumeChangedEvent.class),
        InputAudioSyncOffsetChanged(InputAudioSyncOffsetChangedEvent.class),
        InputAudioTracksChanged(InputAudioTracksChangedEvent.class),

        // Outputs
        StreamStateChanged(StreamStateChangedEvent.class),
        RecordStateChanged(RecordStateChangedEvent.class),
        ReplayBufferStateChanged(ReplayBufferStateChangedEvent.class),
        VirtualcamStateChanged(VirtualcamStateChangedEvent.class),
        ReplayBufferSaved(ReplayBufferSavedEvent.class),

        // Scene Items,
        SceneItemCreated(SceneItemCreatedEvent.class),
        SceneItemRemoved(SceneItemRemovedEvent.class),
        SceneItemListReindexed(SceneItemListReindexedEvent.class),
        SceneItemEnableStateChanged(SceneItemEnableStateChangedEvent.class),
        SceneItemLockStateChanged(SceneItemLockStateChangedEvent.class),

        // Media Inputs
        MediaInputPlaybackStarted(MediaInputPlaybackStartedEvent.class),
        MediaInputPlaybackEnded(MediaInputPlaybackEndedEvent.class),
        MediaInputActionTriggered(MediaInputActionTriggeredEvent.class),

        // High-Volume
        InputActiveStateChanged(InputActiveStateChangedEvent.class),
        InputShowStateChanged(InputShowStateChangedEvent.class),
        ;

        private final Class<? extends Event> eventClass;

        Type(Class<? extends Event> eventClass) {
            this.eventClass = eventClass;
        }
    }

    @Getter
    public enum Category {
        // Set subscriptions to 0 to disable all events
        None(0),
        // Receive events in the `General` category
        General(1 << 0),
        // Receive events in the `Config` category
        Config(1 << 1),
        // Receive events in the `Scenes` category
        Scenes(1 << 2),
        // Receive events in the `Inputs` category
        Inputs(1 << 3),
        // Receive events in the `Transitions` category
        Transitions(1 << 4),
        // Receive events in the `Filters` category
        Filters(1 << 5),
        // Receive events in the `Outputs` category
        Outputs(1 << 6),
        // Receive events in the `Scene Items` category
        SceneItems(1 << 7),
        // Receive events in the `MediaInputs` category
        MediaInputs(1 << 8),
        // Receive all event categories (default subscription setting)
        All(General.value | Config.value | Scenes.value | Inputs.value | Transitions.value | Filters.value | Outputs.value | SceneItems.value | MediaInputs.value),
        // InputActiveStateChanged event (high-volume)
        InputActiveStateChanged(1 << 10),
        // InputShowStateChanged event (high-volume)
        InputShowStateChanged(1 << 11),
        ;

        private final int value;

        Category(int value) {
            this.value = value;
        }
    }
}
