package net.twasi.obsremotejava.message;

public abstract class Event extends Message {
    protected Type eventType;

    protected Event(Type eventType) {
        super(Message.Type.Event);
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
}
