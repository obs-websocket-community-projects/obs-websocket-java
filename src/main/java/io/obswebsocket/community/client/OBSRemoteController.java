package io.obswebsocket.community.client;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListener;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestBatch;
import io.obswebsocket.community.client.message.request.config.*;
import io.obswebsocket.community.client.message.request.filters.*;
import io.obswebsocket.community.client.message.request.general.*;
import io.obswebsocket.community.client.message.request.inputs.*;
import io.obswebsocket.community.client.message.request.outputs.*;
import io.obswebsocket.community.client.message.request.record.*;
import io.obswebsocket.community.client.message.request.sceneItems.*;
import io.obswebsocket.community.client.message.request.scenes.*;
import io.obswebsocket.community.client.message.request.sources.GetSourceActiveRequest;
import io.obswebsocket.community.client.message.request.sources.GetSourceScreenshotRequest;
import io.obswebsocket.community.client.message.request.sources.SaveSourceScreenshotRequest;
import io.obswebsocket.community.client.message.request.transitions.*;
import io.obswebsocket.community.client.message.response.RequestBatchResponse;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.config.*;
import io.obswebsocket.community.client.message.response.filters.*;
import io.obswebsocket.community.client.message.response.general.*;
import io.obswebsocket.community.client.message.response.inputs.*;
import io.obswebsocket.community.client.message.response.outputs.*;
import io.obswebsocket.community.client.message.response.record.*;
import io.obswebsocket.community.client.message.response.sceneItems.*;
import io.obswebsocket.community.client.message.response.scenes.*;
import io.obswebsocket.community.client.message.response.sources.GetSourceActiveResponse;
import io.obswebsocket.community.client.message.response.sources.GetSourceScreenshotResponse;
import io.obswebsocket.community.client.message.response.sources.SaveSourceScreenshotResponse;
import io.obswebsocket.community.client.message.response.transitions.*;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.model.Projector;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.ConnectException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

@Slf4j
public class OBSRemoteController {

    private String address;
    private final OBSCommunicator communicator;
    private final WebSocketClient webSocketClient;
    private final int connectionTimeoutSeconds;

    private final ControllerLifecycleListener controllerLifecycleListener;

    private boolean failed;

    /**
     * All-Args constructor, used by the builder or directly.
     * @param webSocketClient WebSocketClient instance.
     * @param communicator Instance of {@link OBSCommunicator} (annotated websocket listener).
     * @param controllerLifecycleListener Instance of {@link ControllerLifecycleListener}
     * @param host OBS Host,
     * @param port OBS port.
     * @param connectionTimeoutSeconds Seconds timeout while trying to make first connection to OBS. Must be greater than zero.
     * @param autoConnect If true, will connect after this class is instantiated.
     */
    public OBSRemoteController(
      WebSocketClient webSocketClient,
      OBSCommunicator communicator,
      ControllerLifecycleListener controllerLifecycleListener,
      String host,
      int port,
      int connectionTimeoutSeconds,
      boolean autoConnect) {
        if(connectionTimeoutSeconds < 0) {
            throw new IllegalArgumentException("Connection timeout must be greater than zero");
        }
        this.webSocketClient = webSocketClient;
        this.communicator = communicator;
        this.controllerLifecycleListener = controllerLifecycleListener;
        this.address = "ws://" + host + ":" + port;
        this.connectionTimeoutSeconds = connectionTimeoutSeconds;
        if (autoConnect) {
            connect();
        }
    }

    public static ObsRemoteControllerBuilder builder() {
        return new ObsRemoteControllerBuilder();
    }

    public void connect() {

        // Try to start the websocket client, this generally shouldn't fail
        try {
            this.webSocketClient.start();
        }
        catch (Exception e) {
            this.controllerLifecycleListener.onError(
              this,
              new ReasonThrowable("Unexpected error, failed to start WebSocketClient", e)
            );
            this.failed = true;
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
            connection.get(connectionTimeoutSeconds, TimeUnit.SECONDS);
            this.failed = false;
            // technically this isn't ready until Identified...consider improving
            // by registering to callback
            this.controllerLifecycleListener.onReady(this);
        } catch (Throwable t) {
            this.failed = true;
            if(t instanceof TimeoutException
              || (t instanceof ExecutionException && t.getCause() != null && t.getCause() instanceof ConnectException)) {
                this.controllerLifecycleListener.onError(this,
                  new ReasonThrowable("Could not contact OBS on: " + this.address,
                    t.getCause() == null
                      ? t
                      : t.getCause()
                  )
                );
            }
        }
    }

    public void disconnect() {
        // trigger the latch
        try {
            log.debug("Closing connection.");
            this.communicator.awaitClose(connectionTimeoutSeconds, TimeUnit.SECONDS);
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

    /**
     * Send a Request
     *
     * @param request R
     * @param callback Consumer&lt;RR&gt;
     * @param <R> extends {@link Request}
     * @param <RR> extends {@link RequestResponse}
     */
    public <R extends Request, RR extends RequestResponse> void sendRequest(R request, Consumer<RR> callback) {
        this.communicator.sendRequest(request, callback);
    }

    /**
     * Send a RequestBatch
     *
     * @param requestBatch {@link RequestBatch}
     * @param callback Consumer&lt;{@link RequestBatchResponse}&gt;
     */
    public void sendRequestBatch(RequestBatch requestBatch, Consumer<RequestBatchResponse> callback) {
        this.communicator.sendRequestBatch(requestBatch, callback);
    }

    public void getVersion(Consumer<GetVersionResponse> callback) {
        this.sendRequest(GetVersionRequest.builder().build(), callback);
    }

    public void getStudioModeEnabled(Consumer<GetStudioModeEnabledResponse> callback) {
        this.sendRequest(GetStudioModeEnabledRequest.builder().build(), callback);
    }

    public void setStudioModeEnabled(boolean studioModeEnabled, Consumer<SetStudioModeEnabledResponse> callback) {
        this.sendRequest(SetStudioModeEnabledRequest.builder().studioModeEnabled(studioModeEnabled).build(), callback);
    }

    public void broadcastCustomEvent(JsonObject customEventData, Consumer<BroadcastCustomEventResponse> callback) {
        this.sendRequest(BroadcastCustomEventRequest.builder().requestData(customEventData).build(), callback);
    }

    public void sleep(Long sleepMillis, Consumer<BroadcastCustomEventResponse> callback) {
        this.sendRequest(SleepRequest.builder().sleepMillis(sleepMillis).build(), callback);
    }

    public void getSceneList(Consumer<GetSceneListResponse> callback) {
        this.sendRequest(GetSceneListRequest.builder().build(), callback);
    }

    public void getGetHotkeyList(Consumer<GetHotkeyListResponse> callback) {
        this.sendRequest(GetHotkeyListRequest.builder().build(), callback);
    }

    public void triggerHotkeyByName(String hotkeyName, Consumer<TriggerHotkeyByNameResponse> callback) {
        this.sendRequest(TriggerHotkeyByNameRequest.builder().hotkeyName(hotkeyName).build(), callback);
    }

    public void triggerHotkeyByKeySequence(String keyId, TriggerHotkeyByKeySequenceRequest.KeyModifiers keyModifiers, Consumer<TriggerHotkeyByKeySequenceResponse> callback) {
        this.sendRequest(TriggerHotkeyByKeySequenceRequest.builder().keyId(keyId).keyModifiers(keyModifiers).build(), callback);
    }

    public void getSceneCollectionList(Consumer<GetSceneCollectionListResponse> callback) {
        this.sendRequest(GetSceneCollectionListRequest.builder().build(), callback);
    }

    public void setCurrentSceneCollection(String sceneCollectionName, Consumer<SetCurrentSceneCollectionResponse> callback) {
        this.sendRequest(SetCurrentSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
    }

    public void createSceneCollectionRequest(String sceneCollectionName, Consumer<CreateSceneCollectionResponse> callback) {
        this.sendRequest(CreateSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
    }

    public void removeSceneCollectionRequest(String sceneCollectionName, Consumer<RemoveSceneCollectionResponse> callback) {
        this.sendRequest(RemoveSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
    }

    public void getCurrentProgramSceneRequest(Consumer<GetCurrentProgramSceneResponse> callback) {
        this.sendRequest(GetCurrentProgramSceneRequest.builder().build(), callback);
    }

    public void setCurrentProgramSceneRequest(String sceneName, Consumer<SetCurrentProgramSceneResponse> callback) {
        this.sendRequest(SetCurrentProgramSceneRequest.builder().sceneName(sceneName).build(), callback);
    }

    public void getCurrentPreviewSceneRequest(Consumer<GetCurrentPreviewSceneResponse> callback) {
        this.sendRequest(GetCurrentPreviewSceneRequest.builder().build(), callback);
    }

    public void setCurrentPreviewSceneRequest(String sceneName, Consumer<SetCurrentPreviewSceneResponse> callback) {
        this.sendRequest(SetCurrentPreviewSceneRequest.builder().sceneName(sceneName).build(), callback);
    }

    public void createSceneRequest(String sceneName, Consumer<CreateSceneResponse> callback) {
        this.sendRequest(CreateSceneRequest.builder().sceneName(sceneName).build(), callback);
    }

    public void getProfileList(Consumer<GetProfileListResponse> callback) {
        this.sendRequest(GetProfileListRequest.builder().build(), callback);
    }

    public void getProfileParameterRequest(String parameterCategory, String parameterName, Consumer<GetProfileParameterResponse> callback) {
        this.sendRequest(GetProfileParameterRequest.builder().parameterCategory(parameterCategory).parameterName(parameterName).build(), callback);
    }

    public void setProfileParameterRequest(String parameterCategory, String parameterName, String parameterValue, Consumer<SetProfileParameterResponse> callback) {
        this.sendRequest(SetProfileParameterRequest.builder().parameterCategory(parameterCategory).parameterName(parameterName).parameterValue(parameterValue).build(), callback);
    }

    public void removeSceneRequest(String sceneName, Consumer<RemoveSceneResponse> callback) {
        this.sendRequest(RemoveSceneRequest.builder().sceneName(sceneName).build(), callback);
    }

    public void setSceneName(String sceneName, String newSceneName, Consumer<SetSceneNameResponse> callback) {
        this.sendRequest(SetSceneNameRequest.builder().sceneName(sceneName).newSceneName(newSceneName).build(), callback);
    }

    public void getSourceActiveRequest(String sourceName, Consumer<GetSourceActiveResponse> callback) {
        this.sendRequest(GetSourceActiveRequest.builder().sourceName(sourceName).build(), callback);
    }

    public void getInputListRequest(String inputKind, Consumer<GetInputListResponse> callback) {
        this.sendRequest(GetInputListRequest.builder().inputKind(inputKind).build(), callback);
    }

    public void getInputDefaultSettingsRequest(String inputKind, Consumer<GetInputDefaultSettingsResponse> callback) {
        this.sendRequest(GetInputDefaultSettingsRequest.builder().inputKind(inputKind).build(), callback);
    }

    public void getInputKindListRequest(Boolean unversioned, Consumer<GetInputListResponse> callback) {
        this.sendRequest(GetInputKindListRequest.builder().unversioned(unversioned).build(), callback);
    }

    public void getInputSettingsRequest(String inputName, Consumer<GetInputSettingsResponse> callback) {
        this.sendRequest(GetInputSettingsRequest.builder().inputName(inputName).build(), callback);
    }

    public void setInputSettingsRequest(String inputName, JsonObject inputSettings, Boolean overlay, Consumer<SetInputSettingsResponse> callback) {
        this.sendRequest(SetInputSettingsRequest.builder().inputName(inputName).inputSettings(inputSettings).overlay(overlay).build(), callback);
    }

    public void getInputMuteRequest(String inputName, Consumer<GetInputMuteResponse> callback) {
        this.sendRequest(GetInputMuteRequest.builder().inputName(inputName).build(), callback);
    }

    public void setInputMuteRequest(String inputName, boolean inputMuted, Consumer<SetInputMuteResponse> callback) {
        this.sendRequest(SetInputMuteRequest.builder().inputName(inputName).inputMuted(inputMuted).build(), callback);
    }

    public void toggleInputMuteRequest(String inputName, Consumer<ToggleInputMuteResponse> callback) {
        this.sendRequest(ToggleInputMuteRequest.builder().inputName(inputName).build(), callback);
    }

    public void getInputVolumeRequest(String inputName, Consumer<GetInputVolumeResponse> callback) {
        this.sendRequest(GetInputVolumeRequest.builder().inputName(inputName).build(), callback);
    }

    public void getSourceScreenshotRequest(String sourceName, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality, Consumer<GetSourceScreenshotResponse> callback) {
        this.sendRequest(GetSourceScreenshotRequest.builder().sourceName(sourceName).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build(), callback);
    }

    public void saveSourceScreenshotRequest(String sourceName, String imageFilePath, String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality, Consumer<SaveSourceScreenshotResponse> callback) {
        this.sendRequest(SaveSourceScreenshotRequest.builder().sourceName(sourceName).imageFilePath(imageFilePath).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build(), callback);
    }

    public void openProjectorRequest(Projector.Type projectorType, Integer projectorMonitor, String projectorGeometry, String sourceName, Consumer<OpenProjectorResponse> callback) {
        this.sendRequest(OpenProjectorRequest.builder().projectorType(projectorType).projectorMonitor(projectorMonitor).projectorGeometry(projectorGeometry).sourceName(sourceName).build(), callback);
    }

    public void getVideoSettingsRequest(Consumer<GetVideoSettingsResponse> callback) {
        this.sendRequest(GetVideoSettingsRequest.builder().build(), callback);
    }

    public void deleteSceneTransitionOverrideRequest(String sceneName, Consumer<DeleteSceneTransitionOverrideResponse> callback) {
        this.sendRequest(DeleteSceneTransitionOverrideRequest.builder().sceneName(sceneName).build(), callback);
    }

    public void getSceneTransitionOverrideRequest(String sceneName, Consumer<GetSceneTransitionOverrideResponse> callback) {
        this.sendRequest(DeleteSceneTransitionOverrideRequest.builder().sceneName(sceneName).build(), callback);
    }

    public void setSceneTransitionOverrideRequest(String sceneName, String transitionName, Integer transitionDuration, Consumer<SetSceneTransitionOverrideResponse> callback) {
        this.sendRequest(SetSceneTransitionOverrideRequest.builder().sceneName(sceneName).transitionName(transitionName).transitionDuration(transitionDuration).build(), callback);
    }

    public void getSpecialInputNamesRequest(Consumer<GetSpecialInputNamesResponse> callback) {
        this.sendRequest(GetSpecialInputNamesRequest.builder().build(), callback);
    }

    public void setInputNameRequest(String inputName, String newInputName, Consumer<SetInputNameResponse> callback) {
        this.sendRequest(SetInputNameRequest.builder().inputName(inputName).newInputName(newInputName).build(), callback);
    }

    public void setInputVolumeRequest(String inputName, Float inputVolumeDb, Float inputVolumeMul, Consumer<SetInputVolumeResponse> callback) {
        this.sendRequest(SetInputVolumeRequest.builder().inputName(inputName).inputVolumeDb(inputVolumeDb).inputVolumeMul(inputVolumeMul).build(), callback);
    }

    public void createInputRequest(String inputName, String inputKind, String sceneName, JsonObject inputSettings, Boolean sceneItemEnabled, Consumer<CreateInputResponse> callback) {
        this.sendRequest(CreateInputRequest.builder().inputName(inputName).inputKind(inputKind).sceneName(sceneName).inputSettings(inputSettings).sceneItemEnabled(sceneItemEnabled).build(), callback);
    }

    public void getInputTracksRequest(String inputName, Consumer<GetInputTracksResponse> callback) {
        this.sendRequest(GetInputTracksRequest.builder().inputName(inputName).build(), callback);
    }

    public void getInputMonitorTypeRequest(String inputName, Consumer<GetInputMonitorTypeResponse> callback) {
        this.sendRequest(GetInputMonitorTypeRequest.builder().inputName(inputName).build(), callback);
    }

    public void setInputMonitorTypeRequest(String inputName, Input.MonitorType monitorType, Consumer<SetInputMonitorTypeResponse> callback) {
        this.sendRequest(SetInputMonitorTypeRequest.builder().inputName(inputName).monitorType(monitorType).build(), callback);
    }

    public void getCurrentTransitionRequest(Consumer<GetCurrentTransitionResponse> callback) {
        this.sendRequest(GetCurrentTransitionRequest.builder().build(), callback);
    }

    public void getTransitionListRequest(Consumer<GetTransitionListResponse> callback) {
        this.sendRequest(GetTransitionListRequest.builder().build(), callback);
    }

    public void getTransitionSettingsRequest(String transitionName, Consumer<GetTransitionSettingsResponse> callback) {
        this.sendRequest(GetTransitionSettingsRequest.builder().transitionName(transitionName).build(), callback);
    }

    public void setCurrentTransitionDurationRequest(Integer transitionDuration, Consumer<SetCurrentTransitionDurationResponse> callback) {
        this.sendRequest(SetCurrentTransitionDurationRequest.builder().transitionDuration(transitionDuration).build(), callback);
    }

    public void setCurrentTransitionRequest(String transitionName, Consumer<SetCurrentTransitionResponse> callback) {
        this.sendRequest(SetCurrentTransitionRequest.builder().transitionName(transitionName).build(), callback);
    }

    public void setTransitionSettingsRequest(String transitionName, JsonObject transitionSettings, Consumer<SetTransitionSettingsResponse> callback) {
        this.sendRequest(SetTransitionSettingsRequest.builder().transitionName(transitionName).transitionSettings(transitionSettings).build(), callback);
    }

    public void releaseTbarRequest(Consumer<ReleaseTbarResponse> callback) {
        this.sendRequest(ReleaseTbarRequest.builder().build(), callback);
    }

    public void setTbarPositionRequest(Double position, Boolean release, Consumer<SetTbarPositionResponse> callback) {
        this.sendRequest(SetTbarPositionRequest.builder().position(position).release(release).build(), callback);
    }

    public void triggerStudioModeTransitionRequest(Consumer<TriggerStudioModeTransitionResponse> callback) {
        this.sendRequest(TriggerStudioModeTransitionRequest.builder().build(), callback);
    }

    public void getSourceFilterListRequest(String sourceName, Consumer<GetSourceFilterListResponse> callback) {
        this.sendRequest(GetSourceFilterListRequest.builder().sourceName(sourceName).build(), callback);
    }

    public void getSourceFilterRequest(String sourceName, String filterName, Consumer<GetSourceFilterResponse> callback) {
        this.sendRequest(GetSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(), callback);
    }

    public void setSourceFilterIndexRequest(String sourceName, String filterName, Integer filterIndex, Consumer<SetSourceFilterIndexResponse> callback) {
        this.sendRequest(SetSourceFilterIndexRequest.builder().sourceName(sourceName).filterName(filterName).filterIndex(filterIndex).build(), callback);
    }

    public void createSourceFilterRequest(String sourceName, String filterName, Integer filterIndex, String filterKind, JsonObject filterSettings, Consumer<CreateSourceFilterResponse> callback) {
        this.sendRequest(CreateSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).filterKind(filterKind).filterSettings(filterSettings).filterIndex(filterIndex).build(), callback);
    }

    public void removeSourceFilterRequest(String sourceName, String filterName, Consumer<RemoveSourceFilterResponse> callback) {
        this.sendRequest(RemoveSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(), callback);
    }

    public void setSourceFilterEnabledRequest(String sourceName, String filterName, Boolean filterEnabled, Consumer<SetSourceFilterEnabledResponse> callback) {
        this.sendRequest(SetSourceFilterEnabledRequest.builder().sourceName(sourceName).filterName(filterName).filterEnabled(filterEnabled).build(), callback);
    }

    public void setSourceFilterSettingsRequest(String sourceName, String filterName, JsonObject filterSettings, Consumer<SetSourceFilterEnabledResponse> callback) {
        this.sendRequest(SetSourceFilterSettingsRequest.builder().sourceName(sourceName).filterName(filterName).filterSettings(filterSettings).build(), callback);
    }

    public void getSceneItemListRequest(String sceneName, Consumer<GetSceneItemListResponse> callback) {
        this.sendRequest(GetSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
    }

    public void getSceneItemEnabledRequest(String sceneName, Integer sceneItemId, Consumer<GetSceneItemEnabledResponse> callback) {
        this.sendRequest(GetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    }

    public void setSceneItemEnabledRequest(String sceneName, Integer sceneItemId, Boolean sceneItemEnabled, Consumer<SetSceneItemEnabledResponse> callback) {
        this.sendRequest(SetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemEnabled(sceneItemEnabled).build(), callback);
    }

    public void getSceneItemLockedRequest(String sceneName, Integer sceneItemId, Consumer<GetSceneItemLockedResponse> callback) {
        this.sendRequest(GetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    }

    public void setSceneItemLockedRequest(String sceneName, Integer sceneItemId, Boolean sceneItemLocked, Consumer<SetSceneItemLockedResponse> callback) {
        this.sendRequest(SetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemLocked(sceneItemLocked).build(), callback);
    }

    public void getSceneItemColor(String sceneName, Integer sceneItemId, Consumer<GetSceneItemColorResponse> callback) {
        this.sendRequest(GetSceneItemColorRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    }

    public void setSceneItemIndexRequest(String sceneName, Integer sceneItemId, Integer sceneItemIndex, Consumer<SetSceneItemIndexResponse> callback) {
        this.sendRequest(SetSceneItemIndexRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemIndex(sceneItemIndex).build(), callback);
    }

    public void createSceneItem(String sceneName, String inputName, Consumer<CreateSceneItemResponse> callback) {
        this.sendRequest(CreateSceneItemRequest.builder().sceneName(sceneName).inputName(inputName).build(), callback);
    }

    public void removeSceneItem(String sceneName, Integer sceneItemId, Consumer<RemoveSceneItemResponse> callback) {
        this.sendRequest(RemoveSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    }

    public void duplicateSceneItem(String sceneName, Integer sceneItemId, String destinationSceneName, Consumer<DuplicateSceneItemResponse> callback) {
        this.sendRequest(DuplicateSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).destinationSceneName(destinationSceneName).build(), callback);
    }

    public void getLastReplayBufferReplayRequest(Consumer<GetLastReplayBufferReplayResponse> callback) {
        this.sendRequest(GetLastReplayBufferReplayRequest.builder().build(), callback);
    }

    public void getOutputListRequest(Consumer<GetOutputListResponse> callback) {
        this.sendRequest(GetOutputListRequest.builder().build(), callback);
    }

    public void getReplayBufferStatusRequest(Consumer<GetReplayBufferStatusResponse> callback) {
        this.sendRequest(GetReplayBufferStatusRequest.builder().build(), callback);
    }

    public void saveReplayBufferRequest(Consumer<SaveReplayBufferResponse> callback) {
        this.sendRequest(SaveReplayBufferRequest.builder().build(), callback);
    }

    public void startOutputRequest(String outputName, Consumer<StartOutputResponse> callback) {
        this.sendRequest(StartOutputRequest.builder().outputName(outputName).build(), callback);
    }

    public void stopOutputRequest(String outputName, Consumer<StopOutputResponse> callback) {
        this.sendRequest(StopOutputRequest.builder().outputName(outputName).build(), callback);
    }

    public void stopReplayBufferRequest(Consumer<StopReplayBufferResponse> callback) {
        this.sendRequest(StopReplayBufferRequest.builder().build(), callback);
    }

    public void toggleOutputRequest(String outputName, Consumer<ToggleOutputResponse> callback) {
        this.sendRequest(ToggleOutputRequest.builder().outputName(outputName).build(), callback);
    }

    public void toggleReplayBufferRequest(Consumer<ToggleReplayBufferResponse> callback) {
        this.sendRequest(ToggleReplayBufferRequest.builder().build(), callback);
    }

    public void getRecordDirectoryRequest(Consumer<GetRecordDirectoryResponse> callback) {
        this.sendRequest(GetRecordDirectoryRequest.builder().build(), callback);
    }

    public void getRecordFilenameFormattingRequest(Consumer<GetRecordFilenameFormattingResponse> callback) {
        this.sendRequest(GetRecordFilenameFormattingRequest.builder().build(), callback);
    }

    public void getRecordStatusRequest(Consumer<GetRecordStatusResponse> callback) {
        this.sendRequest(GetRecordStatusRequest.builder().build(), callback);
    }

    public void pauseRecordRequest(Consumer<PauseRecordResponse> callback) {
        this.sendRequest(PauseRecordRequest.builder().build(), callback);
    }

    public void resumeRecordRequest(Consumer<ResumeRecordResponse> callback) {
        this.sendRequest(ResumeRecordRequest.builder().build(), callback);
    }

    public void setRecordDirectoryRequest(String recordDirectory, Boolean createIfNotExist, Consumer<SetRecordDirectoryResponse> callback) {
        this.sendRequest(SetRecordDirectoryRequest.builder().recordDirectory(recordDirectory).createIfNotExist(createIfNotExist).build(), callback);
    }

    public void setRecordFilenameFormattingRequest(String filenameFormatting, Consumer<SetRecordFilenameFormattingResponse> callback) {
        this.sendRequest(SetRecordFilenameFormattingRequest.builder().filenameFormatting(filenameFormatting).build(), callback);
    }

    public void startRecordRequest(Boolean waitForResult, Consumer<StartRecordResponse> callback) {
        this.sendRequest(StartRecordRequest.builder().waitForResult(waitForResult).build(), callback);
    }

    public void stopRecordRequest(Boolean waitForResult, Consumer<StopRecordResponse> callback) {
        this.sendRequest(StopRecordRequest.builder().waitForResult(waitForResult).build(), callback);
    }

    public void toggleRecordPauseRequest(Consumer<ToggleRecordPauseResponse> callback) {
        this.sendRequest(ToggleRecordPauseRequest.builder().build(), callback);
    }

    public void toggleRecordRequest(Consumer<ToggleRecordResponse> callback) {
        this.sendRequest(ToggleRecordRequest.builder().build(), callback);
    }

    public void getSystemStatsRequest(Consumer<GetSystemStatsResponse> callback) {
        this.sendRequest(GetSystemStatsRequest.builder().build(), callback);
    }

    public void getProjectorListRequest(Consumer<GetProjectorListResponse> callback) {
        this.sendRequest(GetProjectorListRequest.builder().build(), callback);
    }

    public void closeProjectorRequest(String projectorName, Consumer<CloseProjectorResponse> callback) {
        this.sendRequest(CloseProjectorRequest.builder().projectorName(projectorName).build(), callback);
    }

    public void removeInputRequest(String inputName, Consumer<RemoveInputResponse> callback) {
        this.sendRequest(RemoveInputRequest.builder().inputName(inputName).build(), callback);
    }
}
