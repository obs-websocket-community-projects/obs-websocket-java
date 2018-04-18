package net.diespendendose.obsremotejava.requests;

public enum RequestType {

    GetVersion,
    GetAuthRequired,

    SetCurrentScene,
    GetSceneList,

    SetCurrentTransition,

    GetSceneItemProperties,
    SetSceneItemProperties,

    GetTransitionList,

    TransitionToProgram,

    GetSourceSettings,
    SetSourceSettings,

    GetStreamingStatus,
    StartStreaming,
    StopStreaming,

    SetCurrentProfile,
    GetCurrentProfile,
    ListProfiles

}
