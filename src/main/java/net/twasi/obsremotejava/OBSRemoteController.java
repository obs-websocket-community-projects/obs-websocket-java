package net.twasi.obsremotejava;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.listener.lifecycle.controller.ControllerLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.controller.LoggingControllerLifecycleListener;
import net.twasi.obsremotejava.message.request.RequestBatch;
import net.twasi.obsremotejava.message.request.config.*;
import net.twasi.obsremotejava.message.request.general.*;
import net.twasi.obsremotejava.message.request.inputs.*;
import net.twasi.obsremotejava.message.request.scenes.*;
import net.twasi.obsremotejava.message.request.sources.GetSourceActiveRequest;
import net.twasi.obsremotejava.message.request.sources.GetSourceScreenshotRequest;
import net.twasi.obsremotejava.message.request.sources.SaveSourceScreenshotRequest;
import net.twasi.obsremotejava.message.response.RequestBatchResponse;
import net.twasi.obsremotejava.message.response.config.*;
import net.twasi.obsremotejava.message.response.general.*;
import net.twasi.obsremotejava.message.response.inputs.*;
import net.twasi.obsremotejava.message.response.scenes.*;
import net.twasi.obsremotejava.message.response.sources.GetSourceActiveResponse;
import net.twasi.obsremotejava.message.response.sources.GetSourceScreenshotResponse;
import net.twasi.obsremotejava.message.response.sources.SaveSourceScreenshotResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.ConnectException;
import java.net.URI;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Slf4j
public class OBSRemoteController {

    private String address;
    private final OBSCommunicator communicator;
    private final WebSocketClient webSocketClient;

    private final ControllerLifecycleListener controllerLifecycleListener;

    private boolean failed;

    /**
     * All-Args constructor, used by the builder or directly
     * @param webSocketClient WebSocketClient instance
     * @param communicator Instance of ObsCommunicator (annotated websocket listener)
     * @param host OBS Host
     * @param port OBS port
     * @param autoConnect If true, will connect after this class is instantiated
     */
    public OBSRemoteController(
      WebSocketClient webSocketClient,
      OBSCommunicator communicator,
      ControllerLifecycleListener controllerLifecycleListener,
      String host,
      int port,
      boolean autoConnect) {
        this.webSocketClient = webSocketClient;
        this.communicator = communicator;
        this.controllerLifecycleListener = controllerLifecycleListener;
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
        this.webSocketClient = new WebSocketClient();
        this.communicator = OBSCommunicator.builder()
          .password(password)
          .build();
        this.controllerLifecycleListener = new LoggingControllerLifecycleListener();

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

        // Try to start the websocket client, this generally shouldn't fail
        try {
            this.webSocketClient.start();
        }
        catch (Exception e) {
            this.controllerLifecycleListener.onError(
              this,
              new ReasonThrowable("Failed to start WebSocketClient", e)
            );
            return;
        }

        // Try to connect over the network with OBS
        try {
            URI uri = new URI(this.address);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = this.webSocketClient.connect(
              this.communicator, uri, request
            );
            log.info(String.format("Connecting to: %s", uri));

            // Block on the connection succeeding
            try {
                connection.get();
                this.failed = false;
                // technically this isn't ready until Identified...consider improving
                // by registering to callback
                this.controllerLifecycleListener.onReady(this);
            } catch (ExecutionException e) {
                if (e.getCause() instanceof ConnectException) {
                    this.failed = true;
                    this.controllerLifecycleListener.onError(this, new ReasonThrowable(
                      "Failed to connect to OBS! Is it running and is the websocket plugin installed?", e
                    ));
                }
                else {
                    throw e;
                }
            }
        }
        catch (Throwable t) {
            this.controllerLifecycleListener.onError(this,
                new ReasonThrowable("Failed to setup connection with OBS", t)
            );
        }
    }

    public void disconnect() {
        // trigger the latch
        try {
            log.debug("Closing connection.");
            this.communicator.awaitClose(1, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            this.controllerLifecycleListener.onError(this,
              new ReasonThrowable("Error during closing websocket connection", e)
            );
        }

        // stop the client if it isn't already stopped or stopping
        if (!this.webSocketClient.isStopped() && !this.webSocketClient.isStopping()) {
            try {
                log.debug("Stopping client.");
                this.webSocketClient.stop();
                // this technically should be registered to a communicator onClose listener
                this.controllerLifecycleListener.onDisconnect(this);
            }
            catch (Exception e) {
                this.controllerLifecycleListener.onError(this,
                  new ReasonThrowable("Error during stopping websocket client", e)
                );
            }
        }
    }

    public boolean isFailed() {
        return this.failed;
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

    public void getCurrentProgramSceneRequest(Consumer<GetCurrentProgramSceneResponse> callback) {
        this.communicator.sendRequest(new GetCurrentProgramSceneRequest(), callback);
    }

    public void setCurrentProgramSceneRequest(String sceneName, Consumer<SetCurrentProgramSceneResponse> callback) {
        this.communicator.sendRequest(new SetCurrentProgramSceneRequest(sceneName), callback);
    }

    public void getCurrentPreviewSceneRequest(Consumer<GetCurrentProgramSceneResponse> callback) {
        this.communicator.sendRequest(new GetCurrentProgramSceneRequest(), callback);
    }

    public void setCurrentPreviewSceneRequest(String sceneName, Consumer<SetCurrentPreviewSceneResponse> callback) {
        this.communicator.sendRequest(new SetCurrentPreviewSceneRequest(sceneName), callback);
    }

    public void createSceneRequest(String sceneName, Consumer<CreateSceneResponse> callback) {
        this.communicator.sendRequest(new CreateSceneRequest(sceneName), callback);
    }

    public void getProfileList(Consumer<GetProfileListResponse> callback) {
        this.communicator.sendRequest(new GetProfileListRequest(), callback);
    }

    public void getProfileParameterRequest(String parameterCategory, String parameterName, Consumer<GetProfileParameterResponse> callback) {
        this.communicator.sendRequest(new GetProfileParameterRequest(parameterCategory, parameterName), callback);
    }

    public void setProfileParameterRequest(String parameterCategory, String parameterName, String parameterValue, Consumer<SetProfileParameterResponse> callback) {
        this.communicator.sendRequest(new SetProfileParameterRequest(parameterCategory, parameterName, parameterValue), callback);
    }

    public void setProfileParameterRequest(String parameterCategory, String parameterName, Consumer<SetProfileParameterResponse> callback) {
        this.communicator.sendRequest(new SetProfileParameterRequest(parameterCategory, parameterName), callback);
    }

    public void removeSceneRequest(String sceneName, Consumer<RemoveSceneResponse> callback) {
        this.communicator.sendRequest(new RemoveSceneRequest(sceneName), callback);
    }

    public void setSceneName(String sceneName, String newSceneName, Consumer<SetSceneNameResponse> callback) {
        this.communicator.sendRequest(new SetSceneNameRequest(sceneName, newSceneName), callback);
    }

    public void getSourceActiveRequest(String sourceName, Consumer<GetSourceActiveResponse> callback) {
        this.communicator.sendRequest(new GetSourceActiveRequest(sourceName), callback);
    }

    public void getInputListRequest(Consumer<GetInputListResponse> callback) {
        this.communicator.sendRequest(new GetInputListRequest(), callback);
    }

    public void getInputListRequest(String inputKind, Consumer<GetInputListResponse> callback) {
        this.communicator.sendRequest(new GetInputListRequest(inputKind), callback);
    }

    public void getInputDefaultSettingsRequest(String inputKind, Consumer<GetInputDefaultSettingsResponse> callback) {
        this.communicator.sendRequest(new GetInputDefaultSettingsRequest(inputKind), callback);
    }

    public void getInputKindListRequest(Consumer<GetInputListResponse> callback) {
        this.communicator.sendRequest(new GetInputKindListRequest(), callback);
    }

    public void getInputKindListRequest(boolean unversioned, Consumer<GetInputListResponse> callback) {
        this.communicator.sendRequest(new GetInputKindListRequest(unversioned), callback);
    }

    public void getInputSettingsRequest(String inputName, Consumer<GetInputSettingsResponse> callback) {
        this.communicator.sendRequest(new GetInputSettingsRequest(inputName), callback);
    }

    public void setInputSettingsRequest(String inputName, JsonObject inputSettings, boolean overlay, Consumer<SetInputSettingsResponse> callback) {
        this.communicator.sendRequest(new SetInputSettingsRequest(inputName, inputSettings, overlay), callback);
    }

    public void setInputSettingsRequest(String inputName, JsonObject inputSettings, Consumer<SetInputSettingsResponse> callback) {
        this.communicator.sendRequest(new SetInputSettingsRequest(inputName, inputSettings), callback);
    }

    public void getInputMuteRequest(String inputName, Consumer<GetInputMuteResponse> callback) {
        this.communicator.sendRequest(new GetInputMuteRequest(inputName), callback);
    }

    public void setInputMuteRequest(String inputName, boolean inputMuted, Consumer<SetInputMuteResponse> callback) {
        this.communicator.sendRequest(new SetInputMuteRequest(inputName, inputMuted), callback);
    }

    public void toggleInputMuteRequest(String inputName, Consumer<ToggleInputMuteResponse> callback) {
        this.communicator.sendRequest(new ToggleInputMuteRequest(inputName), callback);
    }

    public void getInputVolumeRequest(String inputName, Consumer<GetInputVolumeResponse> callback) {
        this.communicator.sendRequest(new GetInputVolumeRequest(inputName), callback);
    }

    public void getSourceScreenshotRequest(String sourceName, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality, Consumer<GetSourceScreenshotResponse> callback) {
        this.communicator.sendRequest(new GetSourceScreenshotRequest(sourceName, imageFormat, imageWidth, imageHeight, imageCompressionQuality), callback);
    }

    public void getSourceScreenshotRequest(String sourceName, String imageFormat, Consumer<GetSourceScreenshotResponse> callback) {
        this.communicator.sendRequest(new GetSourceScreenshotRequest(sourceName, imageFormat), callback);
    }

    public void getSourceScreenshotRequest(String sourceName, String imageFormat, Integer imageWidth, Consumer<GetSourceScreenshotResponse> callback) {
        this.communicator.sendRequest(new GetSourceScreenshotRequest(sourceName, imageFormat, imageWidth), callback);
    }

    public void getSourceScreenshotRequest(String sourceName, String imageFormat, Integer imageWidth, Integer imageHeight, Consumer<GetSourceScreenshotResponse> callback) {
        this.communicator.sendRequest(new GetSourceScreenshotRequest(sourceName, imageFormat, imageWidth, imageHeight), callback);
    }

    public void saveSourceScreenshotRequest(String sourceName, String imageFilePath, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality, Consumer<SaveSourceScreenshotResponse> callback) {
        this.communicator.sendRequest(new SaveSourceScreenshotRequest(sourceName, imageFilePath, imageFormat, imageWidth, imageHeight, imageCompressionQuality), callback);
    }

    public void saveSourceScreenshotRequest(String sourceName, String imageFilePath, String imageFormat, Consumer<SaveSourceScreenshotResponse> callback) {
        this.communicator.sendRequest(new SaveSourceScreenshotRequest(sourceName, imageFilePath, imageFormat), callback);
    }

    public void saveSourceScreenshotRequest(String sourceName, String imageFilePath, String imageFormat, Integer imageWidth, Consumer<SaveSourceScreenshotResponse> callback) {
        this.communicator.sendRequest(new SaveSourceScreenshotRequest(sourceName, imageFilePath, imageFormat, imageWidth), callback);
    }

    public void saveSourceScreenshotRequest(String sourceName, String imageFilePath, String imageFormat, Integer imageWidth, Integer imageHeight, Consumer<SaveSourceScreenshotResponse> callback) {
        this.communicator.sendRequest(new SaveSourceScreenshotRequest(sourceName, imageFilePath, imageFormat, imageWidth, imageHeight), callback);
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

}
