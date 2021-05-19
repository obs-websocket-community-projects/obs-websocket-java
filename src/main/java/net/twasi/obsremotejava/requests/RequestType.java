package net.twasi.obsremotejava.requests;

public enum RequestType {
    GetVersion,
    GetAuthRequired,
    Authenticate,

    SetCurrentScene,
    GetSceneList,
    GetCurrentScene,

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
}
