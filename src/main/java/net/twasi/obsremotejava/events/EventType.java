package net.twasi.obsremotejava.events;

public enum EventType {
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
    SwitchTransition,
    TransitionListChanged,
    TransitionBegin,
    TransitionEnd
}
