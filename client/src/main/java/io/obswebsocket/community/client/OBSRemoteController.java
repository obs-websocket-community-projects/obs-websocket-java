package io.obswebsocket.community.client;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListener;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestBatch;
import io.obswebsocket.community.client.message.request.config.CreateProfileRequest;
import io.obswebsocket.community.client.message.request.config.CreateSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.GetProfileListRequest;
import io.obswebsocket.community.client.message.request.config.GetProfileParameterRequest;
import io.obswebsocket.community.client.message.request.config.GetRecordDirectoryRequest;
import io.obswebsocket.community.client.message.request.config.GetRecordFilenameFormattingRequest;
import io.obswebsocket.community.client.message.request.config.GetSceneCollectionListRequest;
import io.obswebsocket.community.client.message.request.config.GetStreamServiceSettingsRequest;
import io.obswebsocket.community.client.message.request.config.GetVideoSettingsRequest;
import io.obswebsocket.community.client.message.request.config.RemoveProfileRequest;
import io.obswebsocket.community.client.message.request.config.RemoveSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.SetCurrentProfileRequest;
import io.obswebsocket.community.client.message.request.config.SetCurrentSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.SetProfileParameterRequest;
import io.obswebsocket.community.client.message.request.config.SetRecordDirectoryRequest;
import io.obswebsocket.community.client.message.request.config.SetRecordFilenameFormattingRequest;
import io.obswebsocket.community.client.message.request.config.SetStreamServiceSettingsRequest;
import io.obswebsocket.community.client.message.request.config.SetVideoSettingsRequest;
import io.obswebsocket.community.client.message.request.filters.CreateSourceFilterRequest;
import io.obswebsocket.community.client.message.request.filters.GetSourceFilterListRequest;
import io.obswebsocket.community.client.message.request.filters.GetSourceFilterRequest;
import io.obswebsocket.community.client.message.request.filters.RemoveSourceFilterRequest;
import io.obswebsocket.community.client.message.request.filters.SetSourceFilterEnabledRequest;
import io.obswebsocket.community.client.message.request.filters.SetSourceFilterIndexRequest;
import io.obswebsocket.community.client.message.request.filters.SetSourceFilterSettingsRequest;
import io.obswebsocket.community.client.message.request.general.BroadcastCustomEventRequest;
import io.obswebsocket.community.client.message.request.general.CallVendorRequestRequest;
import io.obswebsocket.community.client.message.request.general.GetHotkeyListRequest;
import io.obswebsocket.community.client.message.request.general.GetStatsRequest;
import io.obswebsocket.community.client.message.request.general.GetVersionRequest;
import io.obswebsocket.community.client.message.request.general.SleepRequest;
import io.obswebsocket.community.client.message.request.general.TriggerHotkeyByKeySequenceRequest;
import io.obswebsocket.community.client.message.request.general.TriggerHotkeyByNameRequest;
import io.obswebsocket.community.client.message.request.inputs.CreateInputRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputAudioMonitorTypeRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputAudioSyncOffsetRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputAudioTracksRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputDefaultSettingsRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputKindListRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputListRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputMuteRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputPropertiesListPropertyItemsRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputSettingsRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputVolumeRequest;
import io.obswebsocket.community.client.message.request.inputs.GetSpecialInputsRequest;
import io.obswebsocket.community.client.message.request.inputs.PressInputPropertiesButtonRequest;
import io.obswebsocket.community.client.message.request.inputs.RemoveInputRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputAudioMonitorTypeRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputAudioSyncOffsetRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputMuteRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputNameRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputSettingsRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputVolumeRequest;
import io.obswebsocket.community.client.message.request.inputs.ToggleInputMuteRequest;
import io.obswebsocket.community.client.message.request.mediainputs.GetMediaInputStatusRequest;
import io.obswebsocket.community.client.message.request.mediainputs.NextMediaInputPlaylistItemRequest;
import io.obswebsocket.community.client.message.request.mediainputs.OffsetMediaInputTimecodeRequest;
import io.obswebsocket.community.client.message.request.mediainputs.PreviousMediaInputPlaylistItemRequest;
import io.obswebsocket.community.client.message.request.mediainputs.RestartMediaInputRequest;
import io.obswebsocket.community.client.message.request.mediainputs.SetMediaInputPauseStateRequest;
import io.obswebsocket.community.client.message.request.mediainputs.SetMediaInputTimecodeRequest;
import io.obswebsocket.community.client.message.request.mediainputs.StopMediaInputRequest;
import io.obswebsocket.community.client.message.request.outputs.GetLastReplayBufferReplayRequest;
import io.obswebsocket.community.client.message.request.outputs.GetOutputListRequest;
import io.obswebsocket.community.client.message.request.outputs.GetReplayBufferStatusRequest;
import io.obswebsocket.community.client.message.request.outputs.SaveReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.StartOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.StartReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.StopOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.StopReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.ToggleOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.ToggleReplayBufferRequest;
import io.obswebsocket.community.client.message.request.record.GetRecordStatusRequest;
import io.obswebsocket.community.client.message.request.record.PauseRecordRequest;
import io.obswebsocket.community.client.message.request.record.ResumeRecordRequest;
import io.obswebsocket.community.client.message.request.record.StartRecordRequest;
import io.obswebsocket.community.client.message.request.record.StopRecordRequest;
import io.obswebsocket.community.client.message.request.record.ToggleRecordPauseRequest;
import io.obswebsocket.community.client.message.request.record.ToggleRecordRequest;
import io.obswebsocket.community.client.message.request.sceneitems.CreateSceneItemRequest;
import io.obswebsocket.community.client.message.request.sceneitems.DuplicateSceneItemRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetGroupSceneItemListRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemBlendModeRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemEnabledRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemIdRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemIndexRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemListRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemLockedRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemTransformRequest;
import io.obswebsocket.community.client.message.request.sceneitems.RemoveSceneItemRequest;
import io.obswebsocket.community.client.message.request.sceneitems.SetSceneItemBlendModeRequest;
import io.obswebsocket.community.client.message.request.sceneitems.SetSceneItemEnabledRequest;
import io.obswebsocket.community.client.message.request.sceneitems.SetSceneItemIndexRequest;
import io.obswebsocket.community.client.message.request.sceneitems.SetSceneItemLockedRequest;
import io.obswebsocket.community.client.message.request.sceneitems.SetSceneItemTransformRequest;
import io.obswebsocket.community.client.message.request.scenes.CreateSceneRequest;
import io.obswebsocket.community.client.message.request.scenes.GetCurrentPreviewSceneRequest;
import io.obswebsocket.community.client.message.request.scenes.GetCurrentProgramSceneRequest;
import io.obswebsocket.community.client.message.request.scenes.GetGroupListRequest;
import io.obswebsocket.community.client.message.request.scenes.GetSceneListRequest;
import io.obswebsocket.community.client.message.request.scenes.GetSceneSceneTransitionOverrideRequest;
import io.obswebsocket.community.client.message.request.scenes.RemoveSceneRequest;
import io.obswebsocket.community.client.message.request.scenes.SetCurrentPreviewSceneRequest;
import io.obswebsocket.community.client.message.request.scenes.SetCurrentProgramSceneRequest;
import io.obswebsocket.community.client.message.request.scenes.SetSceneNameRequest;
import io.obswebsocket.community.client.message.request.scenes.SetSceneSceneTransitionOverrideRequest;
import io.obswebsocket.community.client.message.request.sources.GetSourceActiveRequest;
import io.obswebsocket.community.client.message.request.sources.GetSourceScreenshotRequest;
import io.obswebsocket.community.client.message.request.sources.SaveSourceScreenshotRequest;
import io.obswebsocket.community.client.message.request.stream.GetStreamStatusRequest;
import io.obswebsocket.community.client.message.request.stream.SendStreamCaptionRequest;
import io.obswebsocket.community.client.message.request.stream.StartStreamRequest;
import io.obswebsocket.community.client.message.request.stream.StopStreamRequest;
import io.obswebsocket.community.client.message.request.stream.ToggleStreamRequest;
import io.obswebsocket.community.client.message.request.transitions.GetCurrentTransitionRequest;
import io.obswebsocket.community.client.message.request.transitions.GetTransitionListRequest;
import io.obswebsocket.community.client.message.request.transitions.GetTransitionSettingsRequest;
import io.obswebsocket.community.client.message.request.transitions.ReleaseTbarRequest;
import io.obswebsocket.community.client.message.request.transitions.SetCurrentTransitionDurationRequest;
import io.obswebsocket.community.client.message.request.transitions.SetCurrentTransitionRequest;
import io.obswebsocket.community.client.message.request.transitions.SetTbarPositionRequest;
import io.obswebsocket.community.client.message.request.transitions.SetTransitionSettingsRequest;
import io.obswebsocket.community.client.message.request.transitions.TriggerStudioModeTransitionRequest;
import io.obswebsocket.community.client.message.request.ui.GetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.request.ui.SetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.response.RequestBatchResponse;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.config.CreateProfileResponse;
import io.obswebsocket.community.client.message.response.config.CreateSceneCollectionResponse;
import io.obswebsocket.community.client.message.response.config.GetProfileListResponse;
import io.obswebsocket.community.client.message.response.config.GetProfileParameterResponse;
import io.obswebsocket.community.client.message.response.config.GetRecordDirectoryResponse;
import io.obswebsocket.community.client.message.response.config.GetRecordFilenameFormattingResponse;
import io.obswebsocket.community.client.message.response.config.GetSceneCollectionListResponse;
import io.obswebsocket.community.client.message.response.config.GetStreamServiceSettingsResponse;
import io.obswebsocket.community.client.message.response.config.GetVideoSettingsResponse;
import io.obswebsocket.community.client.message.response.config.RemoveProfileResponse;
import io.obswebsocket.community.client.message.response.config.RemoveSceneCollectionResponse;
import io.obswebsocket.community.client.message.response.config.SetCurrentProfileResponse;
import io.obswebsocket.community.client.message.response.config.SetCurrentSceneCollectionResponse;
import io.obswebsocket.community.client.message.response.config.SetProfileParameterResponse;
import io.obswebsocket.community.client.message.response.config.SetRecordDirectoryResponse;
import io.obswebsocket.community.client.message.response.config.SetRecordFilenameFormattingResponse;
import io.obswebsocket.community.client.message.response.config.SetStreamServiceSettingsResponse;
import io.obswebsocket.community.client.message.response.filters.CreateSourceFilterResponse;
import io.obswebsocket.community.client.message.response.filters.GetSourceFilterListResponse;
import io.obswebsocket.community.client.message.response.filters.GetSourceFilterResponse;
import io.obswebsocket.community.client.message.response.filters.RemoveSourceFilterResponse;
import io.obswebsocket.community.client.message.response.filters.SetSourceFilterEnabledResponse;
import io.obswebsocket.community.client.message.response.filters.SetSourceFilterIndexResponse;
import io.obswebsocket.community.client.message.response.general.BroadcastCustomEventResponse;
import io.obswebsocket.community.client.message.response.general.CallVendorRequestResponse;
import io.obswebsocket.community.client.message.response.general.GetHotkeyListResponse;
import io.obswebsocket.community.client.message.response.general.GetStatsResponse;
import io.obswebsocket.community.client.message.response.general.GetVersionResponse;
import io.obswebsocket.community.client.message.response.general.TriggerHotkeyByKeySequenceResponse;
import io.obswebsocket.community.client.message.response.general.TriggerHotkeyByNameResponse;
import io.obswebsocket.community.client.message.response.inputs.CreateInputResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputAudioMonitorTypeResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputAudioSyncOffsetResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputAudioTracksResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputDefaultSettingsResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputListResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputMuteResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputPropertiesListPropertyItemsResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputSettingsResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputVolumeResponse;
import io.obswebsocket.community.client.message.response.inputs.GetSpecialInputsResponse;
import io.obswebsocket.community.client.message.response.inputs.PressInputPropertiesButtonResponse;
import io.obswebsocket.community.client.message.response.inputs.RemoveInputResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputAudioMonitorTypeResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputAudioSyncOffsetResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputMuteResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputNameResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputSettingsResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputVolumeResponse;
import io.obswebsocket.community.client.message.response.inputs.ToggleInputMuteResponse;
import io.obswebsocket.community.client.message.response.mediainputs.GetMediaInputStatusResponse;
import io.obswebsocket.community.client.message.response.mediainputs.NextMediaInputPlaylistItemResponse;
import io.obswebsocket.community.client.message.response.mediainputs.OffsetMediaInputTimecodeResponse;
import io.obswebsocket.community.client.message.response.mediainputs.PreviousMediaInputPlaylistItemResponse;
import io.obswebsocket.community.client.message.response.mediainputs.RestartMediaInputResponse;
import io.obswebsocket.community.client.message.response.mediainputs.SetMediaInputPauseStateResponse;
import io.obswebsocket.community.client.message.response.mediainputs.SetMediaInputTimecodeResponse;
import io.obswebsocket.community.client.message.response.mediainputs.StopMediaInputResponse;
import io.obswebsocket.community.client.message.response.outputs.GetLastReplayBufferReplayResponse;
import io.obswebsocket.community.client.message.response.outputs.GetOutputListResponse;
import io.obswebsocket.community.client.message.response.outputs.GetReplayBufferStatusResponse;
import io.obswebsocket.community.client.message.response.outputs.SaveReplayBufferResponse;
import io.obswebsocket.community.client.message.response.outputs.StartOutputResponse;
import io.obswebsocket.community.client.message.response.outputs.StartReplayBufferResponse;
import io.obswebsocket.community.client.message.response.outputs.StopOutputResponse;
import io.obswebsocket.community.client.message.response.outputs.StopReplayBufferResponse;
import io.obswebsocket.community.client.message.response.outputs.ToggleOutputResponse;
import io.obswebsocket.community.client.message.response.outputs.ToggleReplayBufferResponse;
import io.obswebsocket.community.client.message.response.record.GetRecordStatusResponse;
import io.obswebsocket.community.client.message.response.record.PauseRecordResponse;
import io.obswebsocket.community.client.message.response.record.ResumeRecordResponse;
import io.obswebsocket.community.client.message.response.record.StartRecordResponse;
import io.obswebsocket.community.client.message.response.record.StopRecordResponse;
import io.obswebsocket.community.client.message.response.record.ToggleRecordPauseResponse;
import io.obswebsocket.community.client.message.response.record.ToggleRecordResponse;
import io.obswebsocket.community.client.message.response.sceneitems.CreateSceneItemResponse;
import io.obswebsocket.community.client.message.response.sceneitems.DuplicateSceneItemResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetGroupSceneItemListResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemBlendModeResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemEnabledResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemIdResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemIndexResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemListResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemLockedResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemTransformResponse;
import io.obswebsocket.community.client.message.response.sceneitems.RemoveSceneItemResponse;
import io.obswebsocket.community.client.message.response.sceneitems.SetSceneItemBlendModeResponse;
import io.obswebsocket.community.client.message.response.sceneitems.SetSceneItemEnabledResponse;
import io.obswebsocket.community.client.message.response.sceneitems.SetSceneItemIndexResponse;
import io.obswebsocket.community.client.message.response.sceneitems.SetSceneItemLockedResponse;
import io.obswebsocket.community.client.message.response.sceneitems.SetSceneItemTransformResponse;
import io.obswebsocket.community.client.message.response.scenes.CreateSceneResponse;
import io.obswebsocket.community.client.message.response.scenes.GetCurrentPreviewSceneResponse;
import io.obswebsocket.community.client.message.response.scenes.GetCurrentProgramSceneResponse;
import io.obswebsocket.community.client.message.response.scenes.GetGroupListResponse;
import io.obswebsocket.community.client.message.response.scenes.GetSceneListResponse;
import io.obswebsocket.community.client.message.response.scenes.GetSceneSceneTransitionOverrideResponse;
import io.obswebsocket.community.client.message.response.scenes.RemoveSceneResponse;
import io.obswebsocket.community.client.message.response.scenes.SetCurrentPreviewSceneResponse;
import io.obswebsocket.community.client.message.response.scenes.SetCurrentProgramSceneResponse;
import io.obswebsocket.community.client.message.response.scenes.SetSceneNameResponse;
import io.obswebsocket.community.client.message.response.scenes.SetSceneTransitionOverrideResponse;
import io.obswebsocket.community.client.message.response.sources.GetSourceActiveResponse;
import io.obswebsocket.community.client.message.response.sources.GetSourceScreenshotResponse;
import io.obswebsocket.community.client.message.response.sources.SaveSourceScreenshotResponse;
import io.obswebsocket.community.client.message.response.stream.GetStreamStatusResponse;
import io.obswebsocket.community.client.message.response.stream.SendStreamCaptionResponse;
import io.obswebsocket.community.client.message.response.stream.StartStreamResponse;
import io.obswebsocket.community.client.message.response.stream.StopStreamResponse;
import io.obswebsocket.community.client.message.response.stream.ToggleStreamResponse;
import io.obswebsocket.community.client.message.response.transitions.GetCurrentTransitionResponse;
import io.obswebsocket.community.client.message.response.transitions.GetTransitionListResponse;
import io.obswebsocket.community.client.message.response.transitions.GetTransitionSettingsResponse;
import io.obswebsocket.community.client.message.response.transitions.ReleaseTbarResponse;
import io.obswebsocket.community.client.message.response.transitions.SetCurrentTransitionDurationResponse;
import io.obswebsocket.community.client.message.response.transitions.SetCurrentTransitionResponse;
import io.obswebsocket.community.client.message.response.transitions.SetTbarPositionResponse;
import io.obswebsocket.community.client.message.response.transitions.SetTransitionSettingsResponse;
import io.obswebsocket.community.client.message.response.transitions.TriggerStudioModeTransitionResponse;
import io.obswebsocket.community.client.message.response.ui.GetStudioModeEnabledResponse;
import io.obswebsocket.community.client.message.response.ui.SetStudioModeEnabledResponse;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.model.SceneItemBlendMode;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

/**
 * This is the main entrypoint for the client. It provides methods for making requests against OBS
 * Websocket, and its builder (${@link OBSRemoteControllerBuilder}) provides methods to register
 * OBS Websocket event listeners and lifecycle callbacks for this client (see
 * ${@link io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListener}
 * and ${@link ControllerLifecycleListener} for more information on these lifecycle callbacks).
 */
@Slf4j
public class OBSRemoteController {

  private final URI uri;
  private final OBSCommunicator communicator;
  private final WebSocketClient webSocketClient;
  private final int connectionTimeoutSeconds;

  private final ControllerLifecycleListener controllerLifecycleListener;

  /**
   * All-Args constructor, used by the builder or directly.
   *
   * @param webSocketClient             WebSocketClient instance.
   * @param communicator                Instance of {@link OBSCommunicator} (annotated websocket
   *                                    listener).
   * @param controllerLifecycleListener Instance of {@link ControllerLifecycleListener}
   * @param host                        OBS Host,
   * @param port                        OBS port.
   * @param connectionTimeoutSeconds    Seconds timeout while trying to make first connection to
   *                                    OBS. Must be greater than zero.
   * @param autoConnect                 If true, will connect after this class is instantiated.
   */
  public OBSRemoteController(
          WebSocketClient webSocketClient,
          OBSCommunicator communicator,
          ControllerLifecycleListener controllerLifecycleListener,
          String host,
          int port,
          int connectionTimeoutSeconds,
          boolean autoConnect) {
    if (connectionTimeoutSeconds < 0) {
      throw new IllegalArgumentException("Connection timeout must be greater than zero");
    }
    this.webSocketClient = webSocketClient;
    this.communicator = communicator;
    this.controllerLifecycleListener = controllerLifecycleListener;
    try {
      this.uri = new URI("ws://" + host + ":" + port);
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException("Host or Port are invalid");
    }
    this.connectionTimeoutSeconds = connectionTimeoutSeconds;
    if (autoConnect) {
      connect();
    }
  }

  public static OBSRemoteControllerBuilder builder() {
    return new OBSRemoteControllerBuilder();
  }

  public void connect() {

    try {
      // Create a new upgrade request, start the client, and connect
      // Note that start() must have been called, otherwise an exception
      // is thrown when connect is called.
      ClientUpgradeRequest request = new ClientUpgradeRequest();
      if (!webSocketClient.isStarted() || !webSocketClient.isStarting()) {
        this.webSocketClient.start();
      }
      Future<Session> connection = this.webSocketClient.connect(
              this.communicator, uri, request
      );
      log.debug(String.format("Connecting to: %s", uri));

      // Block on the connection succeeding
      connection.get(connectionTimeoutSeconds, TimeUnit.SECONDS);
    } catch (Throwable t) {
      // If the exception is caused by OBS being unavailable over the network
      // (or not installed or started), then call onError with helpful message
      if (
              t instanceof TimeoutException
                      || (t instanceof ExecutionException && t.getCause() != null && t
                      .getCause() instanceof ConnectException)
                      || (t instanceof ExecutionException && t.getCause() != null && t
                      .getCause() instanceof UnknownHostException)
      ) {
        this.controllerLifecycleListener.onError(
                new ReasonThrowable("Could not contact OBS on: " + this.uri
                        + ", verify OBS is running, the plugin is installed, and it can be reached over the network",
                        t.getCause() == null
                                ? t
                                : t.getCause()
                )
        );
      }
      // Otherwise, something unexpected has happened during connect
      else {
        this.controllerLifecycleListener.onError(
                new ReasonThrowable("An unexpected exception occurred during connect", t)
        );
      }
    }
  }

  public void disconnect() {
    // trigger the latch
    try {
      log.debug("Closing connection.");
      this.communicator.closeAndAwait(connectionTimeoutSeconds, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      this.controllerLifecycleListener.onError(
              new ReasonThrowable("Error during closing websocket connection", e)
      );
    }
  }

  public void stop() {
    // stop the client if it isn't already stopped or stopping
    if (!this.webSocketClient.isStopped() || !this.webSocketClient.isStopping()) {
      try {
        log.debug("Stopping client.");
        this.webSocketClient.stop();
      } catch (Exception e) {
        this.controllerLifecycleListener.onError(
                new ReasonThrowable("Error during stopping websocket client", e)
        );
      }
    }
  }

  public void await() throws InterruptedException {
    this.communicator.await();
  }

  /**
   * Send a Request
   *
   * @param request  R
   * @param callback Consumer&lt;RR&gt;
   * @param <R>      extends {@link Request}
   * @param <RR>     extends {@link RequestResponse}
   */
  public <R extends Request, RR extends RequestResponse> void sendRequest(R request,
          Consumer<RR> callback) {
    this.communicator.sendRequest(request, callback);
  }

  /**
   * Send a RequestBatch
   *
   * @param requestBatch {@link RequestBatch}
   * @param callback     Consumer&lt;{@link RequestBatchResponse}&gt;
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

  public void setStudioModeEnabled(boolean studioModeEnabled,
          Consumer<SetStudioModeEnabledResponse> callback) {
    this.sendRequest(
            SetStudioModeEnabledRequest.builder().studioModeEnabled(studioModeEnabled).build(),
            callback);
  }

  public void broadcastCustomEvent(JsonObject customEventData,
          Consumer<BroadcastCustomEventResponse> callback) {
    this.sendRequest(BroadcastCustomEventRequest.builder().eventData(customEventData).build(),
            callback);
  }

  public void callVendorRequest(String vendorName, String requestType, JsonObject requestData,
      Consumer<CallVendorRequestResponse> callback) {
    this.sendRequest(CallVendorRequestRequest.builder().vendorName(vendorName).requestType(requestType)
        .requestData(requestData).build(), callback);
  }


  public void sleep(Integer sleepMillis, Integer sleepFrames, Consumer<BroadcastCustomEventResponse> callback) {
    this.sendRequest(SleepRequest.builder().sleepMillis(sleepMillis).sleepFrames(sleepFrames).build(), callback);
  }

  public void getSceneList(Consumer<GetSceneListResponse> callback) {
    this.sendRequest(GetSceneListRequest.builder().build(), callback);
  }

  public void getGroupList(Consumer<GetGroupListResponse> callback) {
    this.sendRequest(GetGroupListRequest.builder().build(), callback);
  }

  public void getGetHotkeyList(Consumer<GetHotkeyListResponse> callback) {
    this.sendRequest(GetHotkeyListRequest.builder().build(), callback);
  }

  public void triggerHotkeyByName(String hotkeyName,
          Consumer<TriggerHotkeyByNameResponse> callback) {
    this.sendRequest(TriggerHotkeyByNameRequest.builder().hotkeyName(hotkeyName).build(), callback);
  }

  public void triggerHotkeyByKeySequence(String keyId,
          TriggerHotkeyByKeySequenceRequest.KeyModifiers keyModifiers,
          Consumer<TriggerHotkeyByKeySequenceResponse> callback) {
    this.sendRequest(
            TriggerHotkeyByKeySequenceRequest.builder().keyId(keyId).keyModifiers(keyModifiers).build(),
            callback);
  }

  public void getSceneCollectionList(Consumer<GetSceneCollectionListResponse> callback) {
    this.sendRequest(GetSceneCollectionListRequest.builder().build(), callback);
  }

  public void setCurrentSceneCollection(String sceneCollectionName,
          Consumer<SetCurrentSceneCollectionResponse> callback) {
    this.sendRequest(
            SetCurrentSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(),
            callback);
  }

  public void createSceneCollection(String sceneCollectionName,
          Consumer<CreateSceneCollectionResponse> callback) {
    this.sendRequest(
            CreateSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(),
            callback);
  }

  public void removeSceneCollection(String sceneCollectionName,
          Consumer<RemoveSceneCollectionResponse> callback) {
    this.sendRequest(
            RemoveSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(),
            callback);
  }

  public void getCurrentProgramScene(Consumer<GetCurrentProgramSceneResponse> callback) {
    this.sendRequest(GetCurrentProgramSceneRequest.builder().build(), callback);
  }

  public void setCurrentProgramScene(String sceneName,
          Consumer<SetCurrentProgramSceneResponse> callback) {
    this.sendRequest(SetCurrentProgramSceneRequest.builder().sceneName(sceneName).build(),
            callback);
  }

  public void getCurrentPreviewScene(Consumer<GetCurrentPreviewSceneResponse> callback) {
    this.sendRequest(GetCurrentPreviewSceneRequest.builder().build(), callback);
  }

  public void setCurrentPreviewScene(String sceneName,
          Consumer<SetCurrentPreviewSceneResponse> callback) {
    this.sendRequest(SetCurrentPreviewSceneRequest.builder().sceneName(sceneName).build(),
            callback);
  }

  public void createSceneRequest(String sceneName, Consumer<CreateSceneResponse> callback) {
    this.sendRequest(CreateSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  public void getProfileList(Consumer<GetProfileListResponse> callback) {
    this.sendRequest(GetProfileListRequest.builder().build(), callback);
  }

  public void getProfileParameter(String parameterCategory, String parameterName,
          Consumer<GetProfileParameterResponse> callback) {
    this.sendRequest(GetProfileParameterRequest.builder().parameterCategory(parameterCategory)
                                               .parameterName(parameterName).build(), callback);
  }

  public void setProfileParameter(String parameterCategory, String parameterName,
          String parameterValue, Consumer<SetProfileParameterResponse> callback) {
    this.sendRequest(SetProfileParameterRequest.builder().parameterCategory(parameterCategory)
                                               .parameterName(parameterName).parameterValue(parameterValue).build(), callback);
  }

  public void removeScene(String sceneName, Consumer<RemoveSceneResponse> callback) {
    this.sendRequest(RemoveSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  public void setSceneName(String sceneName, String newSceneName,
          Consumer<SetSceneNameResponse> callback) {
    this.sendRequest(
            SetSceneNameRequest.builder().sceneName(sceneName).newSceneName(newSceneName).build(),
            callback);
  }

  public void getSourceActive(String sourceName,
          Consumer<GetSourceActiveResponse> callback) {
    this.sendRequest(GetSourceActiveRequest.builder().sourceName(sourceName).build(), callback);
  }

  public void getInputList(String inputKind, Consumer<GetInputListResponse> callback) {
    this.sendRequest(GetInputListRequest.builder().inputKind(inputKind).build(), callback);
  }

  public void getInputDefaultSettings(String inputKind,
          Consumer<GetInputDefaultSettingsResponse> callback) {
    this.sendRequest(GetInputDefaultSettingsRequest.builder().inputKind(inputKind).build(),
            callback);
  }

  public void getInputKindList(Boolean unversioned,
          Consumer<GetInputListResponse> callback) {
    this.sendRequest(GetInputKindListRequest.builder().unversioned(unversioned).build(), callback);
  }

  public void getInputSettings(String inputName,
          Consumer<GetInputSettingsResponse> callback) {
    this.sendRequest(GetInputSettingsRequest.builder().inputName(inputName).build(), callback);
  }

  public void setInputSettings(String inputName, JsonObject inputSettings, Boolean overlay,
          Consumer<SetInputSettingsResponse> callback) {
    this.sendRequest(
            SetInputSettingsRequest.builder().inputName(inputName).inputSettings(inputSettings)
                                   .overlay(overlay).build(), callback);
  }

  public void getInputMute(String inputName, Consumer<GetInputMuteResponse> callback) {
    this.sendRequest(GetInputMuteRequest.builder().inputName(inputName).build(), callback);
  }

  public void setInputMute(String inputName, boolean inputMuted,
          Consumer<SetInputMuteResponse> callback) {
    this.sendRequest(
            SetInputMuteRequest.builder().inputName(inputName).inputMuted(inputMuted).build(),
            callback);
  }

  public void toggleInputMute(String inputName, Consumer<ToggleInputMuteResponse> callback) {
    this.sendRequest(ToggleInputMuteRequest.builder().inputName(inputName).build(), callback);
  }

  public void getInputVolume(String inputName, Consumer<GetInputVolumeResponse> callback) {
    this.sendRequest(GetInputVolumeRequest.builder().inputName(inputName).build(), callback);
  }

  public void getSourceScreenshotR(String sourceName, String imageFormat, Integer imageWidth,
          Integer imageHeight, Integer imageCompressionQuality,
          Consumer<GetSourceScreenshotResponse> callback) {
    this.sendRequest(
            GetSourceScreenshotRequest.builder().sourceName(sourceName).imageFormat(imageFormat)
                                      .imageWidth(imageWidth).imageHeight(imageHeight)
                                      .imageCompressionQuality(imageCompressionQuality).build(), callback);
  }

  public void saveSourceScreenshot(String sourceName, String imageFilePath,
          String imageFormat, Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality,
          Consumer<SaveSourceScreenshotResponse> callback) {
    this.sendRequest(
            SaveSourceScreenshotRequest.builder().sourceName(sourceName).imageFilePath(imageFilePath)
                                       .imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight)
                                       .imageCompressionQuality(imageCompressionQuality).build(), callback);
  }

  public void getVideoSettings(Consumer<GetVideoSettingsResponse> callback) {
    this.sendRequest(GetVideoSettingsRequest.builder().build(), callback);
  }

  public void getSceneTransitionOverride(String sceneName,
          Consumer<GetSceneSceneTransitionOverrideResponse> callback) {
    this.sendRequest(GetSceneSceneTransitionOverrideRequest.builder().sceneName(sceneName).build(),
        callback);
  }

  public void setSceneTransitionOverride(String sceneName, String transitionName,
      Integer transitionDuration, Consumer<SetSceneTransitionOverrideResponse> callback) {
    this.sendRequest(SetSceneSceneTransitionOverrideRequest.builder().sceneName(sceneName)
        .transitionName(transitionName).transitionDuration(transitionDuration).build(), callback);
  }

  public void getSpecialInputNames(Consumer<GetSpecialInputsResponse> callback) {
    this.sendRequest(GetSpecialInputsRequest.builder().build(), callback);
  }

  public void setInputName(String inputName, String newInputName,
      Consumer<SetInputNameResponse> callback) {
    this.sendRequest(
        SetInputNameRequest.builder().inputName(inputName).newInputName(newInputName).build(),
        callback);
  }

  public void setInputVolume(String inputName, Float inputVolumeDb, Float inputVolumeMul,
          Consumer<SetInputVolumeResponse> callback) {
    this.sendRequest(
            SetInputVolumeRequest.builder().inputName(inputName).inputVolumeDb(inputVolumeDb)
                                 .inputVolumeMul(inputVolumeMul).build(), callback);
  }

  public void createInput(String inputName, String inputKind, String sceneName,
          JsonObject inputSettings, Boolean sceneItemEnabled, Consumer<CreateInputResponse> callback) {
    this.sendRequest(
            CreateInputRequest.builder().inputName(inputName).inputKind(inputKind).sceneName(sceneName)
                              .inputSettings(inputSettings).sceneItemEnabled(sceneItemEnabled).build(), callback);
  }

  public void getInputAudioTracks(String inputName, Consumer<GetInputAudioTracksResponse> callback) {
    this.sendRequest(GetInputAudioTracksRequest.builder().inputName(inputName).build(), callback);
  }

  public void getInputMonitorType(String inputName,
          Consumer<GetInputAudioMonitorTypeResponse> callback) {
    this.sendRequest(GetInputAudioMonitorTypeRequest.builder().inputName(inputName).build(), callback);
  }

  public void setInputMonitorType(String inputName, Input.MonitorType monitorType,
          Consumer<SetInputAudioMonitorTypeResponse> callback) {
    this.sendRequest(
            SetInputAudioMonitorTypeRequest.builder().inputName(inputName).monitorType(monitorType).build(),
            callback);
  }

  public void getCurrentTransition(Consumer<GetCurrentTransitionResponse> callback) {
    this.sendRequest(GetCurrentTransitionRequest.builder().build(), callback);
  }

  public void getTransitionList(Consumer<GetTransitionListResponse> callback) {
    this.sendRequest(GetTransitionListRequest.builder().build(), callback);
  }

  public void getTransitionSettings(String transitionName,
          Consumer<GetTransitionSettingsResponse> callback) {
    this.sendRequest(GetTransitionSettingsRequest.builder().transitionName(transitionName).build(),
            callback);
  }

  public void setCurrentTransitionDuration(Integer transitionDuration,
          Consumer<SetCurrentTransitionDurationResponse> callback) {
    this.sendRequest(
            SetCurrentTransitionDurationRequest.builder().transitionDuration(transitionDuration)
                                               .build(), callback);
  }

  public void setCurrentTransition(String transitionName,
          Consumer<SetCurrentTransitionResponse> callback) {
    this.sendRequest(SetCurrentTransitionRequest.builder().transitionName(transitionName).build(),
            callback);
  }

  public void setTransitionSettings(String transitionName, JsonObject transitionSettings,
          Consumer<SetTransitionSettingsResponse> callback) {
    this.sendRequest(SetTransitionSettingsRequest.builder().transitionName(transitionName)
                                                 .transitionSettings(transitionSettings).build(), callback);
  }

  public void releaseTbar(Consumer<ReleaseTbarResponse> callback) {
    this.sendRequest(ReleaseTbarRequest.builder().build(), callback);
  }

  public void setTbarPosition(Double position, Boolean release,
          Consumer<SetTbarPositionResponse> callback) {
    this.sendRequest(SetTbarPositionRequest.builder().position(position).release(release).build(),
            callback);
  }

  public void triggerStudioModeTransition(
          Consumer<TriggerStudioModeTransitionResponse> callback) {
    this.sendRequest(TriggerStudioModeTransitionRequest.builder().build(), callback);
  }

  public void getSourceFilterList(String sourceName,
          Consumer<GetSourceFilterListResponse> callback) {
    this.sendRequest(GetSourceFilterListRequest.builder().sourceName(sourceName).build(), callback);
  }

  public void getSourceFilter(String sourceName, String filterName,
          Consumer<GetSourceFilterResponse> callback) {
    this.sendRequest(
            GetSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(),
            callback);
  }

  public void setSourceFilterIndex(String sourceName, String filterName, Integer filterIndex,
          Consumer<SetSourceFilterIndexResponse> callback) {
    this.sendRequest(
            SetSourceFilterIndexRequest.builder().sourceName(sourceName).filterName(filterName)
                                       .filterIndex(filterIndex).build(), callback);
  }

  public void createSourceFilter(String sourceName, String filterName, Integer filterIndex,
          String filterKind, JsonObject filterSettings, Consumer<CreateSourceFilterResponse> callback) {
    this.sendRequest(
            CreateSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName)
                                     .filterKind(filterKind).filterSettings(filterSettings).filterIndex(filterIndex).build(),
            callback);
  }

  public void removeSourceFilter(String sourceName, String filterName,
          Consumer<RemoveSourceFilterResponse> callback) {
    this.sendRequest(
            RemoveSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(),
            callback);
  }

  public void setSourceFilterEnabled(String sourceName, String filterName,
          Boolean filterEnabled, Consumer<SetSourceFilterEnabledResponse> callback) {
    this.sendRequest(
            SetSourceFilterEnabledRequest.builder().sourceName(sourceName).filterName(filterName)
                                         .filterEnabled(filterEnabled).build(), callback);
  }

  public void setSourceFilterSettings(String sourceName, String filterName,
          JsonObject filterSettings, Consumer<SetSourceFilterEnabledResponse> callback) {
    this.sendRequest(
            SetSourceFilterSettingsRequest.builder().sourceName(sourceName).filterName(filterName)
                                          .filterSettings(filterSettings).build(), callback);
  }

  public void getSceneItemList(String sceneName,
          Consumer<GetSceneItemListResponse> callback) {
    this.sendRequest(GetSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
  }

  public void getGroupSceneItemList(String sceneName,
      Consumer<GetGroupSceneItemListResponse> callback) {
    this.sendRequest(GetGroupSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
  }

  public void getSceneItemId(String sceneName, String sourceName, Integer searchOffset,
      Consumer<GetSceneItemIdResponse> callback) {
    this.sendRequest(GetSceneItemIdRequest.builder()
        .sceneName(sceneName).sourceName(sourceName).searchOffset(searchOffset).build(), callback);
  }

  // TODO: Find actual value of sceneItemTransform
  public void getSceneItemTransform(String sceneName, Integer sceneItemId, Object sceneItemTransform,
      Consumer<SetSceneItemTransformResponse> callback) {
    this.sendRequest(
        SetSceneItemTransformRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId)
            .sceneItemTransform(sceneItemTransform).build(), callback);
  }

  public void setSceneItemTransform(String sceneName, Integer sceneItemId,
      Consumer<GetSceneItemTransformResponse> callback) {
    this.sendRequest(GetSceneItemTransformRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  public void getSceneItemEnabled(String sceneName, Integer sceneItemId,
          Consumer<GetSceneItemEnabledResponse> callback) {
    this.sendRequest(
            GetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(),
            callback);
  }

  public void setSceneItemEnabled(String sceneName, Integer sceneItemId,
          Boolean sceneItemEnabled, Consumer<SetSceneItemEnabledResponse> callback) {
    this.sendRequest(
            SetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId)
                                      .sceneItemEnabled(sceneItemEnabled).build(), callback);
  }

  public void getSceneItemLocked(String sceneName, Integer sceneItemId,
          Consumer<GetSceneItemLockedResponse> callback) {
    this.sendRequest(
            GetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(),
            callback);
  }

  public void setSceneItemLocked(String sceneName, Integer sceneItemId,
          Boolean sceneItemLocked, Consumer<SetSceneItemLockedResponse> callback) {
    this.sendRequest(
            SetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId)
                                     .sceneItemLocked(sceneItemLocked).build(), callback);
  }

  public void getSceneItemIndex(String sceneName, Integer sceneItemId,
      Consumer<GetSceneItemIndexResponse> callback) {
    this.sendRequest(GetSceneItemIndexRequest.builder().sceneName(sceneName)
        .sceneItemId(sceneItemId).build(), callback);
  }

  public void setSceneItemIndex(String sceneName, Integer sceneItemId,
          Integer sceneItemIndex, Consumer<SetSceneItemIndexResponse> callback) {
    this.sendRequest(
            SetSceneItemIndexRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId)
                                    .sceneItemIndex(sceneItemIndex).build(), callback);
  }

  public void GetSceneItemBlendMode(String sceneName, Integer sceneItemId,
      Consumer<GetSceneItemBlendModeResponse> callback) {
    this.sendRequest(GetSceneItemBlendModeRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  public void SetSceneItemBlendMode(String sceneName, Integer sceneItemId, SceneItemBlendMode sceneItemBlendMode,
      Consumer<SetSceneItemBlendModeResponse> callback) {
    this.sendRequest(SetSceneItemBlendModeRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemBlendMode(sceneItemBlendMode).build(), callback);
  }

  public void createSceneItem(String sceneName, String sourceName, Boolean sceneItemEnabled,
          Consumer<CreateSceneItemResponse> callback) {
    this.sendRequest(
            CreateSceneItemRequest.builder().sceneName(sceneName).sourceName(sourceName).sceneItemEnabled(sceneItemEnabled).build(),
            callback);
  }

  public void removeSceneItem(String sceneName, Integer sceneItemId,
          Consumer<RemoveSceneItemResponse> callback) {
    this.sendRequest(
            RemoveSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(),
            callback);
  }

  public void duplicateSceneItem(String sceneName, Integer sceneItemId, String destinationSceneName,
          Consumer<DuplicateSceneItemResponse> callback) {
    this.sendRequest(
            DuplicateSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId)
                                     .destinationSceneName(destinationSceneName).build(), callback);
  }

  public void getLastReplayBufferReplay(
          Consumer<GetLastReplayBufferReplayResponse> callback) {
    this.sendRequest(GetLastReplayBufferReplayRequest.builder().build(), callback);
  }

  public void getOutputList(Consumer<GetOutputListResponse> callback) {
    this.sendRequest(GetOutputListRequest.builder().build(), callback);
  }

  public void getReplayBufferStatus(Consumer<GetReplayBufferStatusResponse> callback) {
    this.sendRequest(GetReplayBufferStatusRequest.builder().build(), callback);
  }

  public void saveReplayBuffer(Consumer<SaveReplayBufferResponse> callback) {
    this.sendRequest(SaveReplayBufferRequest.builder().build(), callback);
  }

  public void startOutput(String outputName, Consumer<StartOutputResponse> callback) {
    this.sendRequest(StartOutputRequest.builder().outputName(outputName).build(), callback);
  }

  public void stopOutput(String outputName, Consumer<StopOutputResponse> callback) {
    this.sendRequest(StopOutputRequest.builder().outputName(outputName).build(), callback);
  }

  public void stopReplayBuffer(Consumer<StopReplayBufferResponse> callback) {
    this.sendRequest(StopReplayBufferRequest.builder().build(), callback);
  }

  public void toggleOutput(String outputName, Consumer<ToggleOutputResponse> callback) {
    this.sendRequest(ToggleOutputRequest.builder().outputName(outputName).build(), callback);
  }

  public void toggleReplayBuffer(Consumer<ToggleReplayBufferResponse> callback) {
    this.sendRequest(ToggleReplayBufferRequest.builder().build(), callback);
  }

  public void getRecordDirectory(Consumer<GetRecordDirectoryResponse> callback) {
    this.sendRequest(GetRecordDirectoryRequest.builder().build(), callback);
  }

  public void getRecordFilenameFormatting(
          Consumer<GetRecordFilenameFormattingResponse> callback) {
    this.sendRequest(GetRecordFilenameFormattingRequest.builder().build(), callback);
  }

  public void getRecordStatus(Consumer<GetRecordStatusResponse> callback) {
    this.sendRequest(GetRecordStatusRequest.builder().build(), callback);
  }

  public void pauseRecord(Consumer<PauseRecordResponse> callback) {
    this.sendRequest(PauseRecordRequest.builder().build(), callback);
  }

  public void resumeRecord(Consumer<ResumeRecordResponse> callback) {
    this.sendRequest(ResumeRecordRequest.builder().build(), callback);
  }

  public void setRecordDirectory(String recordDirectory, Boolean createIfNotExist,
          Consumer<SetRecordDirectoryResponse> callback) {
    this.sendRequest(SetRecordDirectoryRequest.builder().recordDirectory(recordDirectory)
                                              .createIfNotExist(createIfNotExist).build(), callback);
  }

  public void setRecordFilenameFormatting(String filenameFormatting,
          Consumer<SetRecordFilenameFormattingResponse> callback) {
    this.sendRequest(
            SetRecordFilenameFormattingRequest.builder().filenameFormatting(filenameFormatting).build(),
            callback);
  }

  public void startRecord(Boolean waitForResult, Consumer<StartRecordResponse> callback) {
    this.sendRequest(StartRecordRequest.builder().waitForResult(waitForResult).build(), callback);
  }

  public void stopRecord(Boolean waitForResult, Consumer<StopRecordResponse> callback) {
    this.sendRequest(StopRecordRequest.builder().waitForResult(waitForResult).build(), callback);
  }

  public void toggleRecordPause(Consumer<ToggleRecordPauseResponse> callback) {
    this.sendRequest(ToggleRecordPauseRequest.builder().build(), callback);
  }

  public void toggleRecord(Consumer<ToggleRecordResponse> callback) {
    this.sendRequest(ToggleRecordRequest.builder().build(), callback);
  }

  public void removeInput(String inputName, Consumer<RemoveInputResponse> callback) {
    this.sendRequest(RemoveInputRequest.builder().inputName(inputName).build(), callback);
  }

  public void getStreamStatus(Consumer<GetStreamStatusResponse> callback) {
    this.sendRequest(GetStreamStatusRequest.builder().build(), callback);
  }

  public void getStreamServiceSettings(Consumer<GetStreamServiceSettingsResponse> callback) {
    this.sendRequest(GetStreamServiceSettingsRequest.builder().build(), callback);
  }

  public void sendStreamCaption(String captionText,
          Consumer<SendStreamCaptionResponse> callback) {
    this.sendRequest(SendStreamCaptionRequest.builder().captionText(captionText).build(), callback);
  }

  public void setStreamServiceSettings(String streamServiceType, JsonObject serviceSettings,
          Consumer<SetStreamServiceSettingsResponse> callback) {
    this.sendRequest(
            SetStreamServiceSettingsRequest.builder().streamServiceType(streamServiceType).serviceSettings(serviceSettings).build(),
            callback);
  }

  public void startStream(Consumer<StartStreamResponse> callback) {
    this.sendRequest(StartStreamRequest.builder().build(), callback);
  }

  public void stopStream(Consumer<StopStreamResponse> callback) {
    this.sendRequest(StopStreamRequest.builder().build(), callback);
  }

  public void toggleStream(Consumer<ToggleStreamResponse> callback) {
    this.sendRequest(ToggleStreamRequest.builder().build(), callback);
  }

  public void getMediaInputStatus(String inputName,
          Consumer<GetMediaInputStatusResponse> callback) {
    this.sendRequest(GetMediaInputStatusRequest.builder().inputName(inputName).build(), callback);
  }

  public void nextMediaInputPlaylistItem(String inputName,
          Consumer<NextMediaInputPlaylistItemResponse> callback) {
    this.sendRequest(NextMediaInputPlaylistItemRequest.builder().inputName(inputName).build(),
            callback);
  }

  public void offsetMediaInputTimecode(String inputName, Long timestampOffset,
          Consumer<OffsetMediaInputTimecodeResponse> callback) {
    this.sendRequest(OffsetMediaInputTimecodeRequest.builder().inputName(inputName)
                                                    .timestampOffset(timestampOffset).build(), callback);
  }

  public void previousMediaInputPlaylistItem(String inputName,
          Consumer<PreviousMediaInputPlaylistItemResponse> callback) {
    this.sendRequest(PreviousMediaInputPlaylistItemRequest.builder().inputName(inputName).build(),
            callback);
  }

  public void restartMediaInput(String inputName,
          Consumer<RestartMediaInputResponse> callback) {
    this.sendRequest(RestartMediaInputRequest.builder().inputName(inputName).build(), callback);
  }

  public void setMediaInputPauseState(String inputName, Boolean pause,
          Consumer<SetMediaInputPauseStateResponse> callback) {
    this.sendRequest(
            SetMediaInputPauseStateRequest.builder().inputName(inputName).pause(pause).build(),
            callback);
  }

  public void setMediaInputTimecode(String inputName, Long mediaTimestamp,
          Consumer<SetMediaInputTimecodeResponse> callback) {
    this.sendRequest(
            SetMediaInputTimecodeRequest.builder().inputName(inputName).mediaTimestamp(mediaTimestamp)
                                        .build(), callback);
  }

  public void stopMediaInput(String inputName, Consumer<StopMediaInputResponse> callback) {
    this.sendRequest(StopMediaInputRequest.builder().inputName(inputName).build(), callback);
  }

  public void getStats(Consumer<GetStatsResponse> callback) {
    this.sendRequest(GetStatsRequest.builder().build(), callback);
  }

  public void setCurrentProfile(String profileName, Consumer<SetCurrentProfileResponse> callback) {
    this.sendRequest(SetCurrentProfileRequest.builder().profileName(profileName).build(), callback);
  }

  public void createProfile(String profileName, Consumer<CreateProfileResponse> callback) {
    this.sendRequest(CreateProfileRequest.builder().profileName(profileName).build(), callback);
  }

  public void removeProfile(String profileName, Consumer<RemoveProfileResponse> callback) {
    this.sendRequest(RemoveProfileRequest.builder().profileName(profileName).build(), callback);
  }

  public void setVideoSettings(Integer baseWidth,
          Integer baseHeight,
          Integer outputWidth,
          Integer outputHeight,
          Integer fpsNumerator,
          Integer fpsDenominator,
          Consumer<RemoveProfileResponse> callback) {
    this.sendRequest(SetVideoSettingsRequest.builder()
                                            .baseWidth(baseWidth)
                                            .baseHeight(baseHeight)
                                            .outputWidth(outputWidth)
                                            .outputHeight(outputHeight)
                                            .fpsNumerator(fpsNumerator)
                                            .fpsDenominator(fpsDenominator)
                                            .build(), callback);
  }

  public void getInputAudioSyncOffset(String inputName, Consumer<GetInputAudioSyncOffsetResponse> callback) {
    this.sendRequest(GetInputAudioSyncOffsetRequest.builder().inputName(inputName).build(), callback);
  }

  public void setInputAudioSyncOffset(String inputName, Long inputAudioSyncOffset, Consumer<SetInputAudioSyncOffsetResponse> callback) {
    this.sendRequest(SetInputAudioSyncOffsetRequest.builder().inputName(inputName).inputAudioSyncOffset(inputAudioSyncOffset).build(), callback);
  }

  public void getInputPropertiesListPropertyItems(String inputName, String propertyName, Consumer<GetInputPropertiesListPropertyItemsResponse> callback) {
    this.sendRequest(GetInputPropertiesListPropertyItemsRequest.builder().inputName(inputName).propertyName(propertyName).build(), callback);
  }

  public void pressInputPropertiesButton(String inputName, String propertyName, Consumer<PressInputPropertiesButtonResponse> callback) {
    this.sendRequest(
            PressInputPropertiesButtonRequest.builder().inputName(inputName).propertyName(propertyName).build(), callback);
  }

  public void StartReplayBuffer(Consumer<StartReplayBufferResponse> callback) {
    this.sendRequest(
            StartReplayBufferRequest.builder().build(), callback);
  }
}
