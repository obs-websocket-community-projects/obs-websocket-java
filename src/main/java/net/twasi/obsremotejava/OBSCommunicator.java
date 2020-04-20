package net.twasi.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.twasi.obsremotejava.events.EventType;
import net.twasi.obsremotejava.events.responses.ScenesChangedResponse;
import net.twasi.obsremotejava.events.responses.SwitchScenesResponse;
import net.twasi.obsremotejava.events.responses.TransitionBeginResponse;
import net.twasi.obsremotejava.events.responses.TransitionEndResponse;
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
import net.twasi.obsremotejava.requests.SetSourceSettings.SetSourceSettingsRequest;
import net.twasi.obsremotejava.requests.SetSourceSettings.SetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.SetStudioModeEnabled.SetStudioModeEnabledRequest;
import net.twasi.obsremotejava.requests.SetStudioModeEnabled.SetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationRequest;
import net.twasi.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.SetVolume.SetVolumeRequest;
import net.twasi.obsremotejava.requests.SetVolume.SetVolumeResponse;
import net.twasi.obsremotejava.requests.StartReplayBuffer.StartReplayBufferRequest;
import net.twasi.obsremotejava.requests.StartReplayBuffer.StartReplayBufferResponse;
import net.twasi.obsremotejava.requests.StartStreaming.StartStreamingRequest;
import net.twasi.obsremotejava.requests.StartStreaming.StartStreamingResponse;
import net.twasi.obsremotejava.requests.StopReplayBuffer.StopReplayBufferRequest;
import net.twasi.obsremotejava.requests.StopReplayBuffer.StopReplayBufferResponse;
import net.twasi.obsremotejava.requests.StopStreaming.StopStreamingRequest;
import net.twasi.obsremotejava.requests.StopStreaming.StopStreamingResponse;
import net.twasi.obsremotejava.requests.TransitionToProgram.TransitionToProgramRequest;
import net.twasi.obsremotejava.requests.TransitionToProgram.TransitionToProgramResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@WebSocket(maxTextMessageSize = 64 * 1024, maxIdleTime = 360000000)
public class OBSCommunicator {
    private boolean debug;
    private final String password;
    private final CountDownLatch closeLatch;
    public final Map<String, Class> messageTypes = new HashMap<>();

    private final Map<Class, Callback> callbacks = new HashMap<>();

    private Session session;

    private Callback onConnect;
    private Callback onDisconnect;
    private StringCallback onConnectionFailed;

    // Optional callbacks
    private Callback onReplayStarted;
    private Callback onReplayStarting;
    private Callback onReplayStopped;
    private Callback onReplayStopping;
    private Callback onSwitchScenes;
    private Callback onScenesChanged;
    private Callback onTransitionBegin;
    private Callback onTransitionEnd;

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

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
        this.closeLatch.countDown(); // trigger latch
        try {
            this.onDisconnect.run(null);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        try {
            Future<Void> fut;
            fut = session.getRemote().sendStringByFuture(new Gson().toJson(new GetVersionRequest(this)));
            fut.get(2, TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        try {
            if (msg == null) {
                System.out.println("Ignored empty message");
                return;
            }

            if (debug) {
                System.out.println(msg);
            }

            if (new Gson().fromJson(msg, JsonObject.class).has("message-id")) {
                // Response
                ResponseBase responseBase = new Gson().fromJson(msg, ResponseBase.class);
                Class type = messageTypes.get(responseBase.getMessageId());
                responseBase = (ResponseBase) new Gson().fromJson(msg, type);

                try {
                    processIncomingResponse(responseBase, type);
                } catch (Throwable t) {
                    System.err.println("Failed to process response '" + type.getSimpleName() + "' from websocket.");
                    t.printStackTrace();
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
                    System.err.println("Failed to execute callback for event: " + eventType);
                    t.printStackTrace();
                }
            }
        } catch (Throwable t) {
            System.err.println("Failed to process message from websocket.");
            t.printStackTrace();
        }
    }

    private void processIncomingResponse(ResponseBase responseBase, Class type) {
        switch (type.getSimpleName()) {
            case "GetVersionResponse":
                versionInfo = (GetVersionResponse) responseBase;
                System.out.printf("Connected to OBS. Websocket Version: %s, Studio Version: %s\n", versionInfo.getObsWebsocketVersion(), versionInfo.getObsStudioVersion());
                session.getRemote().sendStringByFuture(new Gson().toJson(new GetAuthRequiredRequest(this)));
                break;

            case "GetAuthRequiredResponse":
                GetAuthRequiredResponse authRequiredResponse = (GetAuthRequiredResponse) responseBase;
                if (authRequiredResponse.isAuthRequired()) {
                    System.out.println("Authentication is required.");
                    authenticateWithServer(authRequiredResponse.getChallenge(), authRequiredResponse.getSalt());
                } else {
                    System.out.println("Authentication is not required. You're ready to go!");
                    runOnConnect(versionInfo);
                }
                break;

            case "AuthenticateResponse":
                AuthenticateResponse authenticateResponse = (AuthenticateResponse) responseBase;

                if ("ok".equals(authenticateResponse.getStatus())) {
                    runOnConnect(versionInfo);
                } else {
                    runOnConnectionFailed("Failed to authenticate with password. Error: " + authenticateResponse.getError());
                }

                break;
            default:
                if (!callbacks.containsKey(type)) {
                    System.out.println("Invalid type received: " + type.getName());
                    return;
                }

                try {
                    callbacks.get(type).run(responseBase);
                } catch (Throwable t) {
                    System.err.println("Failed to execute callback for response: " + type);
                    t.printStackTrace();
                }
        }
    }

    private void processIncomingEvent(String msg, EventType eventType) {
        switch (eventType) {
            case ReplayStarted:
                if (onReplayStarted != null)
                    onReplayStarted.run(null);
                break;
            case ReplayStarting:
                if (onReplayStarting != null)
                    onReplayStarting.run(null);
                break;
            case ReplayStopped:
                if (onReplayStopped != null)
                    onReplayStopped.run(null);
                break;
            case ReplayStopping:
                if (onReplayStopping != null)
                    onReplayStopping.run(null);
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
        }
    }

    private void authenticateWithServer(String challenge, String salt) {
        if (password == null) {
            System.err.println("Authentication required by server but no password set by client");
            runOnConnectionFailed("Authentication required by server but no password set by client");
            return;
        }

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Failed to perform password authentication with server");
            e.printStackTrace();
            runOnConnectionFailed("Failed to perform password authentication with server");
            return;
        }

        // Generate authentication response secret
        String secretString = password + salt;
        byte[] secretHash = digest.digest(secretString.getBytes(StandardCharsets.UTF_8));
        String encodedSecret = Base64.getEncoder().encodeToString(secretHash);

        String authResponseString = encodedSecret + challenge;
        byte[] authResponseHash = digest.digest(authResponseString.getBytes(StandardCharsets.UTF_8));
        String authResponse = Base64.getEncoder().encodeToString(authResponseHash);

        // Send authentication response secret to server
        session.getRemote()
                .sendStringByFuture(new Gson().toJson(new AuthenticateRequest(this, authResponse)));
    }

    public void registerOnConnect(Callback onConnect) {
        this.onConnect = onConnect;
    }

    public void registerOnDisconnect(Callback onDisconnect) {
        this.onDisconnect = onDisconnect;
    }

    public void registerOnConnectionFailed(StringCallback onConnectionFailed) {
        this.onConnectionFailed = onConnectionFailed;
    }

    public void registerOnReplayStarted(Callback onReplayStarted) {
        this.onReplayStarted = onReplayStarted;
    }

    public void registerOnReplayStarting(Callback onReplayStarting) {
        this.onReplayStarting = onReplayStarting;
    }

    public void registerOnReplayStopped(Callback onReplayStopped) {
        this.onReplayStopped = onReplayStopped;
    }

    public void registerOnReplayStopping(Callback onReplayStopping) {
        this.onReplayStopping = onReplayStopping;
    }

    public void registerOnSwitchScenes(Callback onSwitchScenes) {
        this.onSwitchScenes = onSwitchScenes;
    }

    public void registerOnScenesChanged(Callback onScenesChanged) {
        this.onScenesChanged = onScenesChanged;
    }

    public void registerOnTransitionBegin(Callback onTransitionBegin) {
        this.onTransitionBegin = onTransitionBegin;
    }

    public void registerOnTransitionEnd(Callback onTransitionEnd) {
        this.onTransitionEnd = onTransitionEnd;
    }

    public void getScenes(Callback callback) {
        session.getRemote().sendStringByFuture(new Gson().toJson(new GetSceneListRequest(this)));
        callbacks.put(GetSceneListResponse.class, callback);

    }

    public void setCurrentScene(String scene, Callback callback) {
        session.getRemote().sendStringByFuture(new Gson().toJson(new SetCurrentSceneRequest(this, scene)));
        callbacks.put(SetCurrentSceneResponse.class, callback);
    }

    public void setCurrentTransition(String transition, Callback callback) {
        session.getRemote().sendStringByFuture(new Gson().toJson(new SetCurrentTransitionRequest(this, transition)));
        callbacks.put(SetCurrentTransitionResponse.class, callback);
    }

    public void setSourceVisiblity(String scene, String source, boolean visibility, Callback callback) {
        SetSceneItemPropertiesRequest request = new SetSceneItemPropertiesRequest(this, scene, source, visibility);
        System.out.println(new Gson().toJson(request));
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetSceneItemPropertiesResponse.class, callback);
    }

    public void getSceneItemProperties(String scene, String source, Callback callback) {
        GetSceneItemPropertiesRequest request = new GetSceneItemPropertiesRequest(this, scene, source);
        System.out.println(new Gson().toJson(request));
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetSceneItemPropertiesResponse.class, callback);
    }

    public void getTransitionList(Callback callback) {
        GetTransitionListRequest request = new GetTransitionListRequest(this);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetTransitionListResponse.class, callback);
    }

    public void transitionToProgram(String transitionName, int duration, Callback callback) {
        TransitionToProgramRequest request = new TransitionToProgramRequest(this, transitionName, duration);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(TransitionToProgramResponse.class, callback);
    }

    public void getSourceSettings(String sourceName, Callback callback) {
        GetSourceSettingsRequest request = new GetSourceSettingsRequest(this, sourceName);
        System.out.println(new Gson().toJson(request));
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetSourceSettingsResponse.class, callback);
    }

    public void setSourceSettings(String sourceName, Map<String, Object> settings, Callback callback) {
        SetSourceSettingsRequest request = new SetSourceSettingsRequest(this, sourceName, settings);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetSourceSettingsResponse.class, callback);
    }

    public void getStreamingStatus(Callback callback) {
        GetStreamingStatusRequest request = new GetStreamingStatusRequest(this);
        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetStreamingStatusResponse.class, callback);
    }

    public void startStreaming(Callback callback) {
        StartStreamingRequest request = new StartStreamingRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StartStreamingResponse.class, callback);
    }

    public void stopStreaming(Callback callback) {
        StopStreamingRequest request = new StopStreamingRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StopStreamingResponse.class, callback);

    }

    public void listProfiles(Callback callback) {
        ListProfilesRequest request = new ListProfilesRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(ListProfilesResponse.class, callback);

    }

    public void getCurrentProfile(Callback callback) {
        GetCurrentProfileRequest request = new GetCurrentProfileRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetCurrentProfileResponse.class, callback);

    }

    public void setCurrentProfile(String profile, Callback callback) {
        SetCurrentProfileRequest request = new SetCurrentProfileRequest(this, profile);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetCurrentProfileResponse.class, callback);

    }

    public void getCurrentScene(Callback callback) {
        GetCurrentSceneRequest request = new GetCurrentSceneRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetCurrentSceneResponse.class, callback);

    }

    public void getVolume(String source, Callback callback) {
        GetVolumeRequest request = new GetVolumeRequest(this, source);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetVolumeResponse.class, callback);

    }

    public void setVolume(String source, double volume, Callback callback) {
        SetVolumeRequest request = new SetVolumeRequest(this, source, volume);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetVolumeResponse.class, callback);

    }

    public void setMute(String source, boolean mute, Callback callback) {
        SetMuteRequest request = new SetMuteRequest(this, source, mute);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetMuteResponse.class, callback);

    }

    public void getPreviewScene(Callback callback) {
        GetPreviewSceneRequest request = new GetPreviewSceneRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetPreviewSceneResponse.class, callback);

    }

    public void setPreviewScene(String name, Callback callback) {
        SetPreviewSceneRequest request = new SetPreviewSceneRequest(this, name);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetPreviewSceneResponse.class, callback);

    }

    public void getTransitionDuration(Callback callback) {
        GetTransitionDurationRequest request = new GetTransitionDurationRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetTransitionDurationResponse.class, callback);

    }

    public void setTransitionDuration(int duration, Callback callback) {
        SetTransitionDurationRequest request = new SetTransitionDurationRequest(this, duration);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetTransitionDurationResponse.class, callback);

    }

    public void startReplayBuffer(Callback callback) {
        StartReplayBufferRequest request = new StartReplayBufferRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StartReplayBufferResponse.class, callback);
    }

    public void stopReplayBuffer(Callback callback) {
        StopReplayBufferRequest request = new StopReplayBufferRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(StopReplayBufferResponse.class, callback);
    }

    public void saveReplayBuffer(Callback callback) {
        SaveReplayBufferRequest request = new SaveReplayBufferRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SaveReplayBufferResponse.class, callback);
    }

    public void getStudioModeEnabled(Callback callback) {
        GetStudioModeEnabledRequest request = new GetStudioModeEnabledRequest(this);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(GetStudioModeEnabledResponse.class, callback);
    }

    public void setStudioModeEnabled(boolean enabled, Callback callback){
        SetStudioModeEnabledRequest request = new SetStudioModeEnabledRequest(this, enabled);

        session.getRemote().sendStringByFuture(new Gson().toJson(request));
        callbacks.put(SetStudioModeEnabledResponse.class, callback);
    }

    private void runOnConnectionFailed(String message) {
        if (onConnectionFailed == null) {
            return;
        }

        try {
            onConnectionFailed.run(message);
        } catch (Throwable t) {
            System.err.println("Exception during callback execution for 'onConnectionFailed'");
            t.printStackTrace();
        }
    }

    private void runOnConnect(GetVersionResponse versionInfo) {
        if (onConnect == null) {
            return;
        }

        try {
            onConnect.run(versionInfo);
        } catch (Throwable t) {
            System.err.println("Exception during callback execution for 'onConnect'");
            t.printStackTrace();
        }
    }
}
