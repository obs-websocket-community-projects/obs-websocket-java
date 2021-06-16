package net.twasi.obsremotejava.message.request;

import java.util.UUID;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.request.config.*;
import net.twasi.obsremotejava.message.request.general.*;
import net.twasi.obsremotejava.message.request.scenes.GetCurrentProgramSceneRequest;
import net.twasi.obsremotejava.message.request.scenes.GetSceneListRequest;
import net.twasi.obsremotejava.message.request.scenes.RemoveSceneRequest;
import net.twasi.obsremotejava.message.request.scenes.SetSceneNameRequest;
import net.twasi.obsremotejava.message.request.sources.GetSourceActiveRequest;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.config.*;
import net.twasi.obsremotejava.message.response.general.*;
import net.twasi.obsremotejava.message.response.scenes.GetCurrentProgramSceneResponse;
import net.twasi.obsremotejava.message.response.scenes.GetSceneListResponse;
import net.twasi.obsremotejava.message.response.scenes.RemoveSceneResponse;
import net.twasi.obsremotejava.message.response.scenes.SetSceneNameResponse;
import net.twasi.obsremotejava.message.response.sources.GetSourceActiveResponse;

@Getter
@ToString(callSuper = true)
public abstract class Request extends Message {
    protected Type requestType;
    protected String requestId;

    public Request(Type type) {
        super(Message.Type.Request);

        this.requestType = type;
        this.requestId = UUID.randomUUID().toString();
    }

    @Getter
    public enum Type {
        // General
        GetVersion(GetVersionRequest.class, GetVersionResponse.class),
        BroadcastCustomEvent(BroadcastCustomEventRequest.class, BroadcastCustomEventResponse.class),
        GetHotkeyList(GetHotkeyListRequest.class, GetHotkeyListResponse.class),
        TriggerHotkeyByName(TriggerHotkeyByNameRequest.class, TriggerHotkeyByNameResponse.class),
        TriggerHotkeyByKeySequence(TriggerHotkeyByKeySequenceRequest.class, TriggerHotkeyByKeySequenceResponse.class),
        GetStudioModeEnabled(GetStudioModeEnabledRequest.class, GetStudioModeEnabledResponse.class),
        SetStudioModeEnabled(SetStudioModeEnabledRequest.class, SetStudioModeEnabledResponse.class),
        Sleep(SleepRequest.class, SleepResponse.class),

        // Config
        GetSceneCollectionList(GetSceneCollectionListRequest.class, GetSceneCollectionListResponse.class),
        SetCurrentSceneCollection(SetCurrentSceneCollectionRequest.class, SetCurrentSceneCollectionResponse.class),
        CreateSceneCollection(CreateSceneCollectionRequest.class, CreateSceneCollectionResponse.class),
        DeleteSceneCollection(DeleteSceneCollectionRequest.class, DeleteSceneCollectionResponse.class),
        GetProfileParameter(GetProfileParameterRequest.class, GetProfileParameterResponse.class),
        SetProfileParameter(SetProfileParameterRequest.class, SetProfileParameterResponse.class),

        // Scenes
        GetSceneList(GetSceneListRequest.class, GetSceneListResponse.class),
        GetCurrentProgramScene(GetCurrentProgramSceneRequest.class, GetCurrentProgramSceneResponse.class),
        SetSceneName(SetSceneNameRequest.class, SetSceneNameResponse.class),
        RemoveScene(RemoveSceneRequest.class, RemoveSceneResponse.class),

        // Sources
        GetSourceActive(GetSourceActiveRequest.class, GetSourceActiveResponse.class),
        ;

        private final Class<? extends Request> requestClass;
        private final Class<? extends RequestResponse> requestResponseClass;

        Type(Class<? extends Request> requestClass, Class<? extends RequestResponse> requestResponseClass) {
            this.requestClass = requestClass;
            this.requestResponseClass = requestResponseClass;
        }
    }
}
