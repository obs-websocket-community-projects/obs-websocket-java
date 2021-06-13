package net.twasi.obsremotejava.message.event;

import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.event.config.CurrentProfileChanged;
import net.twasi.obsremotejava.message.event.config.CurrentSceneCollectionChanged;
import net.twasi.obsremotejava.message.event.config.ProfileListChanged;
import net.twasi.obsremotejava.message.event.config.SceneCollectionListChanged;
import net.twasi.obsremotejava.message.event.general.CustomEvent;
import net.twasi.obsremotejava.message.event.general.ExitStarted;
import net.twasi.obsremotejava.message.event.general.StudioModeStateChanged;
import net.twasi.obsremotejava.message.event.input.InputVolumeChanged;
import net.twasi.obsremotejava.message.event.media.MediaInputActionTriggered;
import net.twasi.obsremotejava.message.event.outputs.*;
import net.twasi.obsremotejava.message.event.scenes.*;

public abstract class Event extends Message {
    protected Type eventType;
    protected transient Category category;

    protected Event(Type eventType, Category category) {
        super(Message.Type.Event);

        this.eventType = eventType;
        this.category = category;
    }

    public Type getEventType() {
        return this.eventType;
    }

    public enum Type {
        // General
        ExitStarted(ExitStarted.class),
        StudioModeStateChanged(StudioModeStateChanged.class),
        CustomEvent(CustomEvent.class),

        // Config
        CurrentSceneCollectionChanged(CurrentSceneCollectionChanged.class),
        CurrentProfileChanged(CurrentProfileChanged.class),
        SceneCollectionListChanged(SceneCollectionListChanged.class),
        ProfileListChanged(ProfileListChanged.class),

        // Scenes
        SceneCreated(SceneCreated.class),
        SceneRemoved(SceneRemoved.class),
        SceneNameChanged(SceneNameChanged.class),
        CurrentSceneChanged(CurrentPreviewSceneChanged.class),
        CurrentPreviewSceneChanged(CurrentPreviewSceneChanged.class),
        SceneListReindexed(SceneListReindexed.class),

        RecordStateChanged(RecordStateChanged.class),
        StreamStateChanged(StreamStateChanged.class),
        ReplayBufferStateChanged(ReplayBufferStateChanged.class),
        VirtualcamStateChanged(VirtualcamStateChanged.class),
        ReplayBufferSaved(ReplayBufferSaved.class),
        MediaInputActionTriggered(MediaInputActionTriggered.class),
        InputVolumeChanged(InputVolumeChanged.class),
        ;

        private final Class<? extends Event> clazz;

        Type(Class<? extends Event> clazz) {
            this.clazz = clazz;
        }

        public Class<? extends Event> getClazz() {
            return this.clazz;
        }
    }

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
        ;

        private final int value;

        Category(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
