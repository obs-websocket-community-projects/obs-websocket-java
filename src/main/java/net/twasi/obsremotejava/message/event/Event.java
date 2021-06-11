package net.twasi.obsremotejava.message.event;

import net.twasi.obsremotejava.message.Message;

import java.util.HashMap;

public abstract class Event extends Message {
    public static HashMap<Event.Type, Class<? extends Event>> EVENT_REGISTRY = new HashMap<>();

    static {
        Message.registerMessageType(Message.Type.Event, Event.class);
    }

    protected Type eventType;

    protected Event(Type eventType) {
        super(Message.Type.Event);

        this.eventType = eventType;
    }

    public Type getEventType() {
        return this.eventType;
    }

    public enum Type {
        RecordingStarted,
        RecordingStopped,
        ReplayStarting,
        ReplayStarted,
        ReplayStopping,
        ReplayStopped,
        StreamStarted,
        StreamStopped,
        SwitchScenes,
        ScenesChanged,
        SourceFilterVisibilityChanged,
        SourceVolumeChanged,
        SwitchTransition,
        TransitionListChanged,
        TransitionBegin,
        TransitionEnd,
        PreviewSceneChanged,
        MediaPlaying,
        MediaPaused,
        MediaRestarted,
        MediaStopped,
        MediaNext,
        MediaPrevious,
        MediaStarted,
        MediaEnded,
    }

    public static void registerEventType(Event.Type eventType, Class<? extends Event> clazz) {
        Event.EVENT_REGISTRY.put(eventType, clazz);
    }
}
