package net.diespendendose.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.diespendendose.obsremotejava.requests.GetAuthRequired.GetAuthRequiredRequest;
import net.diespendendose.obsremotejava.requests.GetAuthRequired.GetAuthRequiredResponse;
import net.diespendendose.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileRequest;
import net.diespendendose.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileResponse;
import net.diespendendose.obsremotejava.requests.GetCurrentScene.GetCurrentSceneRequest;
import net.diespendendose.obsremotejava.requests.GetCurrentScene.GetCurrentSceneResponse;
import net.diespendendose.obsremotejava.requests.GetPreviewScene.GetPreviewSceneRequest;
import net.diespendendose.obsremotejava.requests.GetPreviewScene.GetPreviewSceneResponse;
import net.diespendendose.obsremotejava.requests.GetSceneItemProperties.GetSceneItemPropertiesRequest;
import net.diespendendose.obsremotejava.requests.GetSceneList.GetSceneListRequest;
import net.diespendendose.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.diespendendose.obsremotejava.requests.GetSourceSettings.GetSourceSettingsRequest;
import net.diespendendose.obsremotejava.requests.GetSourceSettings.GetSourceSettingsResponse;
import net.diespendendose.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusRequest;
import net.diespendendose.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusResponse;
import net.diespendendose.obsremotejava.requests.GetTransitionDuration.GetTransitionDurationRequest;
import net.diespendendose.obsremotejava.requests.GetTransitionDuration.GetTransitionDurationResponse;
import net.diespendendose.obsremotejava.requests.GetTransitionList.GetTransitionListRequest;
import net.diespendendose.obsremotejava.requests.GetTransitionList.GetTransitionListResponse;
import net.diespendendose.obsremotejava.requests.GetVersion.GetVersionRequest;
import net.diespendendose.obsremotejava.requests.GetVersion.GetVersionResponse;
import net.diespendendose.obsremotejava.requests.GetVolume.GetVolumeRequest;
import net.diespendendose.obsremotejava.requests.GetVolume.GetVolumeResponse;
import net.diespendendose.obsremotejava.requests.ListProfiles.ListProfilesRequest;
import net.diespendendose.obsremotejava.requests.ListProfiles.ListProfilesResponse;
import net.diespendendose.obsremotejava.requests.ResponseBase;
import net.diespendendose.obsremotejava.requests.SetCurrentProfile.SetCurrentProfileRequest;
import net.diespendendose.obsremotejava.requests.SetCurrentProfile.SetCurrentProfileResponse;
import net.diespendendose.obsremotejava.requests.SetCurrentScene.SetCurrentSceneRequest;
import net.diespendendose.obsremotejava.requests.SetCurrentScene.SetCurrentSceneResponse;
import net.diespendendose.obsremotejava.requests.SetCurrentTransition.SetCurrentTransitionRequest;
import net.diespendendose.obsremotejava.requests.SetCurrentTransition.SetCurrentTransitionResponse;
import net.diespendendose.obsremotejava.requests.SetMute.SetMuteRequest;
import net.diespendendose.obsremotejava.requests.SetMute.SetMuteResponse;
import net.diespendendose.obsremotejava.requests.SetPreviewScene.SetPreviewSceneRequest;
import net.diespendendose.obsremotejava.requests.SetPreviewScene.SetPreviewSceneResponse;
import net.diespendendose.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesRequest;
import net.diespendendose.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesResponse;
import net.diespendendose.obsremotejava.requests.SetSourceSettings.SetSourceSettingsRequest;
import net.diespendendose.obsremotejava.requests.SetSourceSettings.SetSourceSettingsResponse;
import net.diespendendose.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationRequest;
import net.diespendendose.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationResponse;
import net.diespendendose.obsremotejava.requests.SetVolume.SetVolumeRequest;
import net.diespendendose.obsremotejava.requests.SetVolume.SetVolumeResponse;
import net.diespendendose.obsremotejava.requests.StartStreaming.StartStreamingRequest;
import net.diespendendose.obsremotejava.requests.StartStreaming.StartStreamingResponse;
import net.diespendendose.obsremotejava.requests.StopStreaming.StopStreamingRequest;
import net.diespendendose.obsremotejava.requests.StopStreaming.StopStreamingResponse;
import net.diespendendose.obsremotejava.requests.TransitionToProgram.TransitionToProgramRequest;
import net.diespendendose.obsremotejava.requests.TransitionToProgram.TransitionToProgramResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@WebSocket(maxTextMessageSize = 64 * 1024, maxIdleTime = 360000000)
public class OBSCommunicator {
    private boolean debug;
    private final CountDownLatch closeLatch;
    public final Map<String, Class> messageTypes = new HashMap<>();

    private final Map<Class, Callback> callbacks = new HashMap<>();

    private Session session;

    private Callback onConnect;
    private Callback onDisconnect;

    private GetVersionResponse versionInfo;

    public OBSCommunicator(boolean debug) {
        this.closeLatch = new CountDownLatch(1);
        this.debug = debug;
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    public void await() throws InterruptedException {
        this.closeLatch.await();
    }

    ;

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
        this.closeLatch.countDown(); // trigger latch
        this.onDisconnect.run(null);
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
                            // TODO support authentication
                        } else {
                            System.out.println("Authentication is not required. You're ready to go!");
                            this.onConnect.run(versionInfo);
                        }
                        break;
                    default:
                        if (callbacks.containsKey(type)) {
                            callbacks.get(type).run(responseBase);
                        } else {
                            System.out.println("Invalid type received: " + type.getName());
                        }
                }
            } else {
                // Event
                // System.out.println("Event received");
                // TODO: Events
            }
        } catch (Exception e){
            System.out.println("Websockte Exception: " + e.getMessage());
        }
    }

    public void registerOnConnect(Callback onConnect) {
        this.onConnect = onConnect;
    }

    public void registerOnDisconnect(Callback onDisconnect) {
        this.onDisconnect = onDisconnect;
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
}
