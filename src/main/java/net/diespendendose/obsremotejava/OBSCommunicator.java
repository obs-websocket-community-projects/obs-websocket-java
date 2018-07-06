package net.diespendendose.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.diespendendose.obsremotejava.requests.GetAuthRequired.GetAuthRequiredRequest;
import net.diespendendose.obsremotejava.requests.GetAuthRequired.GetAuthRequiredResponse;
import net.diespendendose.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileRequest;
import net.diespendendose.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileResponse;
import net.diespendendose.obsremotejava.requests.GetCurrentScene.GetCurrentSceneRequest;
import net.diespendendose.obsremotejava.requests.GetCurrentScene.GetCurrentSceneResponse;
import net.diespendendose.obsremotejava.requests.GetSceneItemProperties.GetSceneItemPropertiesRequest;
import net.diespendendose.obsremotejava.requests.GetSceneList.GetSceneListRequest;
import net.diespendendose.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.diespendendose.obsremotejava.requests.GetSourceSettings.GetSourceSettingsRequest;
import net.diespendendose.obsremotejava.requests.GetSourceSettings.GetSourceSettingsResponse;
import net.diespendendose.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusRequest;
import net.diespendendose.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusResponse;
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
import net.diespendendose.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesRequest;
import net.diespendendose.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesResponse;
import net.diespendendose.obsremotejava.requests.SetSourceSettings.SetSourceSettingsRequest;
import net.diespendendose.obsremotejava.requests.SetSourceSettings.SetSourceSettingsResponse;
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

import java.io.IOException;
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
    };

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

            switch(type.getSimpleName()) {
                case "GetVersionResponse":
                    versionInfo = (GetVersionResponse) responseBase;
                    System.out.printf("Connected to OBS. Websocket Version: %s, Studio Version: %s\n", versionInfo.getObsWebsocketVersion(), versionInfo.getObsStudioVersion());
                    try {
                        session.getRemote().sendString(new Gson().toJson(new GetAuthRequiredRequest(this)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
    }

    public void registerOnConnect(Callback onConnect) {
        this.onConnect = onConnect;
    }

    public void registerOnDisconnect(Callback onDisconnect) {
        this.onDisconnect = onDisconnect;
    }

    public void getScenes(Callback callback) {
        try {
            session.getRemote().sendString(new Gson().toJson(new GetSceneListRequest(this)));
            callbacks.put(GetSceneListResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentScene(String scene, Callback callback) {
        try {
            session.getRemote().sendString(new Gson().toJson(new SetCurrentSceneRequest(this, scene)));
            callbacks.put(SetCurrentSceneResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentTransition(String transition, Callback callback) {
        try {
            session.getRemote().sendString(new Gson().toJson(new SetCurrentTransitionRequest(this, transition)));
            callbacks.put(SetCurrentTransitionResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSourceVisiblity(String scene, String source, boolean visibility, Callback callback) {
        SetSceneItemPropertiesRequest request = new SetSceneItemPropertiesRequest(this, scene, source, visibility);
        System.out.println(new Gson().toJson(request));
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(SetSceneItemPropertiesResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSceneItemProperties(String scene, String source, Callback callback) {
        GetSceneItemPropertiesRequest request = new GetSceneItemPropertiesRequest(this, scene, source);
        System.out.println(new Gson().toJson(request));
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(SetSceneItemPropertiesResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTransitionList(Callback callback) {
        GetTransitionListRequest request = new GetTransitionListRequest(this);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(GetTransitionListResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transitionToProgram(String transitionName, int duration, Callback callback) {
        TransitionToProgramRequest request = new TransitionToProgramRequest(this, transitionName, duration);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(TransitionToProgramResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSourceSettings(String sourceName, Callback callback) {
        GetSourceSettingsRequest request = new GetSourceSettingsRequest(this, sourceName);
        try {
            System.out.println(new Gson().toJson(request));
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(GetSourceSettingsResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSourceSettings(String sourceName, Map<String,Object> settings, Callback callback) {
        SetSourceSettingsRequest request = new SetSourceSettingsRequest(this, sourceName, settings);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(SetSourceSettingsResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getStreamingStatus(Callback callback) {
        GetStreamingStatusRequest request = new GetStreamingStatusRequest(this);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(GetStreamingStatusResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startStreaming(Callback callback) {
        StartStreamingRequest request = new StartStreamingRequest(this);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(StartStreamingResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopStreaming(Callback callback) {
        StopStreamingRequest request = new StopStreamingRequest(this);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(StopStreamingResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listProfiles(Callback callback) {
        ListProfilesRequest request = new ListProfilesRequest(this);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(ListProfilesResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCurrentProfile(Callback callback) {
        GetCurrentProfileRequest request = new GetCurrentProfileRequest(this);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(GetCurrentProfileResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentProfile(String profile, Callback callback) {
        SetCurrentProfileRequest request = new SetCurrentProfileRequest(this, profile);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(SetCurrentProfileResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCurrentScene(Callback callback) {
        GetCurrentSceneRequest request = new GetCurrentSceneRequest(this);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(GetCurrentSceneResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getVolume(String source, Callback callback) {
        GetVolumeRequest request = new GetVolumeRequest(this, source);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(GetVolumeResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setVolume(String source, double volume, Callback callback) {
        SetVolumeRequest request = new SetVolumeRequest(this, source, volume);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(SetVolumeResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMute(String source, boolean mute, Callback callback) {
        SetMuteRequest request = new SetMuteRequest(this, source, mute);
        try {
            session.getRemote().sendString(new Gson().toJson(request));
            callbacks.put(SetMuteResponse.class, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
