package net.twasi.obsremotejava;

import com.google.gson.Gson;
import net.twasi.obsremotejava.callbacks.*;
import net.twasi.obsremotejava.events.responses.*;
import net.twasi.obsremotejava.objects.throwables.OBSResponseError;
import net.twasi.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileResponse;
import net.twasi.obsremotejava.requests.GetCurrentScene.GetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.GetPreviewScene.GetPreviewSceneResponse;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.twasi.obsremotejava.requests.GetSourceFilterInfo.GetSourceFilterInfoRequest;
import net.twasi.obsremotejava.requests.GetSourceFilterInfo.GetSourceFilterInfoResponse;
import net.twasi.obsremotejava.requests.GetSourceFilters.GetSourceFiltersRequest;
import net.twasi.obsremotejava.requests.GetSourceFilters.GetSourceFiltersResponse;
import net.twasi.obsremotejava.requests.GetSourceSettings.GetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusResponse;
import net.twasi.obsremotejava.requests.GetStudioModeEnabled.GetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.GetTransitionDuration.GetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.GetTransitionList.GetTransitionListResponse;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;
import net.twasi.obsremotejava.requests.GetVolume.GetVolumeResponse;
import net.twasi.obsremotejava.requests.ListProfiles.ListProfilesResponse;
import net.twasi.obsremotejava.requests.SaveReplayBuffer.SaveReplayBufferResponse;
import net.twasi.obsremotejava.requests.SetCurrentProfile.SetCurrentProfileResponse;
import net.twasi.obsremotejava.requests.SetCurrentScene.SetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.SetCurrentTransition.SetCurrentTransitionResponse;
import net.twasi.obsremotejava.requests.SetMute.SetMuteResponse;
import net.twasi.obsremotejava.requests.SetPreviewScene.SetPreviewSceneResponse;
import net.twasi.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesResponse;
import net.twasi.obsremotejava.requests.SetSourceFilterVisibility.SetSourceFilterVisibilityRequest;
import net.twasi.obsremotejava.requests.SetSourceFilterVisibility.SetSourceFilterVisibilityResponse;
import net.twasi.obsremotejava.requests.SetSourceSettings.SetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.SetStudioModeEnabled.SetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.SetTextGDIPlusProperties.SetTextGDIPlusPropertiesResponse;
import net.twasi.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.SetVolume.SetVolumeResponse;
import net.twasi.obsremotejava.requests.StartRecording.StartRecordingResponse;
import net.twasi.obsremotejava.requests.StartReplayBuffer.StartReplayBufferResponse;
import net.twasi.obsremotejava.requests.StartStreaming.StartStreamingResponse;
import net.twasi.obsremotejava.requests.StopRecording.StopRecordingResponse;
import net.twasi.obsremotejava.requests.StopReplayBuffer.StopReplayBufferResponse;
import net.twasi.obsremotejava.requests.StopStreaming.StopStreamingResponse;
import net.twasi.obsremotejava.requests.TransitionToProgram.TransitionToProgramResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class OBSRemoteController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private String address;
    private final boolean debug;
    private final OBSCommunicator communicator;
    private final String password;
    private final WebSocketClient client;

    private StringCallback onConnectionFailed;
    private ErrorCallback onError;

    private boolean failed;

    public OBSRemoteController(String address, boolean debug, String password, boolean autoConnect) {
        this.address = address;
        this.debug = debug;
        this.password = password;

        client = new WebSocketClient();
        communicator = new OBSCommunicator(debug, password);

        if (autoConnect) {
            connect();
        }
    }

    public OBSRemoteController(String address, boolean debug, String password) {
        this(address, debug, password, true);
    }

    public OBSRemoteController(String address, boolean debug) {
        this(address, debug, null);
    }

    public void connect() {
        try {
            client.start();
        } catch (Exception e) {
            runOnError("Failed to start WebSocketClient", e);
            return;
        }

        try {
            URI uri = new URI(address);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(communicator, uri, request);
            log.info(String.format("Connecting to: %s%s.%n", uri, (password != null ? " with password" : " (no password)")));
            try {
                connection.get();
                failed = false;
            } catch (ExecutionException e) {
                if (e.getCause() instanceof ConnectException) {
                    failed = true;
                    runOnConnectionFailed("Failed to connect to OBS! Is it running and is the websocket plugin installed?", e);
                } else {
                    throw e;
                }
            }
        } catch (Throwable t) {
            runOnConnectionFailed("Failed to setup connection with OBS", t);
        }
    }

    public void disconnect() {
        // trigger the latch
        try {
            if (debug) {
                log.debug("Closing connection.");
            }
            communicator.awaitClose(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            runOnError("Error during closing websocket connection", e);
        }

        // stop the client if it isn't already stopped or stopping
        if (!client.isStopped() && !client.isStopping()) {
            try {
                if (debug) {
                    log.debug("Stopping client.");
                }
                client.stop();
            } catch (Exception e) {
                runOnError("Error during stopping websocket client", e);
            }
        }
    }

    public boolean isFailed() {
        return failed;
    }

    public void getScenes(Callback<GetSceneListResponse> callback) {
        communicator.getScenes(callback);
    }

    public void registerOnError(ErrorCallback onError) {
        this.onError = onError;
        communicator.registerOnError(onError);
    }

    public void registerConnectCallback(Callback<GetVersionResponse> onConnect) {
        communicator.registerOnConnect(onConnect);
    }

    public void registerDisconnectCallback(VoidCallback onDisconnect) {
        communicator.registerOnDisconnect(onDisconnect);
    }

    public void registerConnectionFailedCallback(StringCallback onConnectionFailed) {
        this.onConnectionFailed = onConnectionFailed;
        communicator.registerOnConnectionFailed(onConnectionFailed);
    }

    public void registerCloseCallback(CloseCallback closeCallback) {
        communicator.registerOnClose(closeCallback);
    }

    public void registerRecordingStartedCallback(VoidCallback onRecordingStarted) {
        communicator.registerOnRecordingStarted(onRecordingStarted);
    }

    public void registerRecordingStoppedCallback(VoidCallback onRecordingStopped) {
        communicator.registerOnRecordingStopped(onRecordingStopped);
    }

    public void registerReplayStartedCallback(VoidCallback onReplayStarted) {
        communicator.registerOnReplayStarted(onReplayStarted);
    }

    public void registerReplayStartingCallback(VoidCallback onReplayStarting) {
        communicator.registerOnReplayStarting(onReplayStarting);
    }

    public void registerReplayStoppedCallback(VoidCallback onReplayStopped) {
        communicator.registerOnReplayStopped(onReplayStopped);
    }

    public void registerReplayStoppingCallback(VoidCallback onReplayStopping) {
        communicator.registerOnReplayStopping(onReplayStopping);
    }

    public void registerStreamStartedCallback(VoidCallback onRecordingStarted) {
        communicator.registerOnStreamStarted(onRecordingStarted);
    }

    public void registerStreamStoppedCallback(VoidCallback onRecordingStopped) {
        communicator.registerOnStreamStopped(onRecordingStopped);
    }

    public void registerSwitchScenesCallback(Callback<SwitchScenesResponse> onSwitchScenes) {
        communicator.registerOnSwitchScenes(onSwitchScenes);
    }

    public void registerScenesChangedCallback(Callback<ScenesChangedResponse> onScenesChanged) {
        communicator.registerOnScenesChanged(onScenesChanged);
    }

    public void registerSwitchTransitionCallback(Callback<SwitchTransitionResponse> onSwitchTransition) {
        communicator.registerOnSwitchTransition(onSwitchTransition);
    }

    public void registerTransitionListChangedCallback(Callback<TransitionListChangedResponse> onTransitionListChanged) {
        communicator.registerOnTransitionListChanged(onTransitionListChanged);
    }

    public void registerTransitionBeginCallback(Callback<TransitionBeginResponse> onTransitionBegin) {
        communicator.registerOnTransitionBegin(onTransitionBegin);
    }

    public void registerTransitionEndCallback(Callback<TransitionEndResponse> onTransitionEnd) {
        communicator.registerOnTransitionEnd(onTransitionEnd);
    }

    public void registerSourceFilterVisibilityChangedCallback(Callback<SourceFilterVisibilityChangedResponse> onSourceVisibilityChanged) {
        communicator.registerOnSourceFilterVisibilityChanged(onSourceVisibilityChanged);
    }

    public void await() throws InterruptedException {
        communicator.await();
    }

    public void setCurrentScene(String scene, Callback<SetCurrentSceneResponse> callback) {
        communicator.setCurrentScene(scene, callback);
    }

    public void setCurrentTransition(String transition, Callback<SetCurrentTransitionResponse> callback) {
        communicator.setCurrentTransition(transition, callback);
    }

    public void changeSceneWithTransition(final String scene, String transition, final Callback<SetCurrentSceneResponse> callback) {
        communicator.setCurrentTransition(transition, response -> {
            if (!response.getStatus().equals("ok")) {
                log.error("Failed to change transition. Pls fix.");
                runOnError("Error response for changeSceneWithTransition", new OBSResponseError(response.getError()));
            }
            communicator.setCurrentScene(scene, callback);
        });
    }

    public void setSourceVisibility(String scene, String source, boolean visibility, Callback<SetSceneItemPropertiesResponse> callback) {
        communicator.setSourceVisiblity(scene, source, visibility, callback);
    }

    public void getSceneItemProperties(String scene, String source, Callback<SetSceneItemPropertiesResponse> callback) {
        communicator.getSceneItemProperties(scene, source, callback);
    }

    public void getSourceProperties(String scene, String source, Callback<SetSceneItemPropertiesResponse> callback) {
        getSceneItemProperties(scene, source, callback);
    }

    public void getSourceFilters(String sourceName, Callback<GetSourceFiltersResponse> callback) {
        communicator.getSourceFilters(sourceName, callback);
    }

    public void getSourceFilterInfo(String sourceName, String filterName, Callback<GetSourceFilterInfoResponse> callback) {
        communicator.getSourceFilterInfo(sourceName, filterName, callback);
    }

    public void setSourceFilterVisibility(String sourceName, String filterName, boolean filterEnabled, Callback<SetSourceFilterVisibilityResponse> callback) {
        communicator.setSourceFilterVisibility(sourceName, filterName, filterEnabled, callback);
    }

    public void getTransitionList(Callback<GetTransitionListResponse> callback) {
        communicator.getTransitionList(callback);
    }

    public void transitionToProgram(String transitionName, int duration, Callback<TransitionToProgramResponse> callback) {
        communicator.transitionToProgram(transitionName, duration, callback);
    }

    public void getSourceSettings(String sourceName, Callback<GetSourceSettingsResponse> callback) {
        communicator.getSourceSettings(sourceName, callback);
    }

    public void setSourceSettings(String sourceName, Map<String, Object> settings, Callback<SetSourceSettingsResponse> callback) {
        communicator.setSourceSettings(sourceName, settings, callback);
    }

    public void getStreamingStatus(Callback<GetStreamingStatusResponse> callback) {
        communicator.getStreamingStatus(callback);
    }

    public void startStreaming(Callback<StartStreamingResponse> callback) {
        communicator.startStreaming(callback);
    }

    public void stopStreaming(Callback<StopStreamingResponse> callback) {
        communicator.stopStreaming(callback);
    }

    public void startRecording(Callback<StartRecordingResponse> callback) {
        communicator.startRecording(callback);
    }

    public void stopRecording(Callback<StopRecordingResponse> callback) {
        communicator.stopRecording(callback);
    }

    public void listProfiles(Callback<ListProfilesResponse> callback) {
        communicator.listProfiles(callback);
    }

    public void getCurrentProfile(Callback<GetCurrentProfileResponse> callback) {
        communicator.getCurrentProfile(callback);
    }

    public void setCurrentProfile(String profile, Callback<SetCurrentProfileResponse> callback) {
        communicator.setCurrentProfile(profile, callback);
    }

    public void getCurrentScene(Callback<GetCurrentSceneResponse> callback) {
        communicator.getCurrentScene(callback);
    }

    public void getVolume(String source, Callback<GetVolumeResponse> callback) {
        communicator.getVolume(source, callback);
    }

    public void setVolume(String source, double volume, Callback<SetVolumeResponse> callback) {
        communicator.setVolume(source, volume, callback);
    }

    public void setMute(String source, boolean mute, Callback<SetMuteResponse> callback) {
        communicator.setMute(source, mute, callback);
    }

    public void getPreviewScene(Callback<GetPreviewSceneResponse> callback) {
        communicator.getPreviewScene(callback);
    }

    public void setPreviewScene(String name, Callback<SetPreviewSceneResponse> callback) {
        communicator.setPreviewScene(name, callback);
    }

    public void getTransitionDuration(Callback<GetTransitionDurationResponse> callback) {
        communicator.getTransitionDuration(callback);
    }

    public void setTransitionDuration(int duration, Callback<SetTransitionDurationResponse> callback) {
        communicator.setTransitionDuration(duration, callback);
    }


    public void getStudioModeEnabled(Callback<GetStudioModeEnabledResponse> callback) {
        communicator.getStudioModeEnabled(callback);
    }

    public void setStudioModeEnabled(boolean enabled, Callback<SetStudioModeEnabledResponse> callback) {
        communicator.setStudioModeEnabled(enabled, callback);
    }
    
    public void setTextGDIPlusProperties(String source, boolean read_from_file, String text, Callback<SetTextGDIPlusPropertiesResponse> callback) {
        communicator.setTextGDIPlusProperties(source, read_from_file, text, callback);
    }
    

    public void startReplayBuffer(Callback<StartReplayBufferResponse> callback) {
        communicator.startReplayBuffer(callback);
    }

    public void stopReplayBuffer(Callback<StopReplayBufferResponse> callback) {
        communicator.stopReplayBuffer(callback);
    }

    public void saveReplayBuffer(Callback<SaveReplayBufferResponse> callback) {
        communicator.saveReplayBuffer(callback);
    }
    

    private void runOnError(String message, Throwable throwable) {
        log.debug("Running onError with message: " + message + " and exception:", throwable);
        if (onError == null) {
            log.debug("No onError callback was registered");
            return;
        }

        try {
            onError.run(message, throwable);
        } catch (Exception e) {
            log.error("Unable to run OnError callback", e);
        }
    }

    private void runOnConnectionFailed(String message, Throwable throwable) {
        log.debug("Running onConnectionFailed with message: " + message + " with exception:", throwable);

        if (onConnectionFailed == null) {
            log.debug("No onConnectionFailed callback was registered");
            return;
        }

        try {
            onConnectionFailed.run(message);
        } catch (Exception e) {
            log.error("Unable to run OnConnectionFailed callback", e);
        }
    }

}
