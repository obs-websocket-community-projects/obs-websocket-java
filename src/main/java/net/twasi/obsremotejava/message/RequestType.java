package net.twasi.obsremotejava.message;

public enum RequestType {
    GetVersion,
    GetAuthRequired,
    Authenticate,

    SetCurrentScene,
    GetSceneList,
    GetCurrentScene,
    GetSourcesList,

    SetCurrentTransition,

    GetSceneItemProperties,
    SetSceneItemProperties,

    GetTransitionList,

    GetStudioModeStatus,
    EnableStudioMode,
    DisableStudioMode,
    TransitionToProgram,
    GetPreviewScene,
    SetPreviewScene,

    GetSourceSettings,
    SetSourceSettings,
    GetSourceFilters,
    GetSourceFilterInfo,
    SetSourceFilterSettings,
    SetSourceFilterVisibility,
    TakeSourceScreenshot,

    GetStreamingStatus,
    StartRecording,
    StopRecording,
    StartStreaming,
    StopStreaming,

    SetCurrentProfile,
    GetCurrentProfile,
    ListProfiles,

    SetVolume,
    SetMute,
    GetVolume,
    GetMute,
    ToggleMute,

    GetTransitionDuration,
    SetTransitionDuration,

    StartReplayBuffer,
    StopReplayBuffer,
    SaveReplayBuffer,

    PlayPauseMedia,
    RestartMedia,
    StopMedia,
    NextMedia,
    PreviousMedia,

    RefreshBrowserSource,

    GetAudioMonitorType,
    SetAudioMonitorType,

    GetSpecialSources,

    TriggerHotkeyByName,
}
