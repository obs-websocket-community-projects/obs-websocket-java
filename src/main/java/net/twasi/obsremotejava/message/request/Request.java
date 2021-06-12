package net.twasi.obsremotejava.message.request;

import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.request.general.GetVersion;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.scenes.GetSceneList;

import java.util.UUID;

public abstract class Request extends Message {
    protected Type requestType;
    protected String requestId;

    public Request(Type type) {
        super(Message.Type.Request);

        this.requestType = type;
        this.requestId = UUID.randomUUID().toString();
    }

    public Type getRequestType() {
        return this.requestType;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public enum Type {
        GetVersion(net.twasi.obsremotejava.message.request.general.GetVersion.class, net.twasi.obsremotejava.message.response.general.GetVersion.class),
        GetAuthRequired(null, null),
        Authenticate(null, null),

        SetCurrentScene(null, null),
        GetSceneList(net.twasi.obsremotejava.message.request.scenes.GetSceneList.class, net.twasi.obsremotejava.message.response.scenes.GetSceneList.class),
        GetCurrentScene(null, null),
        GetSourcesList(null, null),

        SetCurrentTransition(null, null),

        GetSceneItemProperties(null, null),
        SetSceneItemProperties(null, null),

        GetTransitionList(null, null),

        GetStudioModeStatus(null, null),
        EnableStudioMode(null, null),
        DisableStudioMode(null, null),
        TransitionToProgram(null, null),
        GetPreviewScene(null, null),
        SetPreviewScene(null, null),

        GetSourceSettings(null, null),
        SetSourceSettings(null, null),
        GetSourceFilters(null, null),
        GetSourceFilterInfo(null, null),
        SetSourceFilterSettings(null, null),
        SetSourceFilterVisibility(null, null),
        TakeSourceScreenshot(null, null),

        GetStreamingStatus(null, null),
        StartRecording(null, null),
        StopRecording(null, null),
        StartStreaming(null, null),
        StopStreaming(null, null),

        SetCurrentProfile(null, null),
        GetCurrentProfile(null, null),
        ListProfiles(null, null),

        SetVolume(null, null),
        SetMute(null, null),
        GetVolume(null, null),
        GetMute(null, null),
        ToggleMute(null, null),

        GetTransitionDuration(null, null),
        SetTransitionDuration(null, null),

        StartReplayBuffer(null, null),
        StopReplayBuffer(null, null),
        SaveReplayBuffer(null, null),

        PlayPauseMedia(null, null),
        RestartMedia(null, null),
        StopMedia(null, null),
        NextMedia(null, null),
        PreviousMedia(null, null),

        RefreshBrowserSource(null, null),

        GetAudioMonitorType(null, null),
        SetAudioMonitorType(null, null),

        GetSpecialSources(null, null),

        TriggerHotkeyByName(null, null);

        private final Class<? extends Request> requestClass;
        private final Class<? extends RequestResponse> requestResponseClass;

        Type(Class<? extends Request> requestClass, Class<? extends RequestResponse> requestResponseClass) {
            this.requestClass = requestClass;
            this.requestResponseClass = requestResponseClass;
        }

        public Class<? extends Request> getRequestClass() {
            return this.requestClass;
        }

        public Class<? extends RequestResponse> getRequestResponseClass() {
            return this.requestResponseClass;
        }
    }
}
