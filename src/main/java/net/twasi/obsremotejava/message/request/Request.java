package net.twasi.obsremotejava.message.request;

import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.event.Event;

import java.util.HashMap;
import java.util.UUID;

public abstract class Request extends Message {
    public static HashMap<Request.Type, Class<? extends Request>> REQUEST_REGISTRY = new HashMap<>();

    static {
        Message.registerMessageType(Message.Type.Request, Request.class);
    }

    protected Type requestType;
    protected String requestId;

    public Request(Type type) {
        super(Message.Type.Request);

        this.requestType = type;
        this.requestId = UUID.randomUUID().toString();
    }

    public enum Type {
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

    public static void registerRequestType(Request.Type requestType, Class<? extends Request> clazz) {
        Request.REQUEST_REGISTRY.put(requestType, clazz);
    }
}
