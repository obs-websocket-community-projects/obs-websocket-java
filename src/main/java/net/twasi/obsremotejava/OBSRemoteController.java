package net.twasi.obsremotejava;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.twasi.obsremotejava.message.event.inputs.InputVolumeChangedEvent;
import net.twasi.obsremotejava.message.event.mediainputs.MediaInputActionTriggeredEvent;
import net.twasi.obsremotejava.message.event.outputs.RecordStateChangedEvent;
import net.twasi.obsremotejava.message.event.outputs.ReplayBufferStateChangedEvent;
import net.twasi.obsremotejava.message.event.outputs.StreamStateChangedEvent;
import net.twasi.obsremotejava.message.event.scenes.CurrentPreviewSceneChangedEvent;
import net.twasi.obsremotejava.message.event.scenes.CurrentSceneChangedEvent;
import net.twasi.obsremotejava.message.request.RequestBatch;
import net.twasi.obsremotejava.message.request.config.CreateSceneCollectionRequest;
import net.twasi.obsremotejava.message.request.config.DeleteSceneCollectionRequest;
import net.twasi.obsremotejava.message.request.config.GetSceneCollectionListRequest;
import net.twasi.obsremotejava.message.request.config.SetCurrentSceneCollectionRequest;
import net.twasi.obsremotejava.message.request.general.*;
import net.twasi.obsremotejava.message.request.scenes.GetSceneListRequest;
import net.twasi.obsremotejava.message.response.RequestBatchResponse;
import net.twasi.obsremotejava.message.response.config.CreateSceneCollectionResponse;
import net.twasi.obsremotejava.message.response.config.DeleteSceneCollectionResponse;
import net.twasi.obsremotejava.message.response.config.GetSceneCollectionListResponse;
import net.twasi.obsremotejava.message.response.config.SetCurrentSceneCollectionResponse;
import net.twasi.obsremotejava.message.response.general.*;
import net.twasi.obsremotejava.message.response.scenes.GetSceneListResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.ConnectException;
import java.net.URI;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Slf4j
public class OBSRemoteController {

    private String address;
//    private final boolean debug;
    private final OBSCommunicator communicator;
//    private final String password;
    private final WebSocketClient client;

    private Consumer<String> onConnectionFailed;
    private BiConsumer<String, Throwable> onError;

    private boolean failed;

    /**
     * All-Args constructor, used by the builder or directly
     * @param client WebSocketClient instance
     * @param communicator Instance of ObsCommunicator (annotated websocket listener)
     * @param host OBS Host
     * @param port OBS port
     * @param autoConnect If true, will connect after this class is instantiated
     */
    public OBSRemoteController(
      WebSocketClient client,
      OBSCommunicator communicator,
      String host,
      int port,
      boolean autoConnect) {
        this.communicator = communicator;
        this.client = client;
        this.address = "ws://" + host + ":" + port;
        if (autoConnect) {
            connect();
        }
    }

    public static ObsRemoteControllerBuilder builder() {
        return new ObsRemoteControllerBuilder();
    }

    @Deprecated
    public OBSRemoteController(String address, boolean debug, String password, boolean autoConnect) {
        this.address = address;
//        this.debug = debug;
//        this.password = password;

        this.client = new WebSocketClient();
        this.communicator = OBSCommunicator.builder()
          .password(password)
          .build();

        if (autoConnect) {
            this.connect();
        }
    }

    @Deprecated
    public OBSRemoteController(String address, boolean debug, String password) {
        this(address, debug, password, true);
    }

    @Deprecated
    public OBSRemoteController(String address, boolean debug) {
        this(address, debug, null);
    }

    public void connect() {
        try {
            this.client.start();
        }
        catch (Exception e) {
            this.runOnError("Failed to start WebSocketClient", e);
            return;
        }

        try {
            URI uri = new URI(this.address);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = this.client.connect(this.communicator, uri, request);
            //log.info(String.format("Connecting to: %s%s.%n", uri, (password != null ? " with password" : " (no password)")));
            try {
                connection.get();
                this.failed = false;
            }
            catch (ExecutionException e) {
                if (e.getCause() instanceof ConnectException) {
                    this.failed = true;
                    this.runOnConnectionFailed("Failed to connect to OBS! Is it running and is the websocket plugin installed?", e);
                }
                else {
                    throw e;
                }
            }
        }
        catch (Throwable t) {
            this.runOnConnectionFailed("Failed to setup connection with OBS", t);
        }
    }

    public void disconnect() {
        // trigger the latch
        try {
            log.debug("Closing connection.");
            this.communicator.awaitClose(1, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            this.runOnError("Error during closing websocket connection", e);
        }

        // stop the client if it isn't already stopped or stopping
        if (!this.client.isStopped() && !this.client.isStopping()) {
            try {
                log.debug("Stopping client.");
                this.client.stop();
            }
            catch (Exception e) {
                this.runOnError("Error during stopping websocket client", e);
            }
        }
    }

    public boolean isFailed() {
        return this.failed;
    }

    public void registerOnError(BiConsumer<String, Throwable> onError) {
        this.onError = onError;
        this.communicator.registerOnError(onError);
    }

    public void registerConnectCallback(Consumer<Session> onConnect) {
        this.communicator.registerOnConnect(onConnect);
    }

    public void registerDisconnectCallback(Runnable onDisconnect) {
        this.communicator.registerOnDisconnect(onDisconnect);
    }

    public void registerConnectionFailedCallback(Consumer<String> onConnectionFailed) {
        this.onConnectionFailed = onConnectionFailed;
        this.communicator.registerOnConnectionFailed(onConnectionFailed);
    }

    public void registerCloseCallback(BiConsumer<Integer, String> closeCallback) {
        this.communicator.registerOnClose(closeCallback);
    }

    public void registerRecordStateChanged(Consumer<RecordStateChangedEvent> onRecordStateChanged) {
        this.communicator.registerEventListener(RecordStateChangedEvent.class, onRecordStateChanged);
    }

    public void registerReplayBufferStateChanged(Consumer<ReplayBufferStateChangedEvent> onReplayBufferStateChanged) {
        this.communicator.registerEventListener(ReplayBufferStateChangedEvent.class, onReplayBufferStateChanged);
    }

    public void registerStreamStateChanged(Consumer<StreamStateChangedEvent> onStreamStateChanged) {
        this.communicator.registerEventListener(StreamStateChangedEvent.class, onStreamStateChanged);
    }

    public void registerMediaInputActionTriggered(Consumer<MediaInputActionTriggeredEvent> onMediaInputActionTriggered) {
        this.communicator.registerEventListener(MediaInputActionTriggeredEvent.class, onMediaInputActionTriggered);
    }

    public void registerCurrentSceneChanged(Consumer<CurrentSceneChangedEvent> onCurrentSceneChanged) {
        this.communicator.registerEventListener(CurrentSceneChangedEvent.class, onCurrentSceneChanged);
    }

    public void registerOnInputVolumeChanged(Consumer<InputVolumeChangedEvent> onInputVolumeChanged) {
        this.communicator.registerEventListener(InputVolumeChangedEvent.class, onInputVolumeChanged);
    }

    public void registerCurrentPreviewSceneChanged(Consumer<CurrentPreviewSceneChangedEvent> onCurrentPreviewSceneChanged) {
        this.communicator.registerEventListener(CurrentPreviewSceneChangedEvent.class, onCurrentPreviewSceneChanged);
    }

    public void await() throws InterruptedException {
        this.communicator.await();
    }

    public void sendRequestBatch(RequestBatch requestBatch, Consumer<RequestBatchResponse> callback) {
        this.communicator.sendRequestBatch(requestBatch, callback);
    }

    public void getVersion(Consumer<GetVersionResponse> callback) {
        this.communicator.sendRequest(new GetVersionRequest(), callback);
    }

    public void getStudioModeEnabled(Consumer<GetStudioModeEnabledResponse> callback) {
        this.communicator.sendRequest(new GetStudioModeEnabledRequest(), callback);
    }

    public void setStudioModeEnabled(boolean enabled, Consumer<SetStudioModeEnabledResponse> callback) {
        this.communicator.sendRequest(new SetStudioModeEnabledRequest(enabled), callback);
    }

    public void broadcastCustomEvent(JsonObject customEventData, Consumer<BroadcastCustomEventResponse> callback) {
        this.communicator.sendRequest(new BroadcastCustomEventRequest(customEventData), callback);
    }

    public void sleep(Long millis, Consumer<BroadcastCustomEventResponse> callback) {
        this.communicator.sendRequest(new SleepRequest(millis), callback);
    }

    public void getSceneList(Consumer<GetSceneListResponse> callback) {
        this.communicator.sendRequest(new GetSceneListRequest(), callback);
    }

    public void getGetHotkeyList(Consumer<GetHotkeyListResponse> callback) {
        this.communicator.sendRequest(new GetHotkeyListRequest(), callback);
    }

    public void triggerHotkeyByName(String hotkeyName, Consumer<TriggerHotkeyByNameResponse> callback) {
        this.communicator.sendRequest(new TriggerHotkeyByNameRequest(hotkeyName), callback);
    }

    public void triggerHotkeyByKeySequence(String keyId, List<String> keyModifiers, Consumer<TriggerHotkeyByKeySequenceResponse> callback) {
        this.communicator.sendRequest(new TriggerHotkeyByKeySequenceRequest(keyId, keyModifiers), callback);
    }

    public void getSceneCollectionList(Consumer<GetSceneCollectionListResponse> callback) {
        this.communicator.sendRequest(new GetSceneCollectionListRequest(), callback);
    }

    public void setCurrentSceneCollection(String sceneCollectionName, Consumer<SetCurrentSceneCollectionResponse> callback) {
        this.communicator.sendRequest(new SetCurrentSceneCollectionRequest(sceneCollectionName), callback);
    }

    public void createSceneCollectionRequest(String sceneCollectionName, Consumer<CreateSceneCollectionResponse> callback) {
        this.communicator.sendRequest(new CreateSceneCollectionRequest(sceneCollectionName), callback);
    }

    public void deleteSceneCollectionRequest(String sceneCollectionName, Consumer<DeleteSceneCollectionResponse> callback) {
        this.communicator.sendRequest(new DeleteSceneCollectionRequest(sceneCollectionName), callback);
    }

//    public void getSourcesList(Consumer<GetSourcesListResponse> callback) {
//        communicator.getSourcesList(callback);
//    }

//    public void setCurrentScene(String scene, Consumer<SetCurrentSceneResponse> callback) {
//        communicator.setCurrentScene(scene, callback);
//    }

//    public void setCurrentTransition(String transition, Consumer<SetCurrentTransitionResponse> callback) {
//        communicator.setCurrentTransition(transition, callback);
//    }

//    public void changeSceneWithTransition(final String scene, String transition, final Consumer<SetCurrentSceneResponse> callback) {
//        communicator.setCurrentTransition(transition, response -> {
//            if (!response.getStatus().equals("ok")) {
//                log.error("Failed to change transition. Pls fix.");
//                runOnError("Error response for changeSceneWithTransition", new OBSResponseError(response.getError()));
//            }
//            communicator.setCurrentScene(scene, callback);
//        });
//    }

//    public void setSourceVisibility(String scene, String source, boolean visibility, Consumer<SetSceneItemPropertiesResponse> callback) {
//        communicator.setSourceVisiblity(scene, source, visibility, callback);
//    }

//    public void getSceneItemProperties(String scene, String source, Consumer<GetSceneItemPropertiesResponse> callback) {
//        communicator.getSceneItemProperties(scene, source, callback);
//    }

//    public void getSourceFilters(String sourceName, Consumer<GetSourceFiltersResponse> callback) {
//        communicator.getSourceFilters(sourceName, callback);
//    }

//    public void getSourceFilterInfo(String sourceName, String filterName, Consumer<GetSourceFilterInfoResponse> callback) {
//        communicator.getSourceFilterInfo(sourceName, filterName, callback);
//    }

//    public void setSourceFilterVisibility(String sourceName, String filterName, boolean filterEnabled, Consumer<SetSourceFilterVisibilityResponse> callback) {
//        communicator.setSourceFilterVisibility(sourceName, filterName, filterEnabled, callback);
//    }

//    public void getTransitionList(Consumer<GetTransitionListResponse> callback) {
//        communicator.getTransitionList(callback);
//    }

//    public void transitionToProgram(String transitionName, int duration, Consumer<TransitionToProgramResponse> callback) {
//        communicator.transitionToProgram(transitionName, duration, callback);
//    }

//    public void getSourceSettings(String sourceName, Consumer<GetSourceSettingsResponse> callback) {
//        communicator.getSourceSettings(sourceName, callback);
//    }

//    public void setSourceSettings(String sourceName, Map<String, Object> settings, Consumer<SetSourceSettingsResponse> callback) {
//        communicator.setSourceSettings(sourceName, settings, callback);
//    }

//    public void setSourceFilterSettings(String sourceName, String filterName, Map<String, Object> settings, Consumer<SetSourceFilterSettingsResponse> callback) {
//        communicator.setSourceFilterSettings(sourceName, filterName, settings, callback);
//    }

//    public void takeSourceScreenshot(String sourceName, String embedPictureFormat, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
//        communicator.takeSourceScreenshot(sourceName, embedPictureFormat, saveToFilePath, fileFormat, compressionQuality, width, height, callback);
//    }

//    public void takeSourceScreenshot(Consumer<TakeSourceScreenshotResponse> callback) {
//        communicator.takeSourceScreenshot(callback);
//    }

//    public void takeSourceScreenshotToEmbed(String sourceName, String embedPictureFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
//        communicator.takeSourceScreenshotToEmbed(sourceName, embedPictureFormat, compressionQuality, width, height, callback);
//    }

//    public void takeSourceScreenshotToFile(String sourceName, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
//        communicator.takeSourceScreenshotToFile(sourceName, saveToFilePath, fileFormat, compressionQuality, width, height, callback);
//    }

//    public void getStreamingStatus(Consumer<GetStreamingStatusResponse> callback) {
//        communicator.getStreamingStatus(callback);
//    }

//    public void startStreaming(Consumer<StartStreamingResponse> callback) {
//        communicator.startStreaming(callback);
//    }

//    public void stopStreaming(Consumer<StopStreamingResponse> callback) {
//        communicator.stopStreaming(callback);
//    }

//    public void startRecording(Consumer<StartRecordingResponse> callback) {
//        communicator.startRecording(callback);
//    }

//    public void stopRecording(Consumer<StopRecordingResponse> callback) {
//        communicator.stopRecording(callback);
//    }

//    public void listProfiles(Consumer<ListProfilesResponse> callback) {
//        communicator.listProfiles(callback);
//    }

//    public void getCurrentProfile(Consumer<GetCurrentProfileResponse> callback) {
//        communicator.getCurrentProfile(callback);
//    }

//    public void setCurrentProfile(String profile, Consumer<SetCurrentProfileResponse> callback) {
//        communicator.setCurrentProfile(profile, callback);
//    }

//    public void getCurrentScene(Consumer<GetCurrentSceneResponse> callback) {
//        communicator.getCurrentScene(callback);
//    }

//    public void getVolume(String source, Consumer<GetVolumeResponse> callback) {
//        communicator.getVolume(source, callback);
//    }

//    public void setVolume(String source, double volume, Consumer<SetVolumeResponse> callback) {
//        communicator.setVolume(source, volume, callback);
//    }

//    public void setMute(String source, boolean mute, Consumer<SetMuteResponse> callback) {
//        communicator.setMute(source, mute, callback);
//    }

//    public void getMute(String source, Consumer<GetMuteResponse> callback) {
//        communicator.getMute(source, callback);
//    }

//    public void toggleMute(String source, Consumer<ToggleMuteResponse> callback) {
//        communicator.toggleMute(source, callback);
//    }

//    public void getPreviewScene(Consumer<GetPreviewSceneResponse> callback) {
//        communicator.getPreviewScene(callback);
//    }

//    public void setPreviewScene(String name, Consumer<SetPreviewSceneResponse> callback) {
//        communicator.setPreviewScene(name, callback);
//    }

//    public void getTransitionDuration(Consumer<GetTransitionDurationResponse> callback) {
//        communicator.getTransitionDuration(callback);
//    }

//    public void setTransitionDuration(int duration, Consumer<SetTransitionDurationResponse> callback) {
//        communicator.setTransitionDuration(duration, callback);
//    }

//    public void startReplayBuffer(Consumer<StartReplayBufferResponse> callback) {
//        communicator.startReplayBuffer(callback);
//    }

//    public void stopReplayBuffer(Consumer<StopReplayBufferResponse> callback) {
//        communicator.stopReplayBuffer(callback);
//    }

//    public void saveReplayBuffer(Consumer<SaveReplayBufferResponse> callback) {
//        communicator.saveReplayBuffer(callback);
//    }

//    public void playPauseMedia(String sourceName, Boolean playPause, Consumer<PlayPauseMediaResponse> callback) {
//        communicator.playPauseMedia(sourceName, playPause, callback);
//    }

//    public void playMedia(String sourceName, Consumer<PlayPauseMediaResponse> callback) {
//        communicator.playPauseMedia(sourceName, false, callback);
//    }

//    public void pauseMedia(String sourceName, Consumer<PlayPauseMediaResponse> callback) {
//        communicator.playPauseMedia(sourceName, true, callback);
//    }

//    public void toggleMedia(String sourceName, Consumer<PlayPauseMediaResponse> callback) {
//        communicator.playPauseMedia(sourceName, null, callback);
//    }

//    public void restartMedia(String sourceName, Consumer<RestartMediaResponse> callback) {
//        communicator.restartMedia(sourceName, callback);
//    }

//    public void stopMedia(String sourceName, Consumer<StopMediaResponse> callback) {
//        communicator.stopMedia(sourceName, callback);
//    }

//    public void nextMedia(String sourceName, Consumer<NextMediaResponse> callback) {
//        communicator.nextMedia(sourceName, callback);
//    }

//    public void previousMedia(String sourceName, Consumer<PreviousMediaResponse> callback) {
//        communicator.previousMedia(sourceName, callback);
//    }

//    public void refreshBrowserSource(String sourceName, Consumer<RefreshBrowserSourceResponse> callback) {
//        communicator.refreshBrowserSource(sourceName, callback);
//    }

//    public void getAudioMonitorType(String sourceName, Consumer<GetAudioMonitorTypeResponse> callback) {
//        communicator.getAudioMonitorType(sourceName, callback);
//    }

//    public void setAudioMonitorType(String sourceName, GetAudioMonitorTypeResponse.MonitorType monitorType, Consumer<SetAudioMonitorTypeResponse> callback) {
//        communicator.setAudioMonitorType(sourceName, monitorType, callback);
//    }

//    public void getSpecialSources(Consumer<GetSpecialSourcesResponse> callback) {
//        communicator.getSpecialSources(callback);
//    }

    private void runOnError(String message, Throwable throwable) {
        log.debug("Running onError with message: " + message + " and exception:", throwable);
        if (this.onError == null) {
            log.debug("No onError callback was registered");
            return;
        }

        try {
            this.onError.accept(message, throwable);
        }
        catch (Exception e) {
            log.error("Unable to run OnError callback", e);
        }
    }

    private void runOnConnectionFailed(String message, Throwable throwable) {
        log.debug("Running onConnectionFailed with message: " + message + " with exception:", throwable);

        if (this.onConnectionFailed == null) {
            log.debug("No onConnectionFailed callback was registered");
            return;
        }

        try {
            this.onConnectionFailed.accept(message);
        }
        catch (Exception e) {
            log.error("Unable to run OnConnectionFailed callback", e);
        }
    }
}
