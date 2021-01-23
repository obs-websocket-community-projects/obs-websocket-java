package net.twasi.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.twasi.obsremotejava.callbacks.*;
import net.twasi.obsremotejava.events.EventType;
import net.twasi.obsremotejava.events.responses.*;
import net.twasi.obsremotejava.objects.throwables.InvalidResponseTypeError;
import net.twasi.obsremotejava.requests.Authenticate.AuthenticateRequest;
import net.twasi.obsremotejava.requests.Authenticate.AuthenticateResponse;
import net.twasi.obsremotejava.requests.GetAuthRequired.GetAuthRequiredRequest;
import net.twasi.obsremotejava.requests.GetAuthRequired.GetAuthRequiredResponse;
import net.twasi.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileRequest;
import net.twasi.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileResponse;
import net.twasi.obsremotejava.requests.GetCurrentScene.GetCurrentSceneRequest;
import net.twasi.obsremotejava.requests.GetCurrentScene.GetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.GetPreviewScene.GetPreviewSceneRequest;
import net.twasi.obsremotejava.requests.GetPreviewScene.GetPreviewSceneResponse;
import net.twasi.obsremotejava.requests.GetSceneItemProperties.GetSceneItemPropertiesRequest;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListRequest;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.twasi.obsremotejava.requests.GetSourceFilterInfo.GetSourceFilterInfoRequest;
import net.twasi.obsremotejava.requests.GetSourceFilterInfo.GetSourceFilterInfoResponse;
import net.twasi.obsremotejava.requests.GetSourceFilters.GetSourceFiltersRequest;
import net.twasi.obsremotejava.requests.GetSourceFilters.GetSourceFiltersResponse;
import net.twasi.obsremotejava.requests.GetSourceSettings.GetSourceSettingsRequest;
import net.twasi.obsremotejava.requests.GetSourceSettings.GetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusRequest;
import net.twasi.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusResponse;
import net.twasi.obsremotejava.requests.GetStudioModeEnabled.GetStudioModeEnabledRequest;
import net.twasi.obsremotejava.requests.GetStudioModeEnabled.GetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.GetTransitionDuration.GetTransitionDurationRequest;
import net.twasi.obsremotejava.requests.GetTransitionDuration.GetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.GetTransitionList.GetTransitionListRequest;
import net.twasi.obsremotejava.requests.GetTransitionList.GetTransitionListResponse;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionRequest;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;
import net.twasi.obsremotejava.requests.GetVolume.GetVolumeRequest;
import net.twasi.obsremotejava.requests.GetVolume.GetVolumeResponse;
import net.twasi.obsremotejava.requests.ListProfiles.ListProfilesRequest;
import net.twasi.obsremotejava.requests.ListProfiles.ListProfilesResponse;
import net.twasi.obsremotejava.requests.ResponseBase;
import net.twasi.obsremotejava.requests.SaveReplayBuffer.SaveReplayBufferRequest;
import net.twasi.obsremotejava.requests.SaveReplayBuffer.SaveReplayBufferResponse;
import net.twasi.obsremotejava.requests.SetCurrentProfile.SetCurrentProfileRequest;
import net.twasi.obsremotejava.requests.SetCurrentProfile.SetCurrentProfileResponse;
import net.twasi.obsremotejava.requests.SetCurrentScene.SetCurrentSceneRequest;
import net.twasi.obsremotejava.requests.SetCurrentScene.SetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.SetCurrentTransition.SetCurrentTransitionRequest;
import net.twasi.obsremotejava.requests.SetCurrentTransition.SetCurrentTransitionResponse;
import net.twasi.obsremotejava.requests.SetMute.SetMuteRequest;
import net.twasi.obsremotejava.requests.SetMute.SetMuteResponse;
import net.twasi.obsremotejava.requests.SetPreviewScene.SetPreviewSceneRequest;
import net.twasi.obsremotejava.requests.SetPreviewScene.SetPreviewSceneResponse;
import net.twasi.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesRequest;
import net.twasi.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesResponse;
import net.twasi.obsremotejava.requests.SetSourceFilterVisibility.SetSourceFilterVisibilityRequest;
import net.twasi.obsremotejava.requests.SetSourceFilterVisibility.SetSourceFilterVisibilityResponse;
import net.twasi.obsremotejava.requests.SetSourceSettings.SetSourceSettingsRequest;
import net.twasi.obsremotejava.requests.SetSourceSettings.SetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.SetStudioModeEnabled.SetStudioModeEnabledRequest;
import net.twasi.obsremotejava.requests.SetStudioModeEnabled.SetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.SetTextGDIPlusProperties.SetTextGDIPlusPropertiesRequest;
import net.twasi.obsremotejava.requests.SetTextGDIPlusProperties.SetTextGDIPlusPropertiesResponse;
import net.twasi.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationRequest;
import net.twasi.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.SetVolume.SetVolumeRequest;
import net.twasi.obsremotejava.requests.SetVolume.SetVolumeResponse;
import net.twasi.obsremotejava.requests.StartRecording.StartRecordingRequest;
import net.twasi.obsremotejava.requests.StartRecording.StartRecordingResponse;
import net.twasi.obsremotejava.requests.StartReplayBuffer.StartReplayBufferRequest;
import net.twasi.obsremotejava.requests.StartReplayBuffer.StartReplayBufferResponse;
import net.twasi.obsremotejava.requests.StartStreaming.StartStreamingRequest;
import net.twasi.obsremotejava.requests.StartStreaming.StartStreamingResponse;
import net.twasi.obsremotejava.requests.StopRecording.StopRecordingRequest;
import net.twasi.obsremotejava.requests.StopRecording.StopRecordingResponse;
import net.twasi.obsremotejava.requests.StopReplayBuffer.StopReplayBufferRequest;
import net.twasi.obsremotejava.requests.StopReplayBuffer.StopReplayBufferResponse;
import net.twasi.obsremotejava.requests.StopStreaming.StopStreamingRequest;
import net.twasi.obsremotejava.requests.StopStreaming.StopStreamingResponse;
import net.twasi.obsremotejava.requests.TransitionToProgram.TransitionToProgramRequest;
import net.twasi.obsremotejava.requests.TransitionToProgram.TransitionToProgramResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@WebSocket(maxIdleTime = 360000000)
public class OBSCommunicator {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private boolean debug;
    private final String password;
    private final CountDownLatch closeLatch;
    public final Map<String, Class> messageTypes = new HashMap<>();

    private final Map<Class, Callback> callbacks = new HashMap<>();

    private Session session;

    private Callback<GetVersionResponse> onConnect;
    private VoidCallback onDisconnect;
    private CloseCallback onClose;
    private StringCallback onConnectionFailed;
    private ErrorCallback onError;

    // Optional callbacks
    private VoidCallback onRecordingStarted;
    private VoidCallback onRecordingStopped;
    private VoidCallback onReplayStarted;
    private VoidCallback onReplayStarting;
    private VoidCallback onReplayStopped;
    private VoidCallback onReplayStopping;
    private VoidCallback onStreamStarted;
    private VoidCallback onStreamStopped;
    private Callback<SwitchScenesResponse> onSwitchScenes;
    private Callback<ScenesChangedResponse> onScenesChanged;
    private Callback<SwitchTransitionResponse> onSwitchTransition;
    private Callback<TransitionListChangedResponse> onTransitionListChanged;
    private Callback<TransitionBeginResponse> onTransitionBegin;
    private Callback<TransitionEndResponse> onTransitionEnd;
    private Callback<SourceFilterVisibilityChangedResponse> onSourceFilterVisibilityChanged;

    private GetVersionResponse versionInfo;

    public OBSCommunicator(boolean debug, String password) {
        this.closeLatch = new CountDownLatch(1);
        this.debug = debug;
        this.password = password;
    }

    public OBSCommunicator(boolean debug) {
        this(debug, null);
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    public void await() throws InterruptedException {
        this.closeLatch.await();
    }

    @OnWebSocketError
    public void onError(Session session, Throwable throwable) {
        // do nothing for now, this should at least repress "OnWebsocketError not registered" messages
        runOnConnectionFailed("Websocket error occurred with session " + session, throwable);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        log.info(String.format("Connection closed: %d - %s%n", statusCode, reason));
        runOnDisconnect();
        this.closeLatch.countDown(); // trigger latch
        runOnClosed(statusCode, reason);
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        try {
            Future<Void> fut;
            fut = session.getRemote().sendStringByFuture(new Gson().toJson(new GetVersionRequest(this)));
            fut.get(2, TimeUnit.SECONDS);
        } catch (Throwable t) {
            runOnError("An error occurred while trying to get a session", t);
        }
    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        if (msg == null) {
            log.debug("Ignored empty message");
            return;
        }

        if (debug) {
            log.debug("onMessage: " + msg);
        }

        try {
            if (new Gson().fromJson(msg, JsonObject.class).has("message-id")) {
                // Response
                ResponseBase responseBase = new Gson().fromJson(msg, ResponseBase.class);
                Class type = messageTypes.get(responseBase.getMessageId());
                log.trace(String.format("Trying to deserialize response with type %s and message '%s'", type, msg));
                responseBase = (ResponseBase) new Gson().fromJson(msg, type);

                try {
                    processIncomingResponse(responseBase, type);
                } catch (Throwable t) {
                    runOnError("Failed to process response '" + type.getSimpleName() + "' from websocket", t);
                }

            } else {
                JsonElement elem = new JsonParser().parse(msg);
                EventType eventType;

                try {
                    eventType = EventType.valueOf(elem.getAsJsonObject().get("update-type").getAsString());
                } catch (Throwable t) {
                    return;
                }

                try {
                    processIncomingEvent(msg, eventType);
                } catch (Throwable t) {
                    runOnError("Failed to execute callback for event: " + eventType, t);
                }
            }
        } catch (Throwable t) {
            runOnError("Failed to process message from websocket", t);
        }
    }

    private void processIncomingResponse(ResponseBase responseBase, Class type) {
        switch (type.getSimpleName()) {
            case "GetVersionResponse":
                versionInfo = (GetVersionResponse) responseBase;
                log.info(String.format("Connected to OBS. Websocket Version: %s, Studio Version: %s\n", versionInfo.getObsWebsocketVersion(), versionInfo.getObsStudioVersion()));
                session.getRemote().sendStringByFuture(new Gson().toJson(new GetAuthRequiredRequest(this)));
                break;

            case "GetAuthRequiredResponse":
                GetAuthRequiredResponse authRequiredResponse = (GetAuthRequiredResponse) responseBase;
                if (authRequiredResponse.isAuthRequired()) {
                    log.info("Authentication is required.");
                    authenticateWithServer(authRequiredResponse.getChallenge(), authRequiredResponse.getSalt());
                } else {
                    log.info("Authentication is not required. You're ready to go!");
                    runOnConnect(versionInfo);
                }
                break;

            case "AuthenticateResponse":
                AuthenticateResponse authenticateResponse = (AuthenticateResponse) responseBase;

                if ("ok".equals(authenticateResponse.getStatus())) {
                    runOnConnect(versionInfo);
                } else {
                    runOnConnectionFailed("Failed to authenticate with password. Error: " + authenticateResponse.getError(), null);
                }

                break;
            default:
                if (!callbacks.containsKey(type)) {
                    log.warn("Invalid type received: " + type.getName());
                    runOnError("Invalid response type received", new InvalidResponseTypeError(type.getName()));
                    return;
                }

                try {
                    callbacks.get(type).run(responseBase);
                } catch (Throwable t) {
                    runOnError("Failed to execute callback for response: " + type, t);
                }
        }
    }

    private void processIncomingEvent(String msg, EventType eventType) {
        switch (eventType) {
            case ReplayStarted:
                if (onReplayStarted != null)
                    onReplayStarted.run();
                break;
            case ReplayStarting:
                if (onReplayStarting != null)
                    onReplayStarting.run();
                break;
            case ReplayStopped:
                if (onReplayStopped != null)
                    onReplayStopped.run();
                break;
            case ReplayStopping:
                if (onReplayStopping != null)
                    onReplayStopping.run();
                break;
            case SwitchScenes:
                if (onSwitchScenes != null) {
                    onSwitchScenes.run(new Gson().fromJson(msg, SwitchScenesResponse.class));
                }
                break;
            case ScenesChanged:
                if (onScenesChanged != null) {
                    onScenesChanged.run(new Gson().fromJson(msg, ScenesChangedResponse.class));
                }
                break;
            case SourceFilterVisibilityChanged:
                if(onSourceFilterVisibilityChanged != null) {
                    onSourceFilterVisibilityChanged.run(new Gson().fromJson(msg, SourceFilterVisibilityChangedResponse.class));
                }
                break;
            case SwitchTransition:
                if (onSwitchTransition != null) {
                    onSwitchTransition.run(new Gson().fromJson(msg, SwitchTransitionResponse.class));
                }
                break;
            case TransitionListChanged:
                if (onTransitionListChanged != null) {
                    onTransitionListChanged.run(new Gson().fromJson(msg, TransitionListChangedResponse.class));
                }
                break;
            case TransitionBegin:
                if (onTransitionBegin != null) {
                    onTransitionBegin.run(new Gson().fromJson(msg, TransitionBeginResponse.class));
                }
                break;
            case TransitionEnd:
                if (onTransitionEnd != null) {
                    onTransitionEnd.run(new Gson().fromJson(msg, TransitionEndResponse.class));
                }
                break;
            case RecordingStarted:
                if (onRecordingStarted != null)
                    onRecordingStarted.run();
                break;
            case RecordingStopped:
                if (onRecordingStopped != null)
                    onRecordingStopped.run();
                break;
            case StreamStarted:
                if (onStreamStarted != null)
                    onStreamStarted.run();
                break;
            case StreamStopped:
                if (onStreamStopped != null)
                    onStreamStopped.run();
                break;
        }
    }

    private void authenticateWithServer(String challenge, String salt) {
        if (password == null) {
            runOnConnectionFailed("Authentication required by server but no password set by client", null);
            return;
        }

        // Generate authentication response secret
        String authResponse = generateAuthenticationResponseString(challenge, salt);

        if (authResponse == null) {
            return;
        }

        // Send authentication response secret to server
        session.getRemote()
                .sendStringByFuture(new Gson().toJson(new AuthenticateRequest(this, authResponse)));
    }

    private String generateAuthenticationResponseString(String challenge, String salt) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            runOnConnectionFailed("Failed to perform password authentication with server", null);
            return null;
        }

        String secretString = password + salt;
        byte[] secretHash = digest.digest(secretString.getBytes(StandardCharsets.UTF_8));
        String encodedSecret = Base64.getEncoder().encodeToString(secretHash);

        String authResponseString = encodedSecret + challenge;
        byte[] authResponseHash = digest.digest(authResponseString.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(authResponseHash);
    }

    public void registerOnError(ErrorCallback onError) {
        this.onError = onError;
    }

    public void registerOnConnect(Callback<GetVersionResponse> onConnect) {
        this.onConnect = onConnect;
    }

    public void registerOnDisconnect(VoidCallback onDisconnect) {
        this.onDisconnect = onDisconnect;
    }

    public void registerOnClose(CloseCallback closeCallback) { this.onClose = closeCallback; }

    public void registerOnConnectionFailed(StringCallback onConnectionFailed) {
        this.onConnectionFailed = onConnectionFailed;
    }

    public void registerOnReplayStarted(VoidCallback onReplayStarted) {
        this.onReplayStarted = onReplayStarted;
    }

    public void registerOnReplayStarting(VoidCallback onReplayStarting) {
        this.onReplayStarting = onReplayStarting;
    }

    public void registerOnReplayStopped(VoidCallback onReplayStopped) {
        this.onReplayStopped = onReplayStopped;
    }

    public void registerOnReplayStopping(VoidCallback onReplayStopping) {
        this.onReplayStopping = onReplayStopping;
    }

    public void registerOnSwitchScenes(Callback<SwitchScenesResponse> onSwitchScenes) {
        this.onSwitchScenes = onSwitchScenes;
    }

    public void registerOnScenesChanged(Callback<ScenesChangedResponse> onScenesChanged) {
        this.onScenesChanged = onScenesChanged;
    }

    public void registerOnSourceFilterVisibilityChanged(Callback<SourceFilterVisibilityChangedResponse> onSourceFilterVisibilityChanged) {
        this.onSourceFilterVisibilityChanged = onSourceFilterVisibilityChanged;
    }

    public void registerOnSwitchTransition(Callback<SwitchTransitionResponse> onSwitchTransition) {
        this.onSwitchTransition = onSwitchTransition;
    }

    public void registerOnTransitionListChanged(Callback<TransitionListChangedResponse> onTransitionListChanged) {
        this.onTransitionListChanged = onTransitionListChanged;
    }

    public void registerOnTransitionBegin(Callback<TransitionBeginResponse> onTransitionBegin) {
        this.onTransitionBegin = onTransitionBegin;
    }

    public void registerOnTransitionEnd(Callback<TransitionEndResponse> onTransitionEnd) {
        this.onTransitionEnd = onTransitionEnd;
    }

    public void registerOnRecordingStarted(VoidCallback onRecordingStarted) {
        this.onRecordingStarted = onRecordingStarted;
    }

    public void registerOnRecordingStopped(VoidCallback onRecordingStopped) {
        this.onRecordingStopped = onRecordingStopped;
    }

    public void registerOnStreamStarted(VoidCallback onStreamStarted) {
        this.onStreamStarted = onStreamStarted;
    }

    public void registerOnStreamStopped(VoidCallback onStreamStopped) {
        this.onStreamStopped = onStreamStopped;
    }

    public void getScenes(Callback<GetSceneListResponse> callback) {
        session.getRemote().sendStringByFuture(new Gson().toJson(new GetSceneListRequest(this)));
        callbacks.put(GetSceneListResponse.class, callback);
    }

    public void setCurrentScene(String scene, Callback<SetCurrentSceneResponse> callback) {
        session.getRemote().sendStringByFuture(new Gson().toJson(new SetCurrentSceneRequest(this, scene)));
        callbacks.put(SetCurrentSceneResponse.class, callback);
    }

    public void setCurrentTransition(String transition, Callback<SetCurrentTransitionResponse> callback) {
        session.getRemote().sendStringByFuture(new Gson().toJson(new SetCurrentTransitionRequest(this, transition)));
        callbacks.put(SetCurrentTransitionResponse.class, callback);
    }

    public void setSourceVisiblity(String scene, String source, boolean visibility, Callback<SetSceneItemPropertiesResponse> callback) {
        SetSceneItemPropertiesRequest request = new SetSceneItemPropertiesRequest(this, scene, source, visibility);
        log.debug(new Gson().toJson(request));
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetSceneItemPropertiesResponse.class, callback);
    }

    public void getSceneItemProperties(String scene, String source, Callback<SetSceneItemPropertiesResponse> callback) {
        GetSceneItemPropertiesRequest request = new GetSceneItemPropertiesRequest(this, scene, source);
        log.debug(new Gson().toJson(request));
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetSceneItemPropertiesResponse.class, callback);
    }

    public void getTransitionList(Callback<GetTransitionListResponse> callback) {
        GetTransitionListRequest request = new GetTransitionListRequest(this);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetTransitionListResponse.class, callback);
    }

    public void transitionToProgram(String transitionName, int duration, Callback<TransitionToProgramResponse> callback) {
        TransitionToProgramRequest request = new TransitionToProgramRequest(this, transitionName, duration);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(TransitionToProgramResponse.class, callback);
    }

    public void getSourceSettings(String sourceName, Callback<GetSourceSettingsResponse> callback) {
        GetSourceSettingsRequest request = new GetSourceSettingsRequest(this, sourceName);
        log.debug(new Gson().toJson(request));
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetSourceSettingsResponse.class, callback);
    }

    public void setSourceSettings(String sourceName, Map<String, Object> settings, Callback<SetSourceSettingsResponse> callback) {
        SetSourceSettingsRequest request = new SetSourceSettingsRequest(this, sourceName, settings);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetSourceSettingsResponse.class, callback);
    }

    public void getSourceFilters(String sourceName, Callback<GetSourceFiltersResponse> callback) {
        GetSourceFiltersRequest request = new GetSourceFiltersRequest(sourceName);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetSourceFiltersResponse.class, callback);
    }

    public void getSourceFilterInfo(String sourceName, String filterName, Callback<GetSourceFilterInfoResponse> callback) {
        GetSourceFilterInfoRequest request = new GetSourceFilterInfoRequest(sourceName, filterName);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetSourceFilterInfoResponse.class, callback);
    }

    public void setSourceFilterVisibility(String sourceName, String filterName, boolean filterEnabled, Callback<SetSourceFilterVisibilityResponse> callback) {
        SetSourceFilterVisibilityRequest request = new SetSourceFilterVisibilityRequest(sourceName, filterName, filterEnabled);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetSourceFilterVisibilityResponse.class, callback);
    }

    public void startRecording(Callback<StartRecordingResponse> callback) {
        StartRecordingRequest request = new StartRecordingRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StartRecordingResponse.class, callback);
    }

    public void stopRecording(Callback<StopRecordingResponse> callback) {
        StopRecordingRequest request = new StopRecordingRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StopRecordingResponse.class, callback);
    }

    public void getStreamingStatus(Callback<GetStreamingStatusResponse> callback) {
        GetStreamingStatusRequest request = new GetStreamingStatusRequest(this);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetStreamingStatusResponse.class, callback);
    }

    public void startStreaming(Callback<StartStreamingResponse> callback) {
        StartStreamingRequest request = new StartStreamingRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StartStreamingResponse.class, callback);
    }

    public void stopStreaming(Callback<StopStreamingResponse> callback) {
        StopStreamingRequest request = new StopStreamingRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StopStreamingResponse.class, callback);

    }

    public void listProfiles(Callback<ListProfilesResponse> callback) {
        ListProfilesRequest request = new ListProfilesRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(ListProfilesResponse.class, callback);

    }

    public void getCurrentProfile(Callback<GetCurrentProfileResponse> callback) {
        GetCurrentProfileRequest request = new GetCurrentProfileRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetCurrentProfileResponse.class, callback);

    }

    public void setCurrentProfile(String profile, Callback<SetCurrentProfileResponse> callback) {
        SetCurrentProfileRequest request = new SetCurrentProfileRequest(this, profile);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetCurrentProfileResponse.class, callback);

    }

    public void getCurrentScene(Callback<GetCurrentSceneResponse> callback) {
        GetCurrentSceneRequest request = new GetCurrentSceneRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetCurrentSceneResponse.class, callback);

    }

    public void getVolume(String source, Callback<GetVolumeResponse> callback) {
        GetVolumeRequest request = new GetVolumeRequest(this, source);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetVolumeResponse.class, callback);

    }

    public void setVolume(String source, double volume, Callback<SetVolumeResponse> callback) {
        SetVolumeRequest request = new SetVolumeRequest(this, source, volume);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetVolumeResponse.class, callback);

    }

    public void setMute(String source, boolean mute, Callback<SetMuteResponse> callback) {
        SetMuteRequest request = new SetMuteRequest(this, source, mute);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetMuteResponse.class, callback);

    }

    public void getPreviewScene(Callback<GetPreviewSceneResponse> callback) {
        GetPreviewSceneRequest request = new GetPreviewSceneRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetPreviewSceneResponse.class, callback);

    }

    public void setPreviewScene(String name, Callback<SetPreviewSceneResponse> callback) {
        SetPreviewSceneRequest request = new SetPreviewSceneRequest(this, name);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetPreviewSceneResponse.class, callback);

    }

    public void setTextGDIPlusProperties(String source, boolean read_from_file, String text, Callback<SetTextGDIPlusPropertiesResponse> callback) {
        SetTextGDIPlusPropertiesRequest request = new SetTextGDIPlusPropertiesRequest(this, source, read_from_file, text);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetTextGDIPlusPropertiesResponse.class, callback);


    }

    public void getTransitionDuration(Callback<GetTransitionDurationResponse> callback) {
        GetTransitionDurationRequest request = new GetTransitionDurationRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetTransitionDurationResponse.class, callback);

    }

    public void setTransitionDuration(int duration, Callback<SetTransitionDurationResponse> callback) {
        SetTransitionDurationRequest request = new SetTransitionDurationRequest(this, duration);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetTransitionDurationResponse.class, callback);

    }

    public void startReplayBuffer(Callback<StartReplayBufferResponse> callback) {
        StartReplayBufferRequest request = new StartReplayBufferRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StartReplayBufferResponse.class, callback);
    }

    public void stopReplayBuffer(Callback<StopReplayBufferResponse> callback) {
        StopReplayBufferRequest request = new StopReplayBufferRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StopReplayBufferResponse.class, callback);
    }

    public void saveReplayBuffer(Callback<SaveReplayBufferResponse> callback) {
        SaveReplayBufferRequest request = new SaveReplayBufferRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SaveReplayBufferResponse.class, callback);
    }

    public void getStudioModeEnabled(Callback<GetStudioModeEnabledResponse> callback) {
        GetStudioModeEnabledRequest request = new GetStudioModeEnabledRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetStudioModeEnabledResponse.class, callback);
    }

    public void setStudioModeEnabled(boolean enabled, Callback<SetStudioModeEnabledResponse> callback) {
        SetStudioModeEnabledRequest request = new SetStudioModeEnabledRequest(this, enabled);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetStudioModeEnabledResponse.class, callback);
    }

    private void runOnError(String message, Throwable throwable) {
        log.debug("Running onError with message: " + message + " and exception:", throwable);
        if (onError == null) {
            log.debug("No onError callback was registered");
            return;
        }

        try {
            onError.run(message, throwable);
        } catch (Throwable t) {
            log.error("Unable to run onError callback", t);
        }
    }

    private void runOnConnectionFailed(String message, Throwable throwable) {
        log.debug("Running onConnectionFailed, with message: " + message);
        if (onConnectionFailed == null) {
            log.debug("No onConnectionFailed callback was registered");
            return;
        }

        try {
            onConnectionFailed.run(message);
        } catch (Throwable t) {
            log.error("Unable to run OnConnectionFailed callback", t);
        }
    }

    private void runOnConnect(GetVersionResponse versionInfo) {
        log.debug("Running onConnect with versionInfo: " + versionInfo);
        if (onConnect == null) {
            log.debug("No onConnect callback was registered");
            return;
        }

        try {
            onConnect.run(versionInfo);
        } catch (Throwable t) {
            log.error("Unable to run OnConnect callback", t);
        }
    }

    void runOnDisconnect() {
        log.debug("Running onDisconnect");
        if (onDisconnect == null) {
            log.debug("No onDisconnect callback was registered");
            return;
        }

        try {
            onDisconnect.run();
        } catch (Throwable t) {
            log.error("Unable to run OnDisconnect callback", t);
        }
    }


    private void runOnClosed(int statusCode, String reason) {
        log.debug("Running onClose with statusCode " + statusCode + " and reason: " + reason);

        if(this.onClose == null) {
            log.debug("No onClose was registered.");
            return;
        }

        try {
            onClose.run(statusCode, reason);
        } catch (Throwable t) {
            log.error("Unable to run onClose callback", t);
        }
    }
}
