// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.config.CreateProfileRequest;
import io.obswebsocket.community.client.message.request.config.CreateSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.GetPersistentDataRequest;
import io.obswebsocket.community.client.message.request.config.GetProfileListRequest;
import io.obswebsocket.community.client.message.request.config.GetProfileParameterRequest;
import io.obswebsocket.community.client.message.request.config.GetRecordDirectoryRequest;
import io.obswebsocket.community.client.message.request.config.GetSceneCollectionListRequest;
import io.obswebsocket.community.client.message.request.config.GetStreamServiceSettingsRequest;
import io.obswebsocket.community.client.message.request.config.GetVideoSettingsRequest;
import io.obswebsocket.community.client.message.request.config.RemoveProfileRequest;
import io.obswebsocket.community.client.message.request.config.SetCurrentProfileRequest;
import io.obswebsocket.community.client.message.request.config.SetCurrentSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.SetPersistentDataRequest;
import io.obswebsocket.community.client.message.request.config.SetProfileParameterRequest;
import io.obswebsocket.community.client.message.request.config.SetStreamServiceSettingsRequest;
import io.obswebsocket.community.client.message.request.config.SetVideoSettingsRequest;
import io.obswebsocket.community.client.message.request.filters.CreateSourceFilterRequest;
import io.obswebsocket.community.client.message.request.filters.GetSourceFilterDefaultSettingsRequest;
import io.obswebsocket.community.client.message.request.filters.GetSourceFilterListRequest;
import io.obswebsocket.community.client.message.request.filters.GetSourceFilterRequest;
import io.obswebsocket.community.client.message.request.filters.RemoveSourceFilterRequest;
import io.obswebsocket.community.client.message.request.filters.SetSourceFilterEnabledRequest;
import io.obswebsocket.community.client.message.request.filters.SetSourceFilterIndexRequest;
import io.obswebsocket.community.client.message.request.filters.SetSourceFilterNameRequest;
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
import io.obswebsocket.community.client.message.request.inputs.GetInputAudioBalanceRequest;
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
import io.obswebsocket.community.client.message.request.inputs.SetInputAudioBalanceRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputAudioMonitorTypeRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputAudioSyncOffsetRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputAudioTracksRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputMuteRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputNameRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputSettingsRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputVolumeRequest;
import io.obswebsocket.community.client.message.request.inputs.ToggleInputMuteRequest;
import io.obswebsocket.community.client.message.request.mediainputs.GetMediaInputStatusRequest;
import io.obswebsocket.community.client.message.request.mediainputs.OffsetMediaInputCursorRequest;
import io.obswebsocket.community.client.message.request.mediainputs.SetMediaInputCursorRequest;
import io.obswebsocket.community.client.message.request.mediainputs.TriggerMediaInputActionRequest;
import io.obswebsocket.community.client.message.request.outputs.GetLastReplayBufferReplayRequest;
import io.obswebsocket.community.client.message.request.outputs.GetOutputListRequest;
import io.obswebsocket.community.client.message.request.outputs.GetOutputSettingsRequest;
import io.obswebsocket.community.client.message.request.outputs.GetOutputStatusRequest;
import io.obswebsocket.community.client.message.request.outputs.GetReplayBufferStatusRequest;
import io.obswebsocket.community.client.message.request.outputs.GetVirtualCamStatusRequest;
import io.obswebsocket.community.client.message.request.outputs.SaveReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.SetOutputSettingsRequest;
import io.obswebsocket.community.client.message.request.outputs.StartOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.StartReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.StartVirtualCamRequest;
import io.obswebsocket.community.client.message.request.outputs.StopOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.StopReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.StopVirtualCamRequest;
import io.obswebsocket.community.client.message.request.outputs.ToggleOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.ToggleReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.ToggleVirtualCamRequest;
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
import io.obswebsocket.community.client.message.request.transitions.GetCurrentSceneTransitionCursorRequest;
import io.obswebsocket.community.client.message.request.transitions.GetCurrentSceneTransitionRequest;
import io.obswebsocket.community.client.message.request.transitions.GetSceneTransitionListRequest;
import io.obswebsocket.community.client.message.request.transitions.GetTransitionKindListRequest;
import io.obswebsocket.community.client.message.request.transitions.SetCurrentSceneTransitionDurationRequest;
import io.obswebsocket.community.client.message.request.transitions.SetCurrentSceneTransitionRequest;
import io.obswebsocket.community.client.message.request.transitions.SetCurrentSceneTransitionSettingsRequest;
import io.obswebsocket.community.client.message.request.transitions.SetTBarPositionRequest;
import io.obswebsocket.community.client.message.request.transitions.TriggerStudioModeTransitionRequest;
import io.obswebsocket.community.client.message.request.ui.GetMonitorListRequest;
import io.obswebsocket.community.client.message.request.ui.GetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.request.ui.OpenInputFiltersDialogRequest;
import io.obswebsocket.community.client.message.request.ui.OpenInputInteractDialogRequest;
import io.obswebsocket.community.client.message.request.ui.OpenInputPropertiesDialogRequest;
import io.obswebsocket.community.client.message.request.ui.OpenSourceProjectorRequest;
import io.obswebsocket.community.client.message.request.ui.OpenVideoMixProjectorRequest;
import io.obswebsocket.community.client.message.request.ui.SetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.config.CreateProfileResponse;
import io.obswebsocket.community.client.message.response.config.CreateSceneCollectionResponse;
import io.obswebsocket.community.client.message.response.config.GetPersistentDataResponse;
import io.obswebsocket.community.client.message.response.config.GetProfileListResponse;
import io.obswebsocket.community.client.message.response.config.GetProfileParameterResponse;
import io.obswebsocket.community.client.message.response.config.GetRecordDirectoryResponse;
import io.obswebsocket.community.client.message.response.config.GetSceneCollectionListResponse;
import io.obswebsocket.community.client.message.response.config.GetStreamServiceSettingsResponse;
import io.obswebsocket.community.client.message.response.config.GetVideoSettingsResponse;
import io.obswebsocket.community.client.message.response.config.RemoveProfileResponse;
import io.obswebsocket.community.client.message.response.config.SetCurrentProfileResponse;
import io.obswebsocket.community.client.message.response.config.SetCurrentSceneCollectionResponse;
import io.obswebsocket.community.client.message.response.config.SetPersistentDataResponse;
import io.obswebsocket.community.client.message.response.config.SetProfileParameterResponse;
import io.obswebsocket.community.client.message.response.config.SetStreamServiceSettingsResponse;
import io.obswebsocket.community.client.message.response.config.SetVideoSettingsResponse;
import io.obswebsocket.community.client.message.response.filters.CreateSourceFilterResponse;
import io.obswebsocket.community.client.message.response.filters.GetSourceFilterDefaultSettingsResponse;
import io.obswebsocket.community.client.message.response.filters.GetSourceFilterListResponse;
import io.obswebsocket.community.client.message.response.filters.GetSourceFilterResponse;
import io.obswebsocket.community.client.message.response.filters.RemoveSourceFilterResponse;
import io.obswebsocket.community.client.message.response.filters.SetSourceFilterEnabledResponse;
import io.obswebsocket.community.client.message.response.filters.SetSourceFilterIndexResponse;
import io.obswebsocket.community.client.message.response.filters.SetSourceFilterNameResponse;
import io.obswebsocket.community.client.message.response.filters.SetSourceFilterSettingsResponse;
import io.obswebsocket.community.client.message.response.general.BroadcastCustomEventResponse;
import io.obswebsocket.community.client.message.response.general.CallVendorRequestResponse;
import io.obswebsocket.community.client.message.response.general.GetHotkeyListResponse;
import io.obswebsocket.community.client.message.response.general.GetStatsResponse;
import io.obswebsocket.community.client.message.response.general.GetVersionResponse;
import io.obswebsocket.community.client.message.response.general.SleepResponse;
import io.obswebsocket.community.client.message.response.general.TriggerHotkeyByKeySequenceResponse;
import io.obswebsocket.community.client.message.response.general.TriggerHotkeyByNameResponse;
import io.obswebsocket.community.client.message.response.inputs.CreateInputResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputAudioBalanceResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputAudioMonitorTypeResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputAudioSyncOffsetResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputAudioTracksResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputDefaultSettingsResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputKindListResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputListResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputMuteResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputPropertiesListPropertyItemsResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputSettingsResponse;
import io.obswebsocket.community.client.message.response.inputs.GetInputVolumeResponse;
import io.obswebsocket.community.client.message.response.inputs.GetSpecialInputsResponse;
import io.obswebsocket.community.client.message.response.inputs.PressInputPropertiesButtonResponse;
import io.obswebsocket.community.client.message.response.inputs.RemoveInputResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputAudioBalanceResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputAudioMonitorTypeResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputAudioSyncOffsetResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputAudioTracksResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputMuteResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputNameResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputSettingsResponse;
import io.obswebsocket.community.client.message.response.inputs.SetInputVolumeResponse;
import io.obswebsocket.community.client.message.response.inputs.ToggleInputMuteResponse;
import io.obswebsocket.community.client.message.response.mediainputs.GetMediaInputStatusResponse;
import io.obswebsocket.community.client.message.response.mediainputs.OffsetMediaInputCursorResponse;
import io.obswebsocket.community.client.message.response.mediainputs.SetMediaInputCursorResponse;
import io.obswebsocket.community.client.message.response.mediainputs.TriggerMediaInputActionResponse;
import io.obswebsocket.community.client.message.response.outputs.GetLastReplayBufferReplayResponse;
import io.obswebsocket.community.client.message.response.outputs.GetOutputListResponse;
import io.obswebsocket.community.client.message.response.outputs.GetOutputSettingsResponse;
import io.obswebsocket.community.client.message.response.outputs.GetOutputStatusResponse;
import io.obswebsocket.community.client.message.response.outputs.GetReplayBufferStatusResponse;
import io.obswebsocket.community.client.message.response.outputs.GetVirtualCamStatusResponse;
import io.obswebsocket.community.client.message.response.outputs.SaveReplayBufferResponse;
import io.obswebsocket.community.client.message.response.outputs.SetOutputSettingsResponse;
import io.obswebsocket.community.client.message.response.outputs.StartOutputResponse;
import io.obswebsocket.community.client.message.response.outputs.StartReplayBufferResponse;
import io.obswebsocket.community.client.message.response.outputs.StartVirtualCamResponse;
import io.obswebsocket.community.client.message.response.outputs.StopOutputResponse;
import io.obswebsocket.community.client.message.response.outputs.StopReplayBufferResponse;
import io.obswebsocket.community.client.message.response.outputs.StopVirtualCamResponse;
import io.obswebsocket.community.client.message.response.outputs.ToggleOutputResponse;
import io.obswebsocket.community.client.message.response.outputs.ToggleReplayBufferResponse;
import io.obswebsocket.community.client.message.response.outputs.ToggleVirtualCamResponse;
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
import io.obswebsocket.community.client.message.response.scenes.SetSceneSceneTransitionOverrideResponse;
import io.obswebsocket.community.client.message.response.sources.GetSourceActiveResponse;
import io.obswebsocket.community.client.message.response.sources.GetSourceScreenshotResponse;
import io.obswebsocket.community.client.message.response.sources.SaveSourceScreenshotResponse;
import io.obswebsocket.community.client.message.response.stream.GetStreamStatusResponse;
import io.obswebsocket.community.client.message.response.stream.SendStreamCaptionResponse;
import io.obswebsocket.community.client.message.response.stream.StartStreamResponse;
import io.obswebsocket.community.client.message.response.stream.StopStreamResponse;
import io.obswebsocket.community.client.message.response.stream.ToggleStreamResponse;
import io.obswebsocket.community.client.message.response.transitions.GetCurrentSceneTransitionCursorResponse;
import io.obswebsocket.community.client.message.response.transitions.GetCurrentSceneTransitionResponse;
import io.obswebsocket.community.client.message.response.transitions.GetSceneTransitionListResponse;
import io.obswebsocket.community.client.message.response.transitions.GetTransitionKindListResponse;
import io.obswebsocket.community.client.message.response.transitions.SetCurrentSceneTransitionDurationResponse;
import io.obswebsocket.community.client.message.response.transitions.SetCurrentSceneTransitionResponse;
import io.obswebsocket.community.client.message.response.transitions.SetCurrentSceneTransitionSettingsResponse;
import io.obswebsocket.community.client.message.response.transitions.SetTBarPositionResponse;
import io.obswebsocket.community.client.message.response.transitions.TriggerStudioModeTransitionResponse;
import io.obswebsocket.community.client.message.response.ui.GetMonitorListResponse;
import io.obswebsocket.community.client.message.response.ui.GetStudioModeEnabledResponse;
import io.obswebsocket.community.client.message.response.ui.OpenInputFiltersDialogResponse;
import io.obswebsocket.community.client.message.response.ui.OpenInputInteractDialogResponse;
import io.obswebsocket.community.client.message.response.ui.OpenInputPropertiesDialogResponse;
import io.obswebsocket.community.client.message.response.ui.OpenSourceProjectorResponse;
import io.obswebsocket.community.client.message.response.ui.OpenVideoMixProjectorResponse;
import io.obswebsocket.community.client.message.response.ui.SetStudioModeEnabledResponse;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.model.KeyModifiers;
import io.obswebsocket.community.client.model.MediaInputAction;
import io.obswebsocket.community.client.model.Realm;
import io.obswebsocket.community.client.model.SceneItem;
import io.obswebsocket.community.client.model.VideoMixType;
import java.util.function.Consumer;

public abstract class OBSRemoteControllerBase {
  public abstract <R extends Request, RR extends RequestResponse> void sendRequest(R request,
      Consumer<RR> callback);

  /**
   * Gets the value of a "slot" from the selected persistent data realm.
   *
   * @param realm The data realm to select. `OBS_WEBSOCKET_DATA_REALM_GLOBAL` or `OBS_WEBSOCKET_DATA_REALM_PROFILE`
   * @param slotName The name of the slot to retrieve data from
   * @param callback Consumer&lt;GetPersistentDataResponse&gt;
   */
  public void getPersistentData(Realm realm, String slotName,
      Consumer<GetPersistentDataResponse> callback) {
    this.sendRequest(GetPersistentDataRequest.builder().realm(realm).slotName(slotName).build(), callback);
  }

  /**
   * Gets the value of a "slot" from the selected persistent data realm.
   *
   * @param realm The data realm to select. `OBS_WEBSOCKET_DATA_REALM_GLOBAL` or `OBS_WEBSOCKET_DATA_REALM_PROFILE`
   * @param slotName The name of the slot to retrieve data from
   * @param timeout long timeout in ms
   * @return the GetPersistentDataResponse, null if the request timed out
   */
  public GetPersistentDataResponse getPersistentData(Realm realm, String slotName, long timeout) {
    BlockingConsumer<GetPersistentDataResponse> callback = new BlockingConsumer<GetPersistentDataResponse>();
    this.sendRequest(GetPersistentDataRequest.builder().realm(realm).slotName(slotName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the value of a "slot" from the selected persistent data realm.
   *
   * @param realm The data realm to select. `OBS_WEBSOCKET_DATA_REALM_GLOBAL` or `OBS_WEBSOCKET_DATA_REALM_PROFILE`
   * @param slotName The name of the slot to retrieve data from
   * @param slotValue The value to apply to the slot
   * @param callback Consumer&lt;SetPersistentDataResponse&gt;
   */
  public void setPersistentData(Realm realm, String slotName, JsonElement slotValue,
      Consumer<SetPersistentDataResponse> callback) {
    this.sendRequest(SetPersistentDataRequest.builder().realm(realm).slotName(slotName).slotValue(slotValue).build(), callback);
  }

  /**
   * Sets the value of a "slot" from the selected persistent data realm.
   *
   * @param realm The data realm to select. `OBS_WEBSOCKET_DATA_REALM_GLOBAL` or `OBS_WEBSOCKET_DATA_REALM_PROFILE`
   * @param slotName The name of the slot to retrieve data from
   * @param slotValue The value to apply to the slot
   * @param timeout long timeout in ms
   * @return the SetPersistentDataResponse, null if the request timed out
   */
  public SetPersistentDataResponse setPersistentData(Realm realm, String slotName,
      JsonElement slotValue, long timeout) {
    BlockingConsumer<SetPersistentDataResponse> callback = new BlockingConsumer<SetPersistentDataResponse>();
    this.sendRequest(SetPersistentDataRequest.builder().realm(realm).slotName(slotName).slotValue(slotValue).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all scene collections
   *
   * @param callback Consumer&lt;GetSceneCollectionListResponse&gt;
   */
  public void getSceneCollectionList(Consumer<GetSceneCollectionListResponse> callback) {
    this.sendRequest(GetSceneCollectionListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all scene collections
   *
   * @param timeout long timeout in ms
   * @return the GetSceneCollectionListResponse, null if the request timed out
   */
  public GetSceneCollectionListResponse getSceneCollectionList(long timeout) {
    BlockingConsumer<GetSceneCollectionListResponse> callback = new BlockingConsumer<GetSceneCollectionListResponse>();
    this.sendRequest(GetSceneCollectionListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Switches to a scene collection.
   *
   * Note: This will block until the collection has finished changing.
   *
   * @param sceneCollectionName Name of the scene collection to switch to
   * @param callback Consumer&lt;SetCurrentSceneCollectionResponse&gt;
   */
  public void setCurrentSceneCollection(String sceneCollectionName,
      Consumer<SetCurrentSceneCollectionResponse> callback) {
    this.sendRequest(SetCurrentSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
  }

  /**
   * Switches to a scene collection.
   *
   * Note: This will block until the collection has finished changing.
   *
   * @param sceneCollectionName Name of the scene collection to switch to
   * @param timeout long timeout in ms
   * @return the SetCurrentSceneCollectionResponse, null if the request timed out
   */
  public SetCurrentSceneCollectionResponse setCurrentSceneCollection(String sceneCollectionName,
      long timeout) {
    BlockingConsumer<SetCurrentSceneCollectionResponse> callback = new BlockingConsumer<SetCurrentSceneCollectionResponse>();
    this.sendRequest(SetCurrentSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Creates a new scene collection, switching to it in the process.
   *
   * Note: This will block until the collection has finished changing.
   *
   * @param sceneCollectionName Name for the new scene collection
   * @param callback Consumer&lt;CreateSceneCollectionResponse&gt;
   */
  public void createSceneCollection(String sceneCollectionName,
      Consumer<CreateSceneCollectionResponse> callback) {
    this.sendRequest(CreateSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
  }

  /**
   * Creates a new scene collection, switching to it in the process.
   *
   * Note: This will block until the collection has finished changing.
   *
   * @param sceneCollectionName Name for the new scene collection
   * @param timeout long timeout in ms
   * @return the CreateSceneCollectionResponse, null if the request timed out
   */
  public CreateSceneCollectionResponse createSceneCollection(String sceneCollectionName,
      long timeout) {
    BlockingConsumer<CreateSceneCollectionResponse> callback = new BlockingConsumer<CreateSceneCollectionResponse>();
    this.sendRequest(CreateSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all profiles
   *
   * @param callback Consumer&lt;GetProfileListResponse&gt;
   */
  public void getProfileList(Consumer<GetProfileListResponse> callback) {
    this.sendRequest(GetProfileListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all profiles
   *
   * @param timeout long timeout in ms
   * @return the GetProfileListResponse, null if the request timed out
   */
  public GetProfileListResponse getProfileList(long timeout) {
    BlockingConsumer<GetProfileListResponse> callback = new BlockingConsumer<GetProfileListResponse>();
    this.sendRequest(GetProfileListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Switches to a profile.
   *
   * @param profileName Name of the profile to switch to
   * @param callback Consumer&lt;SetCurrentProfileResponse&gt;
   */
  public void setCurrentProfile(String profileName, Consumer<SetCurrentProfileResponse> callback) {
    this.sendRequest(SetCurrentProfileRequest.builder().profileName(profileName).build(), callback);
  }

  /**
   * Switches to a profile.
   *
   * @param profileName Name of the profile to switch to
   * @param timeout long timeout in ms
   * @return the SetCurrentProfileResponse, null if the request timed out
   */
  public SetCurrentProfileResponse setCurrentProfile(String profileName, long timeout) {
    BlockingConsumer<SetCurrentProfileResponse> callback = new BlockingConsumer<SetCurrentProfileResponse>();
    this.sendRequest(SetCurrentProfileRequest.builder().profileName(profileName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Creates a new profile, switching to it in the process
   *
   * @param profileName Name for the new profile
   * @param callback Consumer&lt;CreateProfileResponse&gt;
   */
  public void createProfile(String profileName, Consumer<CreateProfileResponse> callback) {
    this.sendRequest(CreateProfileRequest.builder().profileName(profileName).build(), callback);
  }

  /**
   * Creates a new profile, switching to it in the process
   *
   * @param profileName Name for the new profile
   * @param timeout long timeout in ms
   * @return the CreateProfileResponse, null if the request timed out
   */
  public CreateProfileResponse createProfile(String profileName, long timeout) {
    BlockingConsumer<CreateProfileResponse> callback = new BlockingConsumer<CreateProfileResponse>();
    this.sendRequest(CreateProfileRequest.builder().profileName(profileName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Removes a profile. If the current profile is chosen, it will change to a different profile first.
   *
   * @param profileName Name of the profile to remove
   * @param callback Consumer&lt;RemoveProfileResponse&gt;
   */
  public void removeProfile(String profileName, Consumer<RemoveProfileResponse> callback) {
    this.sendRequest(RemoveProfileRequest.builder().profileName(profileName).build(), callback);
  }

  /**
   * Removes a profile. If the current profile is chosen, it will change to a different profile first.
   *
   * @param profileName Name of the profile to remove
   * @param timeout long timeout in ms
   * @return the RemoveProfileResponse, null if the request timed out
   */
  public RemoveProfileResponse removeProfile(String profileName, long timeout) {
    BlockingConsumer<RemoveProfileResponse> callback = new BlockingConsumer<RemoveProfileResponse>();
    this.sendRequest(RemoveProfileRequest.builder().profileName(profileName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets a parameter from the current profile's configuration.
   *
   * @param parameterCategory Category of the parameter to get
   * @param parameterName Name of the parameter to get
   * @param callback Consumer&lt;GetProfileParameterResponse&gt;
   */
  public void getProfileParameter(String parameterCategory, String parameterName,
      Consumer<GetProfileParameterResponse> callback) {
    this.sendRequest(GetProfileParameterRequest.builder().parameterCategory(parameterCategory).parameterName(parameterName).build(), callback);
  }

  /**
   * Gets a parameter from the current profile's configuration.
   *
   * @param parameterCategory Category of the parameter to get
   * @param parameterName Name of the parameter to get
   * @param timeout long timeout in ms
   * @return the GetProfileParameterResponse, null if the request timed out
   */
  public GetProfileParameterResponse getProfileParameter(String parameterCategory,
      String parameterName, long timeout) {
    BlockingConsumer<GetProfileParameterResponse> callback = new BlockingConsumer<GetProfileParameterResponse>();
    this.sendRequest(GetProfileParameterRequest.builder().parameterCategory(parameterCategory).parameterName(parameterName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the value of a parameter in the current profile's configuration.
   *
   * @param parameterCategory Category of the parameter to set
   * @param parameterName Name of the parameter to set
   * @param parameterValue Value of the parameter to set. Use `null` to delete
   * @param callback Consumer&lt;SetProfileParameterResponse&gt;
   */
  public void setProfileParameter(String parameterCategory, String parameterName,
      String parameterValue, Consumer<SetProfileParameterResponse> callback) {
    this.sendRequest(SetProfileParameterRequest.builder().parameterCategory(parameterCategory).parameterName(parameterName).parameterValue(parameterValue).build(), callback);
  }

  /**
   * Sets the value of a parameter in the current profile's configuration.
   *
   * @param parameterCategory Category of the parameter to set
   * @param parameterName Name of the parameter to set
   * @param parameterValue Value of the parameter to set. Use `null` to delete
   * @param timeout long timeout in ms
   * @return the SetProfileParameterResponse, null if the request timed out
   */
  public SetProfileParameterResponse setProfileParameter(String parameterCategory,
      String parameterName, String parameterValue, long timeout) {
    BlockingConsumer<SetProfileParameterResponse> callback = new BlockingConsumer<SetProfileParameterResponse>();
    this.sendRequest(SetProfileParameterRequest.builder().parameterCategory(parameterCategory).parameterName(parameterName).parameterValue(parameterValue).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the current video settings.
   *
   * Note: To get the true FPS value, divide the FPS numerator by the FPS denominator. Example: `60000/1001`
   *
   * @param callback Consumer&lt;GetVideoSettingsResponse&gt;
   */
  public void getVideoSettings(Consumer<GetVideoSettingsResponse> callback) {
    this.sendRequest(GetVideoSettingsRequest.builder().build(), callback);
  }

  /**
   * Gets the current video settings.
   *
   * Note: To get the true FPS value, divide the FPS numerator by the FPS denominator. Example: `60000/1001`
   *
   * @param timeout long timeout in ms
   * @return the GetVideoSettingsResponse, null if the request timed out
   */
  public GetVideoSettingsResponse getVideoSettings(long timeout) {
    BlockingConsumer<GetVideoSettingsResponse> callback = new BlockingConsumer<GetVideoSettingsResponse>();
    this.sendRequest(GetVideoSettingsRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the current video settings.
   *
   * Note: Fields must be specified in pairs. For example, you cannot set only `baseWidth` without needing to specify `baseHeight`.
   *
   * @param fpsNumerator Numerator of the fractional FPS value
   * @param fpsDenominator Denominator of the fractional FPS value
   * @param baseWidth Width of the base (canvas) resolution in pixels
   * @param baseHeight Height of the base (canvas) resolution in pixels
   * @param outputWidth Width of the output resolution in pixels
   * @param outputHeight Height of the output resolution in pixels
   * @param callback Consumer&lt;SetVideoSettingsResponse&gt;
   */
  public void setVideoSettings(Number fpsNumerator, Number fpsDenominator, Number baseWidth,
      Number baseHeight, Number outputWidth, Number outputHeight,
      Consumer<SetVideoSettingsResponse> callback) {
    this.sendRequest(SetVideoSettingsRequest.builder().fpsNumerator(fpsNumerator).fpsDenominator(fpsDenominator).baseWidth(baseWidth).baseHeight(baseHeight).outputWidth(outputWidth).outputHeight(outputHeight).build(), callback);
  }

  /**
   * Sets the current video settings.
   *
   * Note: Fields must be specified in pairs. For example, you cannot set only `baseWidth` without needing to specify `baseHeight`.
   *
   * @param fpsNumerator Numerator of the fractional FPS value
   * @param fpsDenominator Denominator of the fractional FPS value
   * @param baseWidth Width of the base (canvas) resolution in pixels
   * @param baseHeight Height of the base (canvas) resolution in pixels
   * @param outputWidth Width of the output resolution in pixels
   * @param outputHeight Height of the output resolution in pixels
   * @param timeout long timeout in ms
   * @return the SetVideoSettingsResponse, null if the request timed out
   */
  public SetVideoSettingsResponse setVideoSettings(Number fpsNumerator, Number fpsDenominator,
      Number baseWidth, Number baseHeight, Number outputWidth, Number outputHeight, long timeout) {
    BlockingConsumer<SetVideoSettingsResponse> callback = new BlockingConsumer<SetVideoSettingsResponse>();
    this.sendRequest(SetVideoSettingsRequest.builder().fpsNumerator(fpsNumerator).fpsDenominator(fpsDenominator).baseWidth(baseWidth).baseHeight(baseHeight).outputWidth(outputWidth).outputHeight(outputHeight).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the current stream service settings (stream destination).
   *
   * @param callback Consumer&lt;GetStreamServiceSettingsResponse&gt;
   */
  public void getStreamServiceSettings(Consumer<GetStreamServiceSettingsResponse> callback) {
    this.sendRequest(GetStreamServiceSettingsRequest.builder().build(), callback);
  }

  /**
   * Gets the current stream service settings (stream destination).
   *
   * @param timeout long timeout in ms
   * @return the GetStreamServiceSettingsResponse, null if the request timed out
   */
  public GetStreamServiceSettingsResponse getStreamServiceSettings(long timeout) {
    BlockingConsumer<GetStreamServiceSettingsResponse> callback = new BlockingConsumer<GetStreamServiceSettingsResponse>();
    this.sendRequest(GetStreamServiceSettingsRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the current stream service settings (stream destination).
   *
   * Note: Simple RTMP settings can be set with type `rtmp_custom` and the settings fields `server` and `key`.
   *
   * @param streamServiceType Type of stream service to apply. Example: `rtmp_common` or `rtmp_custom`
   * @param streamServiceSettings Settings to apply to the service
   * @param callback Consumer&lt;SetStreamServiceSettingsResponse&gt;
   */
  public void setStreamServiceSettings(String streamServiceType, JsonObject streamServiceSettings,
      Consumer<SetStreamServiceSettingsResponse> callback) {
    this.sendRequest(SetStreamServiceSettingsRequest.builder().streamServiceType(streamServiceType).streamServiceSettings(streamServiceSettings).build(), callback);
  }

  /**
   * Sets the current stream service settings (stream destination).
   *
   * Note: Simple RTMP settings can be set with type `rtmp_custom` and the settings fields `server` and `key`.
   *
   * @param streamServiceType Type of stream service to apply. Example: `rtmp_common` or `rtmp_custom`
   * @param streamServiceSettings Settings to apply to the service
   * @param timeout long timeout in ms
   * @return the SetStreamServiceSettingsResponse, null if the request timed out
   */
  public SetStreamServiceSettingsResponse setStreamServiceSettings(String streamServiceType,
      JsonObject streamServiceSettings, long timeout) {
    BlockingConsumer<SetStreamServiceSettingsResponse> callback = new BlockingConsumer<SetStreamServiceSettingsResponse>();
    this.sendRequest(SetStreamServiceSettingsRequest.builder().streamServiceType(streamServiceType).streamServiceSettings(streamServiceSettings).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the current directory that the record output is set to.
   *
   * @param callback Consumer&lt;GetRecordDirectoryResponse&gt;
   */
  public void getRecordDirectory(Consumer<GetRecordDirectoryResponse> callback) {
    this.sendRequest(GetRecordDirectoryRequest.builder().build(), callback);
  }

  /**
   * Gets the current directory that the record output is set to.
   *
   * @param timeout long timeout in ms
   * @return the GetRecordDirectoryResponse, null if the request timed out
   */
  public GetRecordDirectoryResponse getRecordDirectory(long timeout) {
    BlockingConsumer<GetRecordDirectoryResponse> callback = new BlockingConsumer<GetRecordDirectoryResponse>();
    this.sendRequest(GetRecordDirectoryRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all of a source's filters.
   *
   * @param sourceName Name of the source
   * @param callback Consumer&lt;GetSourceFilterListResponse&gt;
   */
  public void getSourceFilterList(String sourceName,
      Consumer<GetSourceFilterListResponse> callback) {
    this.sendRequest(GetSourceFilterListRequest.builder().sourceName(sourceName).build(), callback);
  }

  /**
   * Gets an array of all of a source's filters.
   *
   * @param sourceName Name of the source
   * @param timeout long timeout in ms
   * @return the GetSourceFilterListResponse, null if the request timed out
   */
  public GetSourceFilterListResponse getSourceFilterList(String sourceName, long timeout) {
    BlockingConsumer<GetSourceFilterListResponse> callback = new BlockingConsumer<GetSourceFilterListResponse>();
    this.sendRequest(GetSourceFilterListRequest.builder().sourceName(sourceName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the default settings for a filter kind.
   *
   * @param filterKind Filter kind to get the default settings for
   * @param callback Consumer&lt;GetSourceFilterDefaultSettingsResponse&gt;
   */
  public void getSourceFilterDefaultSettings(String filterKind,
      Consumer<GetSourceFilterDefaultSettingsResponse> callback) {
    this.sendRequest(GetSourceFilterDefaultSettingsRequest.builder().filterKind(filterKind).build(), callback);
  }

  /**
   * Gets the default settings for a filter kind.
   *
   * @param filterKind Filter kind to get the default settings for
   * @param timeout long timeout in ms
   * @return the GetSourceFilterDefaultSettingsResponse, null if the request timed out
   */
  public GetSourceFilterDefaultSettingsResponse getSourceFilterDefaultSettings(String filterKind,
      long timeout) {
    BlockingConsumer<GetSourceFilterDefaultSettingsResponse> callback = new BlockingConsumer<GetSourceFilterDefaultSettingsResponse>();
    this.sendRequest(GetSourceFilterDefaultSettingsRequest.builder().filterKind(filterKind).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Creates a new filter, adding it to the specified source.
   *
   * @param sourceName Name of the source to add the filter to
   * @param filterName Name of the new filter to be created
   * @param filterKind The kind of filter to be created
   * @param filterSettings Settings object to initialize the filter with
   * @param callback Consumer&lt;CreateSourceFilterResponse&gt;
   */
  public void createSourceFilter(String sourceName, String filterName, String filterKind,
      JsonObject filterSettings, Consumer<CreateSourceFilterResponse> callback) {
    this.sendRequest(CreateSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).filterKind(filterKind).filterSettings(filterSettings).build(), callback);
  }

  /**
   * Creates a new filter, adding it to the specified source.
   *
   * @param sourceName Name of the source to add the filter to
   * @param filterName Name of the new filter to be created
   * @param filterKind The kind of filter to be created
   * @param filterSettings Settings object to initialize the filter with
   * @param timeout long timeout in ms
   * @return the CreateSourceFilterResponse, null if the request timed out
   */
  public CreateSourceFilterResponse createSourceFilter(String sourceName, String filterName,
      String filterKind, JsonObject filterSettings, long timeout) {
    BlockingConsumer<CreateSourceFilterResponse> callback = new BlockingConsumer<CreateSourceFilterResponse>();
    this.sendRequest(CreateSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).filterKind(filterKind).filterSettings(filterSettings).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Removes a filter from a source.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter to remove
   * @param callback Consumer&lt;RemoveSourceFilterResponse&gt;
   */
  public void removeSourceFilter(String sourceName, String filterName,
      Consumer<RemoveSourceFilterResponse> callback) {
    this.sendRequest(RemoveSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(), callback);
  }

  /**
   * Removes a filter from a source.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter to remove
   * @param timeout long timeout in ms
   * @return the RemoveSourceFilterResponse, null if the request timed out
   */
  public RemoveSourceFilterResponse removeSourceFilter(String sourceName, String filterName,
      long timeout) {
    BlockingConsumer<RemoveSourceFilterResponse> callback = new BlockingConsumer<RemoveSourceFilterResponse>();
    this.sendRequest(RemoveSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the name of a source filter (rename).
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Current name of the filter
   * @param newFilterName New name for the filter
   * @param callback Consumer&lt;SetSourceFilterNameResponse&gt;
   */
  public void setSourceFilterName(String sourceName, String filterName, String newFilterName,
      Consumer<SetSourceFilterNameResponse> callback) {
    this.sendRequest(SetSourceFilterNameRequest.builder().sourceName(sourceName).filterName(filterName).newFilterName(newFilterName).build(), callback);
  }

  /**
   * Sets the name of a source filter (rename).
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Current name of the filter
   * @param newFilterName New name for the filter
   * @param timeout long timeout in ms
   * @return the SetSourceFilterNameResponse, null if the request timed out
   */
  public SetSourceFilterNameResponse setSourceFilterName(String sourceName, String filterName,
      String newFilterName, long timeout) {
    BlockingConsumer<SetSourceFilterNameResponse> callback = new BlockingConsumer<SetSourceFilterNameResponse>();
    this.sendRequest(SetSourceFilterNameRequest.builder().sourceName(sourceName).filterName(filterName).newFilterName(newFilterName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the info for a specific source filter.
   *
   * @param sourceName Name of the source
   * @param filterName Name of the filter
   * @param callback Consumer&lt;GetSourceFilterResponse&gt;
   */
  public void getSourceFilter(String sourceName, String filterName,
      Consumer<GetSourceFilterResponse> callback) {
    this.sendRequest(GetSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(), callback);
  }

  /**
   * Gets the info for a specific source filter.
   *
   * @param sourceName Name of the source
   * @param filterName Name of the filter
   * @param timeout long timeout in ms
   * @return the GetSourceFilterResponse, null if the request timed out
   */
  public GetSourceFilterResponse getSourceFilter(String sourceName, String filterName,
      long timeout) {
    BlockingConsumer<GetSourceFilterResponse> callback = new BlockingConsumer<GetSourceFilterResponse>();
    this.sendRequest(GetSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the index position of a filter on a source.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter
   * @param filterIndex New index position of the filter
   * @param callback Consumer&lt;SetSourceFilterIndexResponse&gt;
   */
  public void setSourceFilterIndex(String sourceName, String filterName, Number filterIndex,
      Consumer<SetSourceFilterIndexResponse> callback) {
    this.sendRequest(SetSourceFilterIndexRequest.builder().sourceName(sourceName).filterName(filterName).filterIndex(filterIndex).build(), callback);
  }

  /**
   * Sets the index position of a filter on a source.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter
   * @param filterIndex New index position of the filter
   * @param timeout long timeout in ms
   * @return the SetSourceFilterIndexResponse, null if the request timed out
   */
  public SetSourceFilterIndexResponse setSourceFilterIndex(String sourceName, String filterName,
      Number filterIndex, long timeout) {
    BlockingConsumer<SetSourceFilterIndexResponse> callback = new BlockingConsumer<SetSourceFilterIndexResponse>();
    this.sendRequest(SetSourceFilterIndexRequest.builder().sourceName(sourceName).filterName(filterName).filterIndex(filterIndex).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the settings of a source filter.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter to set the settings of
   * @param filterSettings Object of settings to apply
   * @param overlay True == apply the settings on top of existing ones, False == reset the input to its defaults, then apply settings.
   * @param callback Consumer&lt;SetSourceFilterSettingsResponse&gt;
   */
  public void setSourceFilterSettings(String sourceName, String filterName,
      JsonObject filterSettings, Boolean overlay,
      Consumer<SetSourceFilterSettingsResponse> callback) {
    this.sendRequest(SetSourceFilterSettingsRequest.builder().sourceName(sourceName).filterName(filterName).filterSettings(filterSettings).overlay(overlay).build(), callback);
  }

  /**
   * Sets the settings of a source filter.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter to set the settings of
   * @param filterSettings Object of settings to apply
   * @param overlay True == apply the settings on top of existing ones, False == reset the input to its defaults, then apply settings.
   * @param timeout long timeout in ms
   * @return the SetSourceFilterSettingsResponse, null if the request timed out
   */
  public SetSourceFilterSettingsResponse setSourceFilterSettings(String sourceName,
      String filterName, JsonObject filterSettings, Boolean overlay, long timeout) {
    BlockingConsumer<SetSourceFilterSettingsResponse> callback = new BlockingConsumer<SetSourceFilterSettingsResponse>();
    this.sendRequest(SetSourceFilterSettingsRequest.builder().sourceName(sourceName).filterName(filterName).filterSettings(filterSettings).overlay(overlay).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the enable state of a source filter.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter
   * @param filterEnabled New enable state of the filter
   * @param callback Consumer&lt;SetSourceFilterEnabledResponse&gt;
   */
  public void setSourceFilterEnabled(String sourceName, String filterName, Boolean filterEnabled,
      Consumer<SetSourceFilterEnabledResponse> callback) {
    this.sendRequest(SetSourceFilterEnabledRequest.builder().sourceName(sourceName).filterName(filterName).filterEnabled(filterEnabled).build(), callback);
  }

  /**
   * Sets the enable state of a source filter.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter
   * @param filterEnabled New enable state of the filter
   * @param timeout long timeout in ms
   * @return the SetSourceFilterEnabledResponse, null if the request timed out
   */
  public SetSourceFilterEnabledResponse setSourceFilterEnabled(String sourceName, String filterName,
      Boolean filterEnabled, long timeout) {
    BlockingConsumer<SetSourceFilterEnabledResponse> callback = new BlockingConsumer<SetSourceFilterEnabledResponse>();
    this.sendRequest(SetSourceFilterEnabledRequest.builder().sourceName(sourceName).filterName(filterName).filterEnabled(filterEnabled).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets data about the current plugin and RPC version.
   *
   * @param callback Consumer&lt;GetVersionResponse&gt;
   */
  public void getVersion(Consumer<GetVersionResponse> callback) {
    this.sendRequest(GetVersionRequest.builder().build(), callback);
  }

  /**
   * Gets data about the current plugin and RPC version.
   *
   * @param timeout long timeout in ms
   * @return the GetVersionResponse, null if the request timed out
   */
  public GetVersionResponse getVersion(long timeout) {
    BlockingConsumer<GetVersionResponse> callback = new BlockingConsumer<GetVersionResponse>();
    this.sendRequest(GetVersionRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets statistics about OBS, obs-websocket, and the current session.
   *
   * @param callback Consumer&lt;GetStatsResponse&gt;
   */
  public void getStats(Consumer<GetStatsResponse> callback) {
    this.sendRequest(GetStatsRequest.builder().build(), callback);
  }

  /**
   * Gets statistics about OBS, obs-websocket, and the current session.
   *
   * @param timeout long timeout in ms
   * @return the GetStatsResponse, null if the request timed out
   */
  public GetStatsResponse getStats(long timeout) {
    BlockingConsumer<GetStatsResponse> callback = new BlockingConsumer<GetStatsResponse>();
    this.sendRequest(GetStatsRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Broadcasts a `CustomEvent` to all WebSocket clients. Receivers are clients which are identified and subscribed.
   *
   * @param eventData Data payload to emit to all receivers
   * @param callback Consumer&lt;BroadcastCustomEventResponse&gt;
   */
  public void broadcastCustomEvent(JsonObject eventData,
      Consumer<BroadcastCustomEventResponse> callback) {
    this.sendRequest(BroadcastCustomEventRequest.builder().eventData(eventData).build(), callback);
  }

  /**
   * Broadcasts a `CustomEvent` to all WebSocket clients. Receivers are clients which are identified and subscribed.
   *
   * @param eventData Data payload to emit to all receivers
   * @param timeout long timeout in ms
   * @return the BroadcastCustomEventResponse, null if the request timed out
   */
  public BroadcastCustomEventResponse broadcastCustomEvent(JsonObject eventData, long timeout) {
    BlockingConsumer<BroadcastCustomEventResponse> callback = new BlockingConsumer<BroadcastCustomEventResponse>();
    this.sendRequest(BroadcastCustomEventRequest.builder().eventData(eventData).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Call a request registered to a vendor.
   *
   * A vendor is a unique name registered by a third-party plugin or script, which allows for custom requests and events to be added to obs-websocket.
   * If a plugin or script implements vendor requests or events, documentation is expected to be provided with them.
   *
   * @param vendorName Name of the vendor to use
   * @param requestType The request type to call
   * @param requestData Object containing appropriate request data
   * @param callback Consumer&lt;CallVendorRequestResponse&gt;
   */
  public void callVendorRequest(String vendorName, String requestType, JsonObject requestData,
      Consumer<CallVendorRequestResponse> callback) {
    this.sendRequest(CallVendorRequestRequest.builder().vendorName(vendorName).requestType(requestType).requestData(requestData).build(), callback);
  }

  /**
   * Call a request registered to a vendor.
   *
   * A vendor is a unique name registered by a third-party plugin or script, which allows for custom requests and events to be added to obs-websocket.
   * If a plugin or script implements vendor requests or events, documentation is expected to be provided with them.
   *
   * @param vendorName Name of the vendor to use
   * @param requestType The request type to call
   * @param requestData Object containing appropriate request data
   * @param timeout long timeout in ms
   * @return the CallVendorRequestResponse, null if the request timed out
   */
  public CallVendorRequestResponse callVendorRequest(String vendorName, String requestType,
      JsonObject requestData, long timeout) {
    BlockingConsumer<CallVendorRequestResponse> callback = new BlockingConsumer<CallVendorRequestResponse>();
    this.sendRequest(CallVendorRequestRequest.builder().vendorName(vendorName).requestType(requestType).requestData(requestData).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all hotkey names in OBS
   *
   * @param callback Consumer&lt;GetHotkeyListResponse&gt;
   */
  public void getHotkeyList(Consumer<GetHotkeyListResponse> callback) {
    this.sendRequest(GetHotkeyListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all hotkey names in OBS
   *
   * @param timeout long timeout in ms
   * @return the GetHotkeyListResponse, null if the request timed out
   */
  public GetHotkeyListResponse getHotkeyList(long timeout) {
    BlockingConsumer<GetHotkeyListResponse> callback = new BlockingConsumer<GetHotkeyListResponse>();
    this.sendRequest(GetHotkeyListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Triggers a hotkey using its name. See `GetHotkeyList`
   *
   * @param hotkeyName Name of the hotkey to trigger
   * @param callback Consumer&lt;TriggerHotkeyByNameResponse&gt;
   */
  public void triggerHotkeyByName(String hotkeyName,
      Consumer<TriggerHotkeyByNameResponse> callback) {
    this.sendRequest(TriggerHotkeyByNameRequest.builder().hotkeyName(hotkeyName).build(), callback);
  }

  /**
   * Triggers a hotkey using its name. See `GetHotkeyList`
   *
   * @param hotkeyName Name of the hotkey to trigger
   * @param timeout long timeout in ms
   * @return the TriggerHotkeyByNameResponse, null if the request timed out
   */
  public TriggerHotkeyByNameResponse triggerHotkeyByName(String hotkeyName, long timeout) {
    BlockingConsumer<TriggerHotkeyByNameResponse> callback = new BlockingConsumer<TriggerHotkeyByNameResponse>();
    this.sendRequest(TriggerHotkeyByNameRequest.builder().hotkeyName(hotkeyName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Triggers a hotkey using a sequence of keys.
   *
   * @param keyId The OBS key ID to use. See https://github.com/obsproject/obs-studio/blob/master/libobs/obs-hotkeys.h
   * @param keyModifiers Object containing key modifiers to apply
   * @param callback Consumer&lt;TriggerHotkeyByKeySequenceResponse&gt;
   */
  public void triggerHotkeyByKeySequence(String keyId, KeyModifiers keyModifiers,
      Consumer<TriggerHotkeyByKeySequenceResponse> callback) {
    this.sendRequest(TriggerHotkeyByKeySequenceRequest.builder().keyId(keyId).keyModifiers(keyModifiers).build(), callback);
  }

  /**
   * Triggers a hotkey using a sequence of keys.
   *
   * @param keyId The OBS key ID to use. See https://github.com/obsproject/obs-studio/blob/master/libobs/obs-hotkeys.h
   * @param keyModifiers Object containing key modifiers to apply
   * @param timeout long timeout in ms
   * @return the TriggerHotkeyByKeySequenceResponse, null if the request timed out
   */
  public TriggerHotkeyByKeySequenceResponse triggerHotkeyByKeySequence(String keyId,
      KeyModifiers keyModifiers, long timeout) {
    BlockingConsumer<TriggerHotkeyByKeySequenceResponse> callback = new BlockingConsumer<TriggerHotkeyByKeySequenceResponse>();
    this.sendRequest(TriggerHotkeyByKeySequenceRequest.builder().keyId(keyId).keyModifiers(keyModifiers).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sleeps for a time duration or number of frames. Only available in request batches with types `SERIAL_REALTIME` or `SERIAL_FRAME`.
   *
   * @param sleepMillis Number of milliseconds to sleep for (if `SERIAL_REALTIME` mode)
   * @param sleepFrames Number of frames to sleep for (if `SERIAL_FRAME` mode)
   * @param callback Consumer&lt;SleepResponse&gt;
   */
  public void sleep(Number sleepMillis, Number sleepFrames, Consumer<SleepResponse> callback) {
    this.sendRequest(SleepRequest.builder().sleepMillis(sleepMillis).sleepFrames(sleepFrames).build(), callback);
  }

  /**
   * Sleeps for a time duration or number of frames. Only available in request batches with types `SERIAL_REALTIME` or `SERIAL_FRAME`.
   *
   * @param sleepMillis Number of milliseconds to sleep for (if `SERIAL_REALTIME` mode)
   * @param sleepFrames Number of frames to sleep for (if `SERIAL_FRAME` mode)
   * @param timeout long timeout in ms
   * @return the SleepResponse, null if the request timed out
   */
  public SleepResponse sleep(Number sleepMillis, Number sleepFrames, long timeout) {
    BlockingConsumer<SleepResponse> callback = new BlockingConsumer<SleepResponse>();
    this.sendRequest(SleepRequest.builder().sleepMillis(sleepMillis).sleepFrames(sleepFrames).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all inputs in OBS.
   *
   * @param inputKind Restrict the array to only inputs of the specified kind
   * @param callback Consumer&lt;GetInputListResponse&gt;
   */
  public void getInputList(String inputKind, Consumer<GetInputListResponse> callback) {
    this.sendRequest(GetInputListRequest.builder().inputKind(inputKind).build(), callback);
  }

  /**
   * Gets an array of all inputs in OBS.
   *
   * @param inputKind Restrict the array to only inputs of the specified kind
   * @param timeout long timeout in ms
   * @return the GetInputListResponse, null if the request timed out
   */
  public GetInputListResponse getInputList(String inputKind, long timeout) {
    BlockingConsumer<GetInputListResponse> callback = new BlockingConsumer<GetInputListResponse>();
    this.sendRequest(GetInputListRequest.builder().inputKind(inputKind).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all available input kinds in OBS.
   *
   * @param unversioned True == Return all kinds as unversioned, False == Return with version suffixes (if available)
   * @param callback Consumer&lt;GetInputKindListResponse&gt;
   */
  public void getInputKindList(Boolean unversioned, Consumer<GetInputKindListResponse> callback) {
    this.sendRequest(GetInputKindListRequest.builder().unversioned(unversioned).build(), callback);
  }

  /**
   * Gets an array of all available input kinds in OBS.
   *
   * @param unversioned True == Return all kinds as unversioned, False == Return with version suffixes (if available)
   * @param timeout long timeout in ms
   * @return the GetInputKindListResponse, null if the request timed out
   */
  public GetInputKindListResponse getInputKindList(Boolean unversioned, long timeout) {
    BlockingConsumer<GetInputKindListResponse> callback = new BlockingConsumer<GetInputKindListResponse>();
    this.sendRequest(GetInputKindListRequest.builder().unversioned(unversioned).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the names of all special inputs.
   *
   * @param callback Consumer&lt;GetSpecialInputsResponse&gt;
   */
  public void getSpecialInputs(Consumer<GetSpecialInputsResponse> callback) {
    this.sendRequest(GetSpecialInputsRequest.builder().build(), callback);
  }

  /**
   * Gets the names of all special inputs.
   *
   * @param timeout long timeout in ms
   * @return the GetSpecialInputsResponse, null if the request timed out
   */
  public GetSpecialInputsResponse getSpecialInputs(long timeout) {
    BlockingConsumer<GetSpecialInputsResponse> callback = new BlockingConsumer<GetSpecialInputsResponse>();
    this.sendRequest(GetSpecialInputsRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Creates a new input, adding it as a scene item to the specified scene.
   *
   * @param sceneName Name of the scene to add the input to as a scene item
   * @param inputName Name of the new input to created
   * @param inputKind The kind of input to be created
   * @param inputSettings Settings object to initialize the input with
   * @param sceneItemEnabled Whether to set the created scene item to enabled or disabled
   * @param callback Consumer&lt;CreateInputResponse&gt;
   */
  public void createInput(String sceneName, String inputName, String inputKind,
      JsonObject inputSettings, Boolean sceneItemEnabled, Consumer<CreateInputResponse> callback) {
    this.sendRequest(CreateInputRequest.builder().sceneName(sceneName).inputName(inputName).inputKind(inputKind).inputSettings(inputSettings).sceneItemEnabled(sceneItemEnabled).build(), callback);
  }

  /**
   * Creates a new input, adding it as a scene item to the specified scene.
   *
   * @param sceneName Name of the scene to add the input to as a scene item
   * @param inputName Name of the new input to created
   * @param inputKind The kind of input to be created
   * @param inputSettings Settings object to initialize the input with
   * @param sceneItemEnabled Whether to set the created scene item to enabled or disabled
   * @param timeout long timeout in ms
   * @return the CreateInputResponse, null if the request timed out
   */
  public CreateInputResponse createInput(String sceneName, String inputName, String inputKind,
      JsonObject inputSettings, Boolean sceneItemEnabled, long timeout) {
    BlockingConsumer<CreateInputResponse> callback = new BlockingConsumer<CreateInputResponse>();
    this.sendRequest(CreateInputRequest.builder().sceneName(sceneName).inputName(inputName).inputKind(inputKind).inputSettings(inputSettings).sceneItemEnabled(sceneItemEnabled).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Removes an existing input.
   *
   * Note: Will immediately remove all associated scene items.
   *
   * @param inputName Name of the input to remove
   * @param callback Consumer&lt;RemoveInputResponse&gt;
   */
  public void removeInput(String inputName, Consumer<RemoveInputResponse> callback) {
    this.sendRequest(RemoveInputRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Removes an existing input.
   *
   * Note: Will immediately remove all associated scene items.
   *
   * @param inputName Name of the input to remove
   * @param timeout long timeout in ms
   * @return the RemoveInputResponse, null if the request timed out
   */
  public RemoveInputResponse removeInput(String inputName, long timeout) {
    BlockingConsumer<RemoveInputResponse> callback = new BlockingConsumer<RemoveInputResponse>();
    this.sendRequest(RemoveInputRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the name of an input (rename).
   *
   * @param inputName Current input name
   * @param newInputName New name for the input
   * @param callback Consumer&lt;SetInputNameResponse&gt;
   */
  public void setInputName(String inputName, String newInputName,
      Consumer<SetInputNameResponse> callback) {
    this.sendRequest(SetInputNameRequest.builder().inputName(inputName).newInputName(newInputName).build(), callback);
  }

  /**
   * Sets the name of an input (rename).
   *
   * @param inputName Current input name
   * @param newInputName New name for the input
   * @param timeout long timeout in ms
   * @return the SetInputNameResponse, null if the request timed out
   */
  public SetInputNameResponse setInputName(String inputName, String newInputName, long timeout) {
    BlockingConsumer<SetInputNameResponse> callback = new BlockingConsumer<SetInputNameResponse>();
    this.sendRequest(SetInputNameRequest.builder().inputName(inputName).newInputName(newInputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the default settings for an input kind.
   *
   * @param inputKind Input kind to get the default settings for
   * @param callback Consumer&lt;GetInputDefaultSettingsResponse&gt;
   */
  public void getInputDefaultSettings(String inputKind,
      Consumer<GetInputDefaultSettingsResponse> callback) {
    this.sendRequest(GetInputDefaultSettingsRequest.builder().inputKind(inputKind).build(), callback);
  }

  /**
   * Gets the default settings for an input kind.
   *
   * @param inputKind Input kind to get the default settings for
   * @param timeout long timeout in ms
   * @return the GetInputDefaultSettingsResponse, null if the request timed out
   */
  public GetInputDefaultSettingsResponse getInputDefaultSettings(String inputKind, long timeout) {
    BlockingConsumer<GetInputDefaultSettingsResponse> callback = new BlockingConsumer<GetInputDefaultSettingsResponse>();
    this.sendRequest(GetInputDefaultSettingsRequest.builder().inputKind(inputKind).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the settings of an input.
   *
   * Note: Does not include defaults. To create the entire settings object, overlay `inputSettings` over the `defaultInputSettings` provided by `GetInputDefaultSettings`.
   *
   * @param inputName Name of the input to get the settings of
   * @param callback Consumer&lt;GetInputSettingsResponse&gt;
   */
  public void getInputSettings(String inputName, Consumer<GetInputSettingsResponse> callback) {
    this.sendRequest(GetInputSettingsRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the settings of an input.
   *
   * Note: Does not include defaults. To create the entire settings object, overlay `inputSettings` over the `defaultInputSettings` provided by `GetInputDefaultSettings`.
   *
   * @param inputName Name of the input to get the settings of
   * @param timeout long timeout in ms
   * @return the GetInputSettingsResponse, null if the request timed out
   */
  public GetInputSettingsResponse getInputSettings(String inputName, long timeout) {
    BlockingConsumer<GetInputSettingsResponse> callback = new BlockingConsumer<GetInputSettingsResponse>();
    this.sendRequest(GetInputSettingsRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the settings of an input.
   *
   * @param inputName Name of the input to set the settings of
   * @param inputSettings Object of settings to apply
   * @param overlay True == apply the settings on top of existing ones, False == reset the input to its defaults, then apply settings.
   * @param callback Consumer&lt;SetInputSettingsResponse&gt;
   */
  public void setInputSettings(String inputName, JsonObject inputSettings, Boolean overlay,
      Consumer<SetInputSettingsResponse> callback) {
    this.sendRequest(SetInputSettingsRequest.builder().inputName(inputName).inputSettings(inputSettings).overlay(overlay).build(), callback);
  }

  /**
   * Sets the settings of an input.
   *
   * @param inputName Name of the input to set the settings of
   * @param inputSettings Object of settings to apply
   * @param overlay True == apply the settings on top of existing ones, False == reset the input to its defaults, then apply settings.
   * @param timeout long timeout in ms
   * @return the SetInputSettingsResponse, null if the request timed out
   */
  public SetInputSettingsResponse setInputSettings(String inputName, JsonObject inputSettings,
      Boolean overlay, long timeout) {
    BlockingConsumer<SetInputSettingsResponse> callback = new BlockingConsumer<SetInputSettingsResponse>();
    this.sendRequest(SetInputSettingsRequest.builder().inputName(inputName).inputSettings(inputSettings).overlay(overlay).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the audio mute state of an input.
   *
   * @param inputName Name of input to get the mute state of
   * @param callback Consumer&lt;GetInputMuteResponse&gt;
   */
  public void getInputMute(String inputName, Consumer<GetInputMuteResponse> callback) {
    this.sendRequest(GetInputMuteRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the audio mute state of an input.
   *
   * @param inputName Name of input to get the mute state of
   * @param timeout long timeout in ms
   * @return the GetInputMuteResponse, null if the request timed out
   */
  public GetInputMuteResponse getInputMute(String inputName, long timeout) {
    BlockingConsumer<GetInputMuteResponse> callback = new BlockingConsumer<GetInputMuteResponse>();
    this.sendRequest(GetInputMuteRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the audio mute state of an input.
   *
   * @param inputName Name of the input to set the mute state of
   * @param inputMuted Whether to mute the input or not
   * @param callback Consumer&lt;SetInputMuteResponse&gt;
   */
  public void setInputMute(String inputName, Boolean inputMuted,
      Consumer<SetInputMuteResponse> callback) {
    this.sendRequest(SetInputMuteRequest.builder().inputName(inputName).inputMuted(inputMuted).build(), callback);
  }

  /**
   * Sets the audio mute state of an input.
   *
   * @param inputName Name of the input to set the mute state of
   * @param inputMuted Whether to mute the input or not
   * @param timeout long timeout in ms
   * @return the SetInputMuteResponse, null if the request timed out
   */
  public SetInputMuteResponse setInputMute(String inputName, Boolean inputMuted, long timeout) {
    BlockingConsumer<SetInputMuteResponse> callback = new BlockingConsumer<SetInputMuteResponse>();
    this.sendRequest(SetInputMuteRequest.builder().inputName(inputName).inputMuted(inputMuted).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Toggles the audio mute state of an input.
   *
   * @param inputName Name of the input to toggle the mute state of
   * @param callback Consumer&lt;ToggleInputMuteResponse&gt;
   */
  public void toggleInputMute(String inputName, Consumer<ToggleInputMuteResponse> callback) {
    this.sendRequest(ToggleInputMuteRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Toggles the audio mute state of an input.
   *
   * @param inputName Name of the input to toggle the mute state of
   * @param timeout long timeout in ms
   * @return the ToggleInputMuteResponse, null if the request timed out
   */
  public ToggleInputMuteResponse toggleInputMute(String inputName, long timeout) {
    BlockingConsumer<ToggleInputMuteResponse> callback = new BlockingConsumer<ToggleInputMuteResponse>();
    this.sendRequest(ToggleInputMuteRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the current volume setting of an input.
   *
   * @param inputName Name of the input to get the volume of
   * @param callback Consumer&lt;GetInputVolumeResponse&gt;
   */
  public void getInputVolume(String inputName, Consumer<GetInputVolumeResponse> callback) {
    this.sendRequest(GetInputVolumeRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the current volume setting of an input.
   *
   * @param inputName Name of the input to get the volume of
   * @param timeout long timeout in ms
   * @return the GetInputVolumeResponse, null if the request timed out
   */
  public GetInputVolumeResponse getInputVolume(String inputName, long timeout) {
    BlockingConsumer<GetInputVolumeResponse> callback = new BlockingConsumer<GetInputVolumeResponse>();
    this.sendRequest(GetInputVolumeRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the volume setting of an input.
   *
   * @param inputName Name of the input to set the volume of
   * @param inputVolumeMul Volume setting in mul
   * @param inputVolumeDb Volume setting in dB
   * @param callback Consumer&lt;SetInputVolumeResponse&gt;
   */
  public void setInputVolume(String inputName, Number inputVolumeMul, Number inputVolumeDb,
      Consumer<SetInputVolumeResponse> callback) {
    this.sendRequest(SetInputVolumeRequest.builder().inputName(inputName).inputVolumeMul(inputVolumeMul).inputVolumeDb(inputVolumeDb).build(), callback);
  }

  /**
   * Sets the volume setting of an input.
   *
   * @param inputName Name of the input to set the volume of
   * @param inputVolumeMul Volume setting in mul
   * @param inputVolumeDb Volume setting in dB
   * @param timeout long timeout in ms
   * @return the SetInputVolumeResponse, null if the request timed out
   */
  public SetInputVolumeResponse setInputVolume(String inputName, Number inputVolumeMul,
      Number inputVolumeDb, long timeout) {
    BlockingConsumer<SetInputVolumeResponse> callback = new BlockingConsumer<SetInputVolumeResponse>();
    this.sendRequest(SetInputVolumeRequest.builder().inputName(inputName).inputVolumeMul(inputVolumeMul).inputVolumeDb(inputVolumeDb).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the audio balance of an input.
   *
   * @param inputName Name of the input to get the audio balance of
   * @param callback Consumer&lt;GetInputAudioBalanceResponse&gt;
   */
  public void getInputAudioBalance(String inputName,
      Consumer<GetInputAudioBalanceResponse> callback) {
    this.sendRequest(GetInputAudioBalanceRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the audio balance of an input.
   *
   * @param inputName Name of the input to get the audio balance of
   * @param timeout long timeout in ms
   * @return the GetInputAudioBalanceResponse, null if the request timed out
   */
  public GetInputAudioBalanceResponse getInputAudioBalance(String inputName, long timeout) {
    BlockingConsumer<GetInputAudioBalanceResponse> callback = new BlockingConsumer<GetInputAudioBalanceResponse>();
    this.sendRequest(GetInputAudioBalanceRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the audio balance of an input.
   *
   * @param inputName Name of the input to set the audio balance of
   * @param inputAudioBalance New audio balance value
   * @param callback Consumer&lt;SetInputAudioBalanceResponse&gt;
   */
  public void setInputAudioBalance(String inputName, Number inputAudioBalance,
      Consumer<SetInputAudioBalanceResponse> callback) {
    this.sendRequest(SetInputAudioBalanceRequest.builder().inputName(inputName).inputAudioBalance(inputAudioBalance).build(), callback);
  }

  /**
   * Sets the audio balance of an input.
   *
   * @param inputName Name of the input to set the audio balance of
   * @param inputAudioBalance New audio balance value
   * @param timeout long timeout in ms
   * @return the SetInputAudioBalanceResponse, null if the request timed out
   */
  public SetInputAudioBalanceResponse setInputAudioBalance(String inputName,
      Number inputAudioBalance, long timeout) {
    BlockingConsumer<SetInputAudioBalanceResponse> callback = new BlockingConsumer<SetInputAudioBalanceResponse>();
    this.sendRequest(SetInputAudioBalanceRequest.builder().inputName(inputName).inputAudioBalance(inputAudioBalance).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the audio sync offset of an input.
   *
   * Note: The audio sync offset can be negative too!
   *
   * @param inputName Name of the input to get the audio sync offset of
   * @param callback Consumer&lt;GetInputAudioSyncOffsetResponse&gt;
   */
  public void getInputAudioSyncOffset(String inputName,
      Consumer<GetInputAudioSyncOffsetResponse> callback) {
    this.sendRequest(GetInputAudioSyncOffsetRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the audio sync offset of an input.
   *
   * Note: The audio sync offset can be negative too!
   *
   * @param inputName Name of the input to get the audio sync offset of
   * @param timeout long timeout in ms
   * @return the GetInputAudioSyncOffsetResponse, null if the request timed out
   */
  public GetInputAudioSyncOffsetResponse getInputAudioSyncOffset(String inputName, long timeout) {
    BlockingConsumer<GetInputAudioSyncOffsetResponse> callback = new BlockingConsumer<GetInputAudioSyncOffsetResponse>();
    this.sendRequest(GetInputAudioSyncOffsetRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the audio sync offset of an input.
   *
   * @param inputName Name of the input to set the audio sync offset of
   * @param inputAudioSyncOffset New audio sync offset in milliseconds
   * @param callback Consumer&lt;SetInputAudioSyncOffsetResponse&gt;
   */
  public void setInputAudioSyncOffset(String inputName, Number inputAudioSyncOffset,
      Consumer<SetInputAudioSyncOffsetResponse> callback) {
    this.sendRequest(SetInputAudioSyncOffsetRequest.builder().inputName(inputName).inputAudioSyncOffset(inputAudioSyncOffset).build(), callback);
  }

  /**
   * Sets the audio sync offset of an input.
   *
   * @param inputName Name of the input to set the audio sync offset of
   * @param inputAudioSyncOffset New audio sync offset in milliseconds
   * @param timeout long timeout in ms
   * @return the SetInputAudioSyncOffsetResponse, null if the request timed out
   */
  public SetInputAudioSyncOffsetResponse setInputAudioSyncOffset(String inputName,
      Number inputAudioSyncOffset, long timeout) {
    BlockingConsumer<SetInputAudioSyncOffsetResponse> callback = new BlockingConsumer<SetInputAudioSyncOffsetResponse>();
    this.sendRequest(SetInputAudioSyncOffsetRequest.builder().inputName(inputName).inputAudioSyncOffset(inputAudioSyncOffset).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the audio monitor type of an input.
   *
   * The available audio monitor types are:
   *
   * - `OBS_MONITORING_TYPE_NONE`
   * - `OBS_MONITORING_TYPE_MONITOR_ONLY`
   * - `OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT`
   *
   * @param inputName Name of the input to get the audio monitor type of
   * @param callback Consumer&lt;GetInputAudioMonitorTypeResponse&gt;
   */
  public void getInputAudioMonitorType(String inputName,
      Consumer<GetInputAudioMonitorTypeResponse> callback) {
    this.sendRequest(GetInputAudioMonitorTypeRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the audio monitor type of an input.
   *
   * The available audio monitor types are:
   *
   * - `OBS_MONITORING_TYPE_NONE`
   * - `OBS_MONITORING_TYPE_MONITOR_ONLY`
   * - `OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT`
   *
   * @param inputName Name of the input to get the audio monitor type of
   * @param timeout long timeout in ms
   * @return the GetInputAudioMonitorTypeResponse, null if the request timed out
   */
  public GetInputAudioMonitorTypeResponse getInputAudioMonitorType(String inputName, long timeout) {
    BlockingConsumer<GetInputAudioMonitorTypeResponse> callback = new BlockingConsumer<GetInputAudioMonitorTypeResponse>();
    this.sendRequest(GetInputAudioMonitorTypeRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the audio monitor type of an input.
   *
   * @param inputName Name of the input to set the audio monitor type of
   * @param monitorType Audio monitor type
   * @param callback Consumer&lt;SetInputAudioMonitorTypeResponse&gt;
   */
  public void setInputAudioMonitorType(String inputName, Input.MonitorType monitorType,
      Consumer<SetInputAudioMonitorTypeResponse> callback) {
    this.sendRequest(SetInputAudioMonitorTypeRequest.builder().inputName(inputName).monitorType(monitorType).build(), callback);
  }

  /**
   * Sets the audio monitor type of an input.
   *
   * @param inputName Name of the input to set the audio monitor type of
   * @param monitorType Audio monitor type
   * @param timeout long timeout in ms
   * @return the SetInputAudioMonitorTypeResponse, null if the request timed out
   */
  public SetInputAudioMonitorTypeResponse setInputAudioMonitorType(String inputName,
      Input.MonitorType monitorType, long timeout) {
    BlockingConsumer<SetInputAudioMonitorTypeResponse> callback = new BlockingConsumer<SetInputAudioMonitorTypeResponse>();
    this.sendRequest(SetInputAudioMonitorTypeRequest.builder().inputName(inputName).monitorType(monitorType).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the enable state of all audio tracks of an input.
   *
   * @param inputName Name of the input
   * @param callback Consumer&lt;GetInputAudioTracksResponse&gt;
   */
  public void getInputAudioTracks(String inputName,
      Consumer<GetInputAudioTracksResponse> callback) {
    this.sendRequest(GetInputAudioTracksRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the enable state of all audio tracks of an input.
   *
   * @param inputName Name of the input
   * @param timeout long timeout in ms
   * @return the GetInputAudioTracksResponse, null if the request timed out
   */
  public GetInputAudioTracksResponse getInputAudioTracks(String inputName, long timeout) {
    BlockingConsumer<GetInputAudioTracksResponse> callback = new BlockingConsumer<GetInputAudioTracksResponse>();
    this.sendRequest(GetInputAudioTracksRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the enable state of audio tracks of an input.
   *
   * @param inputName Name of the input
   * @param inputAudioTracks Track settings to apply
   * @param callback Consumer&lt;SetInputAudioTracksResponse&gt;
   */
  public void setInputAudioTracks(String inputName, Input.AudioTracks inputAudioTracks,
      Consumer<SetInputAudioTracksResponse> callback) {
    this.sendRequest(SetInputAudioTracksRequest.builder().inputName(inputName).inputAudioTracks(inputAudioTracks).build(), callback);
  }

  /**
   * Sets the enable state of audio tracks of an input.
   *
   * @param inputName Name of the input
   * @param inputAudioTracks Track settings to apply
   * @param timeout long timeout in ms
   * @return the SetInputAudioTracksResponse, null if the request timed out
   */
  public SetInputAudioTracksResponse setInputAudioTracks(String inputName,
      Input.AudioTracks inputAudioTracks, long timeout) {
    BlockingConsumer<SetInputAudioTracksResponse> callback = new BlockingConsumer<SetInputAudioTracksResponse>();
    this.sendRequest(SetInputAudioTracksRequest.builder().inputName(inputName).inputAudioTracks(inputAudioTracks).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the items of a list property from an input's properties.
   *
   * Note: Use this in cases where an input provides a dynamic, selectable list of items. For example, display capture, where it provides a list of available displays.
   *
   * @param inputName Name of the input
   * @param propertyName Name of the list property to get the items of
   * @param callback Consumer&lt;GetInputPropertiesListPropertyItemsResponse&gt;
   */
  public void getInputPropertiesListPropertyItems(String inputName, String propertyName,
      Consumer<GetInputPropertiesListPropertyItemsResponse> callback) {
    this.sendRequest(GetInputPropertiesListPropertyItemsRequest.builder().inputName(inputName).propertyName(propertyName).build(), callback);
  }

  /**
   * Gets the items of a list property from an input's properties.
   *
   * Note: Use this in cases where an input provides a dynamic, selectable list of items. For example, display capture, where it provides a list of available displays.
   *
   * @param inputName Name of the input
   * @param propertyName Name of the list property to get the items of
   * @param timeout long timeout in ms
   * @return the GetInputPropertiesListPropertyItemsResponse, null if the request timed out
   */
  public GetInputPropertiesListPropertyItemsResponse getInputPropertiesListPropertyItems(
      String inputName, String propertyName, long timeout) {
    BlockingConsumer<GetInputPropertiesListPropertyItemsResponse> callback = new BlockingConsumer<GetInputPropertiesListPropertyItemsResponse>();
    this.sendRequest(GetInputPropertiesListPropertyItemsRequest.builder().inputName(inputName).propertyName(propertyName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Presses a button in the properties of an input.
   *
   * Some known `propertyName` values are:
   *
   * - `refreshnocache` - Browser source reload button
   *
   * Note: Use this in cases where there is a button in the properties of an input that cannot be accessed in any other way. For example, browser sources, where there is a refresh button.
   *
   * @param inputName Name of the input
   * @param propertyName Name of the button property to press
   * @param callback Consumer&lt;PressInputPropertiesButtonResponse&gt;
   */
  public void pressInputPropertiesButton(String inputName, String propertyName,
      Consumer<PressInputPropertiesButtonResponse> callback) {
    this.sendRequest(PressInputPropertiesButtonRequest.builder().inputName(inputName).propertyName(propertyName).build(), callback);
  }

  /**
   * Presses a button in the properties of an input.
   *
   * Some known `propertyName` values are:
   *
   * - `refreshnocache` - Browser source reload button
   *
   * Note: Use this in cases where there is a button in the properties of an input that cannot be accessed in any other way. For example, browser sources, where there is a refresh button.
   *
   * @param inputName Name of the input
   * @param propertyName Name of the button property to press
   * @param timeout long timeout in ms
   * @return the PressInputPropertiesButtonResponse, null if the request timed out
   */
  public PressInputPropertiesButtonResponse pressInputPropertiesButton(String inputName,
      String propertyName, long timeout) {
    BlockingConsumer<PressInputPropertiesButtonResponse> callback = new BlockingConsumer<PressInputPropertiesButtonResponse>();
    this.sendRequest(PressInputPropertiesButtonRequest.builder().inputName(inputName).propertyName(propertyName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the status of a media input.
   *
   * Media States:
   *
   * - `OBS_MEDIA_STATE_NONE`
   * - `OBS_MEDIA_STATE_PLAYING`
   * - `OBS_MEDIA_STATE_OPENING`
   * - `OBS_MEDIA_STATE_BUFFERING`
   * - `OBS_MEDIA_STATE_PAUSED`
   * - `OBS_MEDIA_STATE_STOPPED`
   * - `OBS_MEDIA_STATE_ENDED`
   * - `OBS_MEDIA_STATE_ERROR`
   *
   * @param inputName Name of the media input
   * @param callback Consumer&lt;GetMediaInputStatusResponse&gt;
   */
  public void getMediaInputStatus(String inputName,
      Consumer<GetMediaInputStatusResponse> callback) {
    this.sendRequest(GetMediaInputStatusRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the status of a media input.
   *
   * Media States:
   *
   * - `OBS_MEDIA_STATE_NONE`
   * - `OBS_MEDIA_STATE_PLAYING`
   * - `OBS_MEDIA_STATE_OPENING`
   * - `OBS_MEDIA_STATE_BUFFERING`
   * - `OBS_MEDIA_STATE_PAUSED`
   * - `OBS_MEDIA_STATE_STOPPED`
   * - `OBS_MEDIA_STATE_ENDED`
   * - `OBS_MEDIA_STATE_ERROR`
   *
   * @param inputName Name of the media input
   * @param timeout long timeout in ms
   * @return the GetMediaInputStatusResponse, null if the request timed out
   */
  public GetMediaInputStatusResponse getMediaInputStatus(String inputName, long timeout) {
    BlockingConsumer<GetMediaInputStatusResponse> callback = new BlockingConsumer<GetMediaInputStatusResponse>();
    this.sendRequest(GetMediaInputStatusRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the cursor position of a media input.
   *
   * This request does not perform bounds checking of the cursor position.
   *
   * @param inputName Name of the media input
   * @param mediaCursor New cursor position to set
   * @param callback Consumer&lt;SetMediaInputCursorResponse&gt;
   */
  public void setMediaInputCursor(String inputName, Number mediaCursor,
      Consumer<SetMediaInputCursorResponse> callback) {
    this.sendRequest(SetMediaInputCursorRequest.builder().inputName(inputName).mediaCursor(mediaCursor).build(), callback);
  }

  /**
   * Sets the cursor position of a media input.
   *
   * This request does not perform bounds checking of the cursor position.
   *
   * @param inputName Name of the media input
   * @param mediaCursor New cursor position to set
   * @param timeout long timeout in ms
   * @return the SetMediaInputCursorResponse, null if the request timed out
   */
  public SetMediaInputCursorResponse setMediaInputCursor(String inputName, Number mediaCursor,
      long timeout) {
    BlockingConsumer<SetMediaInputCursorResponse> callback = new BlockingConsumer<SetMediaInputCursorResponse>();
    this.sendRequest(SetMediaInputCursorRequest.builder().inputName(inputName).mediaCursor(mediaCursor).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Offsets the current cursor position of a media input by the specified value.
   *
   * This request does not perform bounds checking of the cursor position.
   *
   * @param inputName Name of the media input
   * @param mediaCursorOffset Value to offset the current cursor position by
   * @param callback Consumer&lt;OffsetMediaInputCursorResponse&gt;
   */
  public void offsetMediaInputCursor(String inputName, Number mediaCursorOffset,
      Consumer<OffsetMediaInputCursorResponse> callback) {
    this.sendRequest(OffsetMediaInputCursorRequest.builder().inputName(inputName).mediaCursorOffset(mediaCursorOffset).build(), callback);
  }

  /**
   * Offsets the current cursor position of a media input by the specified value.
   *
   * This request does not perform bounds checking of the cursor position.
   *
   * @param inputName Name of the media input
   * @param mediaCursorOffset Value to offset the current cursor position by
   * @param timeout long timeout in ms
   * @return the OffsetMediaInputCursorResponse, null if the request timed out
   */
  public OffsetMediaInputCursorResponse offsetMediaInputCursor(String inputName,
      Number mediaCursorOffset, long timeout) {
    BlockingConsumer<OffsetMediaInputCursorResponse> callback = new BlockingConsumer<OffsetMediaInputCursorResponse>();
    this.sendRequest(OffsetMediaInputCursorRequest.builder().inputName(inputName).mediaCursorOffset(mediaCursorOffset).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Triggers an action on a media input.
   *
   * @param inputName Name of the media input
   * @param mediaAction Identifier of the `ObsMediaInputAction` enum
   * @param callback Consumer&lt;TriggerMediaInputActionResponse&gt;
   */
  public void triggerMediaInputAction(String inputName, MediaInputAction mediaAction,
      Consumer<TriggerMediaInputActionResponse> callback) {
    this.sendRequest(TriggerMediaInputActionRequest.builder().inputName(inputName).mediaAction(mediaAction).build(), callback);
  }

  /**
   * Triggers an action on a media input.
   *
   * @param inputName Name of the media input
   * @param mediaAction Identifier of the `ObsMediaInputAction` enum
   * @param timeout long timeout in ms
   * @return the TriggerMediaInputActionResponse, null if the request timed out
   */
  public TriggerMediaInputActionResponse triggerMediaInputAction(String inputName,
      MediaInputAction mediaAction, long timeout) {
    BlockingConsumer<TriggerMediaInputActionResponse> callback = new BlockingConsumer<TriggerMediaInputActionResponse>();
    this.sendRequest(TriggerMediaInputActionRequest.builder().inputName(inputName).mediaAction(mediaAction).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the status of the virtualcam output.
   *
   * @param callback Consumer&lt;GetVirtualCamStatusResponse&gt;
   */
  public void getVirtualCamStatus(Consumer<GetVirtualCamStatusResponse> callback) {
    this.sendRequest(GetVirtualCamStatusRequest.builder().build(), callback);
  }

  /**
   * Gets the status of the virtualcam output.
   *
   * @param timeout long timeout in ms
   * @return the GetVirtualCamStatusResponse, null if the request timed out
   */
  public GetVirtualCamStatusResponse getVirtualCamStatus(long timeout) {
    BlockingConsumer<GetVirtualCamStatusResponse> callback = new BlockingConsumer<GetVirtualCamStatusResponse>();
    this.sendRequest(GetVirtualCamStatusRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Toggles the state of the virtualcam output.
   *
   * @param callback Consumer&lt;ToggleVirtualCamResponse&gt;
   */
  public void toggleVirtualCam(Consumer<ToggleVirtualCamResponse> callback) {
    this.sendRequest(ToggleVirtualCamRequest.builder().build(), callback);
  }

  /**
   * Toggles the state of the virtualcam output.
   *
   * @param timeout long timeout in ms
   * @return the ToggleVirtualCamResponse, null if the request timed out
   */
  public ToggleVirtualCamResponse toggleVirtualCam(long timeout) {
    BlockingConsumer<ToggleVirtualCamResponse> callback = new BlockingConsumer<ToggleVirtualCamResponse>();
    this.sendRequest(ToggleVirtualCamRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Starts the virtualcam output.
   *
   * @param callback Consumer&lt;StartVirtualCamResponse&gt;
   */
  public void startVirtualCam(Consumer<StartVirtualCamResponse> callback) {
    this.sendRequest(StartVirtualCamRequest.builder().build(), callback);
  }

  /**
   * Starts the virtualcam output.
   *
   * @param timeout long timeout in ms
   * @return the StartVirtualCamResponse, null if the request timed out
   */
  public StartVirtualCamResponse startVirtualCam(long timeout) {
    BlockingConsumer<StartVirtualCamResponse> callback = new BlockingConsumer<StartVirtualCamResponse>();
    this.sendRequest(StartVirtualCamRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Stops the virtualcam output.
   *
   * @param callback Consumer&lt;StopVirtualCamResponse&gt;
   */
  public void stopVirtualCam(Consumer<StopVirtualCamResponse> callback) {
    this.sendRequest(StopVirtualCamRequest.builder().build(), callback);
  }

  /**
   * Stops the virtualcam output.
   *
   * @param timeout long timeout in ms
   * @return the StopVirtualCamResponse, null if the request timed out
   */
  public StopVirtualCamResponse stopVirtualCam(long timeout) {
    BlockingConsumer<StopVirtualCamResponse> callback = new BlockingConsumer<StopVirtualCamResponse>();
    this.sendRequest(StopVirtualCamRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the status of the replay buffer output.
   *
   * @param callback Consumer&lt;GetReplayBufferStatusResponse&gt;
   */
  public void getReplayBufferStatus(Consumer<GetReplayBufferStatusResponse> callback) {
    this.sendRequest(GetReplayBufferStatusRequest.builder().build(), callback);
  }

  /**
   * Gets the status of the replay buffer output.
   *
   * @param timeout long timeout in ms
   * @return the GetReplayBufferStatusResponse, null if the request timed out
   */
  public GetReplayBufferStatusResponse getReplayBufferStatus(long timeout) {
    BlockingConsumer<GetReplayBufferStatusResponse> callback = new BlockingConsumer<GetReplayBufferStatusResponse>();
    this.sendRequest(GetReplayBufferStatusRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Toggles the state of the replay buffer output.
   *
   * @param callback Consumer&lt;ToggleReplayBufferResponse&gt;
   */
  public void toggleReplayBuffer(Consumer<ToggleReplayBufferResponse> callback) {
    this.sendRequest(ToggleReplayBufferRequest.builder().build(), callback);
  }

  /**
   * Toggles the state of the replay buffer output.
   *
   * @param timeout long timeout in ms
   * @return the ToggleReplayBufferResponse, null if the request timed out
   */
  public ToggleReplayBufferResponse toggleReplayBuffer(long timeout) {
    BlockingConsumer<ToggleReplayBufferResponse> callback = new BlockingConsumer<ToggleReplayBufferResponse>();
    this.sendRequest(ToggleReplayBufferRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Starts the replay buffer output.
   *
   * @param callback Consumer&lt;StartReplayBufferResponse&gt;
   */
  public void startReplayBuffer(Consumer<StartReplayBufferResponse> callback) {
    this.sendRequest(StartReplayBufferRequest.builder().build(), callback);
  }

  /**
   * Starts the replay buffer output.
   *
   * @param timeout long timeout in ms
   * @return the StartReplayBufferResponse, null if the request timed out
   */
  public StartReplayBufferResponse startReplayBuffer(long timeout) {
    BlockingConsumer<StartReplayBufferResponse> callback = new BlockingConsumer<StartReplayBufferResponse>();
    this.sendRequest(StartReplayBufferRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Stops the replay buffer output.
   *
   * @param callback Consumer&lt;StopReplayBufferResponse&gt;
   */
  public void stopReplayBuffer(Consumer<StopReplayBufferResponse> callback) {
    this.sendRequest(StopReplayBufferRequest.builder().build(), callback);
  }

  /**
   * Stops the replay buffer output.
   *
   * @param timeout long timeout in ms
   * @return the StopReplayBufferResponse, null if the request timed out
   */
  public StopReplayBufferResponse stopReplayBuffer(long timeout) {
    BlockingConsumer<StopReplayBufferResponse> callback = new BlockingConsumer<StopReplayBufferResponse>();
    this.sendRequest(StopReplayBufferRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Saves the contents of the replay buffer output.
   *
   * @param callback Consumer&lt;SaveReplayBufferResponse&gt;
   */
  public void saveReplayBuffer(Consumer<SaveReplayBufferResponse> callback) {
    this.sendRequest(SaveReplayBufferRequest.builder().build(), callback);
  }

  /**
   * Saves the contents of the replay buffer output.
   *
   * @param timeout long timeout in ms
   * @return the SaveReplayBufferResponse, null if the request timed out
   */
  public SaveReplayBufferResponse saveReplayBuffer(long timeout) {
    BlockingConsumer<SaveReplayBufferResponse> callback = new BlockingConsumer<SaveReplayBufferResponse>();
    this.sendRequest(SaveReplayBufferRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the filename of the last replay buffer save file.
   *
   * @param callback Consumer&lt;GetLastReplayBufferReplayResponse&gt;
   */
  public void getLastReplayBufferReplay(Consumer<GetLastReplayBufferReplayResponse> callback) {
    this.sendRequest(GetLastReplayBufferReplayRequest.builder().build(), callback);
  }

  /**
   * Gets the filename of the last replay buffer save file.
   *
   * @param timeout long timeout in ms
   * @return the GetLastReplayBufferReplayResponse, null if the request timed out
   */
  public GetLastReplayBufferReplayResponse getLastReplayBufferReplay(long timeout) {
    BlockingConsumer<GetLastReplayBufferReplayResponse> callback = new BlockingConsumer<GetLastReplayBufferReplayResponse>();
    this.sendRequest(GetLastReplayBufferReplayRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the list of available outputs.
   *
   * @param callback Consumer&lt;GetOutputListResponse&gt;
   */
  public void getOutputList(Consumer<GetOutputListResponse> callback) {
    this.sendRequest(GetOutputListRequest.builder().build(), callback);
  }

  /**
   * Gets the list of available outputs.
   *
   * @param timeout long timeout in ms
   * @return the GetOutputListResponse, null if the request timed out
   */
  public GetOutputListResponse getOutputList(long timeout) {
    BlockingConsumer<GetOutputListResponse> callback = new BlockingConsumer<GetOutputListResponse>();
    this.sendRequest(GetOutputListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the status of an output.
   *
   * @param outputName Output name
   * @param callback Consumer&lt;GetOutputStatusResponse&gt;
   */
  public void getOutputStatus(String outputName, Consumer<GetOutputStatusResponse> callback) {
    this.sendRequest(GetOutputStatusRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Gets the status of an output.
   *
   * @param outputName Output name
   * @param timeout long timeout in ms
   * @return the GetOutputStatusResponse, null if the request timed out
   */
  public GetOutputStatusResponse getOutputStatus(String outputName, long timeout) {
    BlockingConsumer<GetOutputStatusResponse> callback = new BlockingConsumer<GetOutputStatusResponse>();
    this.sendRequest(GetOutputStatusRequest.builder().outputName(outputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Toggles the status of an output.
   *
   * @param outputName Output name
   * @param callback Consumer&lt;ToggleOutputResponse&gt;
   */
  public void toggleOutput(String outputName, Consumer<ToggleOutputResponse> callback) {
    this.sendRequest(ToggleOutputRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Toggles the status of an output.
   *
   * @param outputName Output name
   * @param timeout long timeout in ms
   * @return the ToggleOutputResponse, null if the request timed out
   */
  public ToggleOutputResponse toggleOutput(String outputName, long timeout) {
    BlockingConsumer<ToggleOutputResponse> callback = new BlockingConsumer<ToggleOutputResponse>();
    this.sendRequest(ToggleOutputRequest.builder().outputName(outputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Starts an output.
   *
   * @param outputName Output name
   * @param callback Consumer&lt;StartOutputResponse&gt;
   */
  public void startOutput(String outputName, Consumer<StartOutputResponse> callback) {
    this.sendRequest(StartOutputRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Starts an output.
   *
   * @param outputName Output name
   * @param timeout long timeout in ms
   * @return the StartOutputResponse, null if the request timed out
   */
  public StartOutputResponse startOutput(String outputName, long timeout) {
    BlockingConsumer<StartOutputResponse> callback = new BlockingConsumer<StartOutputResponse>();
    this.sendRequest(StartOutputRequest.builder().outputName(outputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Stops an output.
   *
   * @param outputName Output name
   * @param callback Consumer&lt;StopOutputResponse&gt;
   */
  public void stopOutput(String outputName, Consumer<StopOutputResponse> callback) {
    this.sendRequest(StopOutputRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Stops an output.
   *
   * @param outputName Output name
   * @param timeout long timeout in ms
   * @return the StopOutputResponse, null if the request timed out
   */
  public StopOutputResponse stopOutput(String outputName, long timeout) {
    BlockingConsumer<StopOutputResponse> callback = new BlockingConsumer<StopOutputResponse>();
    this.sendRequest(StopOutputRequest.builder().outputName(outputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the settings of an output.
   *
   * @param outputName Output name
   * @param callback Consumer&lt;GetOutputSettingsResponse&gt;
   */
  public void getOutputSettings(String outputName, Consumer<GetOutputSettingsResponse> callback) {
    this.sendRequest(GetOutputSettingsRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Gets the settings of an output.
   *
   * @param outputName Output name
   * @param timeout long timeout in ms
   * @return the GetOutputSettingsResponse, null if the request timed out
   */
  public GetOutputSettingsResponse getOutputSettings(String outputName, long timeout) {
    BlockingConsumer<GetOutputSettingsResponse> callback = new BlockingConsumer<GetOutputSettingsResponse>();
    this.sendRequest(GetOutputSettingsRequest.builder().outputName(outputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the settings of an output.
   *
   * @param outputName Output name
   * @param outputSettings Output settings
   * @param callback Consumer&lt;SetOutputSettingsResponse&gt;
   */
  public void setOutputSettings(String outputName, JsonObject outputSettings,
      Consumer<SetOutputSettingsResponse> callback) {
    this.sendRequest(SetOutputSettingsRequest.builder().outputName(outputName).outputSettings(outputSettings).build(), callback);
  }

  /**
   * Sets the settings of an output.
   *
   * @param outputName Output name
   * @param outputSettings Output settings
   * @param timeout long timeout in ms
   * @return the SetOutputSettingsResponse, null if the request timed out
   */
  public SetOutputSettingsResponse setOutputSettings(String outputName, JsonObject outputSettings,
      long timeout) {
    BlockingConsumer<SetOutputSettingsResponse> callback = new BlockingConsumer<SetOutputSettingsResponse>();
    this.sendRequest(SetOutputSettingsRequest.builder().outputName(outputName).outputSettings(outputSettings).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the status of the record output.
   *
   * @param callback Consumer&lt;GetRecordStatusResponse&gt;
   */
  public void getRecordStatus(Consumer<GetRecordStatusResponse> callback) {
    this.sendRequest(GetRecordStatusRequest.builder().build(), callback);
  }

  /**
   * Gets the status of the record output.
   *
   * @param timeout long timeout in ms
   * @return the GetRecordStatusResponse, null if the request timed out
   */
  public GetRecordStatusResponse getRecordStatus(long timeout) {
    BlockingConsumer<GetRecordStatusResponse> callback = new BlockingConsumer<GetRecordStatusResponse>();
    this.sendRequest(GetRecordStatusRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Toggles the status of the record output.
   *
   * @param callback Consumer&lt;ToggleRecordResponse&gt;
   */
  public void toggleRecord(Consumer<ToggleRecordResponse> callback) {
    this.sendRequest(ToggleRecordRequest.builder().build(), callback);
  }

  /**
   * Toggles the status of the record output.
   *
   * @param timeout long timeout in ms
   * @return the ToggleRecordResponse, null if the request timed out
   */
  public ToggleRecordResponse toggleRecord(long timeout) {
    BlockingConsumer<ToggleRecordResponse> callback = new BlockingConsumer<ToggleRecordResponse>();
    this.sendRequest(ToggleRecordRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Starts the record output.
   *
   * @param callback Consumer&lt;StartRecordResponse&gt;
   */
  public void startRecord(Consumer<StartRecordResponse> callback) {
    this.sendRequest(StartRecordRequest.builder().build(), callback);
  }

  /**
   * Starts the record output.
   *
   * @param timeout long timeout in ms
   * @return the StartRecordResponse, null if the request timed out
   */
  public StartRecordResponse startRecord(long timeout) {
    BlockingConsumer<StartRecordResponse> callback = new BlockingConsumer<StartRecordResponse>();
    this.sendRequest(StartRecordRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Stops the record output.
   *
   * @param callback Consumer&lt;StopRecordResponse&gt;
   */
  public void stopRecord(Consumer<StopRecordResponse> callback) {
    this.sendRequest(StopRecordRequest.builder().build(), callback);
  }

  /**
   * Stops the record output.
   *
   * @param timeout long timeout in ms
   * @return the StopRecordResponse, null if the request timed out
   */
  public StopRecordResponse stopRecord(long timeout) {
    BlockingConsumer<StopRecordResponse> callback = new BlockingConsumer<StopRecordResponse>();
    this.sendRequest(StopRecordRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Toggles pause on the record output.
   *
   * @param callback Consumer&lt;ToggleRecordPauseResponse&gt;
   */
  public void toggleRecordPause(Consumer<ToggleRecordPauseResponse> callback) {
    this.sendRequest(ToggleRecordPauseRequest.builder().build(), callback);
  }

  /**
   * Toggles pause on the record output.
   *
   * @param timeout long timeout in ms
   * @return the ToggleRecordPauseResponse, null if the request timed out
   */
  public ToggleRecordPauseResponse toggleRecordPause(long timeout) {
    BlockingConsumer<ToggleRecordPauseResponse> callback = new BlockingConsumer<ToggleRecordPauseResponse>();
    this.sendRequest(ToggleRecordPauseRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Pauses the record output.
   *
   * @param callback Consumer&lt;PauseRecordResponse&gt;
   */
  public void pauseRecord(Consumer<PauseRecordResponse> callback) {
    this.sendRequest(PauseRecordRequest.builder().build(), callback);
  }

  /**
   * Pauses the record output.
   *
   * @param timeout long timeout in ms
   * @return the PauseRecordResponse, null if the request timed out
   */
  public PauseRecordResponse pauseRecord(long timeout) {
    BlockingConsumer<PauseRecordResponse> callback = new BlockingConsumer<PauseRecordResponse>();
    this.sendRequest(PauseRecordRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Resumes the record output.
   *
   * @param callback Consumer&lt;ResumeRecordResponse&gt;
   */
  public void resumeRecord(Consumer<ResumeRecordResponse> callback) {
    this.sendRequest(ResumeRecordRequest.builder().build(), callback);
  }

  /**
   * Resumes the record output.
   *
   * @param timeout long timeout in ms
   * @return the ResumeRecordResponse, null if the request timed out
   */
  public ResumeRecordResponse resumeRecord(long timeout) {
    BlockingConsumer<ResumeRecordResponse> callback = new BlockingConsumer<ResumeRecordResponse>();
    this.sendRequest(ResumeRecordRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets a list of all scene items in a scene.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene to get the items of
   * @param callback Consumer&lt;GetSceneItemListResponse&gt;
   */
  public void getSceneItemList(String sceneName, Consumer<GetSceneItemListResponse> callback) {
    this.sendRequest(GetSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Gets a list of all scene items in a scene.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene to get the items of
   * @param timeout long timeout in ms
   * @return the GetSceneItemListResponse, null if the request timed out
   */
  public GetSceneItemListResponse getSceneItemList(String sceneName, long timeout) {
    BlockingConsumer<GetSceneItemListResponse> callback = new BlockingConsumer<GetSceneItemListResponse>();
    this.sendRequest(GetSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Basically GetSceneItemList, but for groups.
   *
   * Using groups at all in OBS is discouraged, as they are very broken under the hood. Please use nested scenes instead.
   *
   * Groups only
   *
   * @param sceneName Name of the group to get the items of
   * @param callback Consumer&lt;GetGroupSceneItemListResponse&gt;
   */
  public void getGroupSceneItemList(String sceneName,
      Consumer<GetGroupSceneItemListResponse> callback) {
    this.sendRequest(GetGroupSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Basically GetSceneItemList, but for groups.
   *
   * Using groups at all in OBS is discouraged, as they are very broken under the hood. Please use nested scenes instead.
   *
   * Groups only
   *
   * @param sceneName Name of the group to get the items of
   * @param timeout long timeout in ms
   * @return the GetGroupSceneItemListResponse, null if the request timed out
   */
  public GetGroupSceneItemListResponse getGroupSceneItemList(String sceneName, long timeout) {
    BlockingConsumer<GetGroupSceneItemListResponse> callback = new BlockingConsumer<GetGroupSceneItemListResponse>();
    this.sendRequest(GetGroupSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Searches a scene for a source, and returns its id.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene or group to search in
   * @param sourceName Name of the source to find
   * @param searchOffset Number of matches to skip during search. &gt;= 0 means first forward. -1 means last (top) item
   * @param callback Consumer&lt;GetSceneItemIdResponse&gt;
   */
  public void getSceneItemId(String sceneName, String sourceName, Number searchOffset,
      Consumer<GetSceneItemIdResponse> callback) {
    this.sendRequest(GetSceneItemIdRequest.builder().sceneName(sceneName).sourceName(sourceName).searchOffset(searchOffset).build(), callback);
  }

  /**
   * Searches a scene for a source, and returns its id.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene or group to search in
   * @param sourceName Name of the source to find
   * @param searchOffset Number of matches to skip during search. &gt;= 0 means first forward. -1 means last (top) item
   * @param timeout long timeout in ms
   * @return the GetSceneItemIdResponse, null if the request timed out
   */
  public GetSceneItemIdResponse getSceneItemId(String sceneName, String sourceName,
      Number searchOffset, long timeout) {
    BlockingConsumer<GetSceneItemIdResponse> callback = new BlockingConsumer<GetSceneItemIdResponse>();
    this.sendRequest(GetSceneItemIdRequest.builder().sceneName(sceneName).sourceName(sourceName).searchOffset(searchOffset).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Creates a new scene item using a source.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene to create the new item in
   * @param sourceName Name of the source to add to the scene
   * @param sceneItemEnabled Enable state to apply to the scene item on creation
   * @param callback Consumer&lt;CreateSceneItemResponse&gt;
   */
  public void createSceneItem(String sceneName, String sourceName, Boolean sceneItemEnabled,
      Consumer<CreateSceneItemResponse> callback) {
    this.sendRequest(CreateSceneItemRequest.builder().sceneName(sceneName).sourceName(sourceName).sceneItemEnabled(sceneItemEnabled).build(), callback);
  }

  /**
   * Creates a new scene item using a source.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene to create the new item in
   * @param sourceName Name of the source to add to the scene
   * @param sceneItemEnabled Enable state to apply to the scene item on creation
   * @param timeout long timeout in ms
   * @return the CreateSceneItemResponse, null if the request timed out
   */
  public CreateSceneItemResponse createSceneItem(String sceneName, String sourceName,
      Boolean sceneItemEnabled, long timeout) {
    BlockingConsumer<CreateSceneItemResponse> callback = new BlockingConsumer<CreateSceneItemResponse>();
    this.sendRequest(CreateSceneItemRequest.builder().sceneName(sceneName).sourceName(sourceName).sceneItemEnabled(sceneItemEnabled).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Removes a scene item from a scene.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param callback Consumer&lt;RemoveSceneItemResponse&gt;
   */
  public void removeSceneItem(String sceneName, Number sceneItemId,
      Consumer<RemoveSceneItemResponse> callback) {
    this.sendRequest(RemoveSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Removes a scene item from a scene.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param timeout long timeout in ms
   * @return the RemoveSceneItemResponse, null if the request timed out
   */
  public RemoveSceneItemResponse removeSceneItem(String sceneName, Number sceneItemId,
      long timeout) {
    BlockingConsumer<RemoveSceneItemResponse> callback = new BlockingConsumer<RemoveSceneItemResponse>();
    this.sendRequest(RemoveSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Duplicates a scene item, copying all transform and crop info.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param destinationSceneName Name of the scene to create the duplicated item in
   * @param callback Consumer&lt;DuplicateSceneItemResponse&gt;
   */
  public void duplicateSceneItem(String sceneName, Number sceneItemId, String destinationSceneName,
      Consumer<DuplicateSceneItemResponse> callback) {
    this.sendRequest(DuplicateSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).destinationSceneName(destinationSceneName).build(), callback);
  }

  /**
   * Duplicates a scene item, copying all transform and crop info.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param destinationSceneName Name of the scene to create the duplicated item in
   * @param timeout long timeout in ms
   * @return the DuplicateSceneItemResponse, null if the request timed out
   */
  public DuplicateSceneItemResponse duplicateSceneItem(String sceneName, Number sceneItemId,
      String destinationSceneName, long timeout) {
    BlockingConsumer<DuplicateSceneItemResponse> callback = new BlockingConsumer<DuplicateSceneItemResponse>();
    this.sendRequest(DuplicateSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).destinationSceneName(destinationSceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the transform and crop info of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param callback Consumer&lt;GetSceneItemTransformResponse&gt;
   */
  public void getSceneItemTransform(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemTransformResponse> callback) {
    this.sendRequest(GetSceneItemTransformRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Gets the transform and crop info of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param timeout long timeout in ms
   * @return the GetSceneItemTransformResponse, null if the request timed out
   */
  public GetSceneItemTransformResponse getSceneItemTransform(String sceneName, Number sceneItemId,
      long timeout) {
    BlockingConsumer<GetSceneItemTransformResponse> callback = new BlockingConsumer<GetSceneItemTransformResponse>();
    this.sendRequest(GetSceneItemTransformRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the transform and crop info of a scene item.
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemTransform Object containing scene item transform info to update
   * @param callback Consumer&lt;SetSceneItemTransformResponse&gt;
   */
  public void setSceneItemTransform(String sceneName, Number sceneItemId,
      SceneItem.Transform sceneItemTransform, Consumer<SetSceneItemTransformResponse> callback) {
    this.sendRequest(SetSceneItemTransformRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemTransform(sceneItemTransform).build(), callback);
  }

  /**
   * Sets the transform and crop info of a scene item.
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemTransform Object containing scene item transform info to update
   * @param timeout long timeout in ms
   * @return the SetSceneItemTransformResponse, null if the request timed out
   */
  public SetSceneItemTransformResponse setSceneItemTransform(String sceneName, Number sceneItemId,
      SceneItem.Transform sceneItemTransform, long timeout) {
    BlockingConsumer<SetSceneItemTransformResponse> callback = new BlockingConsumer<SetSceneItemTransformResponse>();
    this.sendRequest(SetSceneItemTransformRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemTransform(sceneItemTransform).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the enable state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param callback Consumer&lt;GetSceneItemEnabledResponse&gt;
   */
  public void getSceneItemEnabled(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemEnabledResponse> callback) {
    this.sendRequest(GetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Gets the enable state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param timeout long timeout in ms
   * @return the GetSceneItemEnabledResponse, null if the request timed out
   */
  public GetSceneItemEnabledResponse getSceneItemEnabled(String sceneName, Number sceneItemId,
      long timeout) {
    BlockingConsumer<GetSceneItemEnabledResponse> callback = new BlockingConsumer<GetSceneItemEnabledResponse>();
    this.sendRequest(GetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the enable state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemEnabled New enable state of the scene item
   * @param callback Consumer&lt;SetSceneItemEnabledResponse&gt;
   */
  public void setSceneItemEnabled(String sceneName, Number sceneItemId, Boolean sceneItemEnabled,
      Consumer<SetSceneItemEnabledResponse> callback) {
    this.sendRequest(SetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemEnabled(sceneItemEnabled).build(), callback);
  }

  /**
   * Sets the enable state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemEnabled New enable state of the scene item
   * @param timeout long timeout in ms
   * @return the SetSceneItemEnabledResponse, null if the request timed out
   */
  public SetSceneItemEnabledResponse setSceneItemEnabled(String sceneName, Number sceneItemId,
      Boolean sceneItemEnabled, long timeout) {
    BlockingConsumer<SetSceneItemEnabledResponse> callback = new BlockingConsumer<SetSceneItemEnabledResponse>();
    this.sendRequest(SetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemEnabled(sceneItemEnabled).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the lock state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param callback Consumer&lt;GetSceneItemLockedResponse&gt;
   */
  public void getSceneItemLocked(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemLockedResponse> callback) {
    this.sendRequest(GetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Gets the lock state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param timeout long timeout in ms
   * @return the GetSceneItemLockedResponse, null if the request timed out
   */
  public GetSceneItemLockedResponse getSceneItemLocked(String sceneName, Number sceneItemId,
      long timeout) {
    BlockingConsumer<GetSceneItemLockedResponse> callback = new BlockingConsumer<GetSceneItemLockedResponse>();
    this.sendRequest(GetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the lock state of a scene item.
   *
   * Scenes and Group
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemLocked New lock state of the scene item
   * @param callback Consumer&lt;SetSceneItemLockedResponse&gt;
   */
  public void setSceneItemLocked(String sceneName, Number sceneItemId, Boolean sceneItemLocked,
      Consumer<SetSceneItemLockedResponse> callback) {
    this.sendRequest(SetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemLocked(sceneItemLocked).build(), callback);
  }

  /**
   * Sets the lock state of a scene item.
   *
   * Scenes and Group
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemLocked New lock state of the scene item
   * @param timeout long timeout in ms
   * @return the SetSceneItemLockedResponse, null if the request timed out
   */
  public SetSceneItemLockedResponse setSceneItemLocked(String sceneName, Number sceneItemId,
      Boolean sceneItemLocked, long timeout) {
    BlockingConsumer<SetSceneItemLockedResponse> callback = new BlockingConsumer<SetSceneItemLockedResponse>();
    this.sendRequest(SetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemLocked(sceneItemLocked).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the index position of a scene item in a scene.
   *
   * An index of 0 is at the bottom of the source list in the UI.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param callback Consumer&lt;GetSceneItemIndexResponse&gt;
   */
  public void getSceneItemIndex(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemIndexResponse> callback) {
    this.sendRequest(GetSceneItemIndexRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Gets the index position of a scene item in a scene.
   *
   * An index of 0 is at the bottom of the source list in the UI.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param timeout long timeout in ms
   * @return the GetSceneItemIndexResponse, null if the request timed out
   */
  public GetSceneItemIndexResponse getSceneItemIndex(String sceneName, Number sceneItemId,
      long timeout) {
    BlockingConsumer<GetSceneItemIndexResponse> callback = new BlockingConsumer<GetSceneItemIndexResponse>();
    this.sendRequest(GetSceneItemIndexRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the index position of a scene item in a scene.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemIndex New index position of the scene item
   * @param callback Consumer&lt;SetSceneItemIndexResponse&gt;
   */
  public void setSceneItemIndex(String sceneName, Number sceneItemId, Number sceneItemIndex,
      Consumer<SetSceneItemIndexResponse> callback) {
    this.sendRequest(SetSceneItemIndexRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemIndex(sceneItemIndex).build(), callback);
  }

  /**
   * Sets the index position of a scene item in a scene.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemIndex New index position of the scene item
   * @param timeout long timeout in ms
   * @return the SetSceneItemIndexResponse, null if the request timed out
   */
  public SetSceneItemIndexResponse setSceneItemIndex(String sceneName, Number sceneItemId,
      Number sceneItemIndex, long timeout) {
    BlockingConsumer<SetSceneItemIndexResponse> callback = new BlockingConsumer<SetSceneItemIndexResponse>();
    this.sendRequest(SetSceneItemIndexRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemIndex(sceneItemIndex).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the blend mode of a scene item.
   *
   * Blend modes:
   *
   * - `OBS_BLEND_NORMAL`
   * - `OBS_BLEND_ADDITIVE`
   * - `OBS_BLEND_SUBTRACT`
   * - `OBS_BLEND_SCREEN`
   * - `OBS_BLEND_MULTIPLY`
   * - `OBS_BLEND_LIGHTEN`
   * - `OBS_BLEND_DARKEN`
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param callback Consumer&lt;GetSceneItemBlendModeResponse&gt;
   */
  public void getSceneItemBlendMode(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemBlendModeResponse> callback) {
    this.sendRequest(GetSceneItemBlendModeRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Gets the blend mode of a scene item.
   *
   * Blend modes:
   *
   * - `OBS_BLEND_NORMAL`
   * - `OBS_BLEND_ADDITIVE`
   * - `OBS_BLEND_SUBTRACT`
   * - `OBS_BLEND_SCREEN`
   * - `OBS_BLEND_MULTIPLY`
   * - `OBS_BLEND_LIGHTEN`
   * - `OBS_BLEND_DARKEN`
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param timeout long timeout in ms
   * @return the GetSceneItemBlendModeResponse, null if the request timed out
   */
  public GetSceneItemBlendModeResponse getSceneItemBlendMode(String sceneName, Number sceneItemId,
      long timeout) {
    BlockingConsumer<GetSceneItemBlendModeResponse> callback = new BlockingConsumer<GetSceneItemBlendModeResponse>();
    this.sendRequest(GetSceneItemBlendModeRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the blend mode of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemBlendMode New blend mode
   * @param callback Consumer&lt;SetSceneItemBlendModeResponse&gt;
   */
  public void setSceneItemBlendMode(String sceneName, Number sceneItemId,
      SceneItem.BlendMode sceneItemBlendMode, Consumer<SetSceneItemBlendModeResponse> callback) {
    this.sendRequest(SetSceneItemBlendModeRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemBlendMode(sceneItemBlendMode).build(), callback);
  }

  /**
   * Sets the blend mode of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemBlendMode New blend mode
   * @param timeout long timeout in ms
   * @return the SetSceneItemBlendModeResponse, null if the request timed out
   */
  public SetSceneItemBlendModeResponse setSceneItemBlendMode(String sceneName, Number sceneItemId,
      SceneItem.BlendMode sceneItemBlendMode, long timeout) {
    BlockingConsumer<SetSceneItemBlendModeResponse> callback = new BlockingConsumer<SetSceneItemBlendModeResponse>();
    this.sendRequest(SetSceneItemBlendModeRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemBlendMode(sceneItemBlendMode).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all scenes in OBS.
   *
   * @param callback Consumer&lt;GetSceneListResponse&gt;
   */
  public void getSceneList(Consumer<GetSceneListResponse> callback) {
    this.sendRequest(GetSceneListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all scenes in OBS.
   *
   * @param timeout long timeout in ms
   * @return the GetSceneListResponse, null if the request timed out
   */
  public GetSceneListResponse getSceneList(long timeout) {
    BlockingConsumer<GetSceneListResponse> callback = new BlockingConsumer<GetSceneListResponse>();
    this.sendRequest(GetSceneListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all groups in OBS.
   *
   * Groups in OBS are actually scenes, but renamed and modified. In obs-websocket, we treat them as scenes where we can.
   *
   * @param callback Consumer&lt;GetGroupListResponse&gt;
   */
  public void getGroupList(Consumer<GetGroupListResponse> callback) {
    this.sendRequest(GetGroupListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all groups in OBS.
   *
   * Groups in OBS are actually scenes, but renamed and modified. In obs-websocket, we treat them as scenes where we can.
   *
   * @param timeout long timeout in ms
   * @return the GetGroupListResponse, null if the request timed out
   */
  public GetGroupListResponse getGroupList(long timeout) {
    BlockingConsumer<GetGroupListResponse> callback = new BlockingConsumer<GetGroupListResponse>();
    this.sendRequest(GetGroupListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the current program scene.
   *
   * @param callback Consumer&lt;GetCurrentProgramSceneResponse&gt;
   */
  public void getCurrentProgramScene(Consumer<GetCurrentProgramSceneResponse> callback) {
    this.sendRequest(GetCurrentProgramSceneRequest.builder().build(), callback);
  }

  /**
   * Gets the current program scene.
   *
   * @param timeout long timeout in ms
   * @return the GetCurrentProgramSceneResponse, null if the request timed out
   */
  public GetCurrentProgramSceneResponse getCurrentProgramScene(long timeout) {
    BlockingConsumer<GetCurrentProgramSceneResponse> callback = new BlockingConsumer<GetCurrentProgramSceneResponse>();
    this.sendRequest(GetCurrentProgramSceneRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the current program scene.
   *
   * @param sceneName Scene to set as the current program scene
   * @param callback Consumer&lt;SetCurrentProgramSceneResponse&gt;
   */
  public void setCurrentProgramScene(String sceneName,
      Consumer<SetCurrentProgramSceneResponse> callback) {
    this.sendRequest(SetCurrentProgramSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Sets the current program scene.
   *
   * @param sceneName Scene to set as the current program scene
   * @param timeout long timeout in ms
   * @return the SetCurrentProgramSceneResponse, null if the request timed out
   */
  public SetCurrentProgramSceneResponse setCurrentProgramScene(String sceneName, long timeout) {
    BlockingConsumer<SetCurrentProgramSceneResponse> callback = new BlockingConsumer<SetCurrentProgramSceneResponse>();
    this.sendRequest(SetCurrentProgramSceneRequest.builder().sceneName(sceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the current preview scene.
   *
   * Only available when studio mode is enabled.
   *
   * @param callback Consumer&lt;GetCurrentPreviewSceneResponse&gt;
   */
  public void getCurrentPreviewScene(Consumer<GetCurrentPreviewSceneResponse> callback) {
    this.sendRequest(GetCurrentPreviewSceneRequest.builder().build(), callback);
  }

  /**
   * Gets the current preview scene.
   *
   * Only available when studio mode is enabled.
   *
   * @param timeout long timeout in ms
   * @return the GetCurrentPreviewSceneResponse, null if the request timed out
   */
  public GetCurrentPreviewSceneResponse getCurrentPreviewScene(long timeout) {
    BlockingConsumer<GetCurrentPreviewSceneResponse> callback = new BlockingConsumer<GetCurrentPreviewSceneResponse>();
    this.sendRequest(GetCurrentPreviewSceneRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the current preview scene.
   *
   * Only available when studio mode is enabled.
   *
   * @param sceneName Scene to set as the current preview scene
   * @param callback Consumer&lt;SetCurrentPreviewSceneResponse&gt;
   */
  public void setCurrentPreviewScene(String sceneName,
      Consumer<SetCurrentPreviewSceneResponse> callback) {
    this.sendRequest(SetCurrentPreviewSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Sets the current preview scene.
   *
   * Only available when studio mode is enabled.
   *
   * @param sceneName Scene to set as the current preview scene
   * @param timeout long timeout in ms
   * @return the SetCurrentPreviewSceneResponse, null if the request timed out
   */
  public SetCurrentPreviewSceneResponse setCurrentPreviewScene(String sceneName, long timeout) {
    BlockingConsumer<SetCurrentPreviewSceneResponse> callback = new BlockingConsumer<SetCurrentPreviewSceneResponse>();
    this.sendRequest(SetCurrentPreviewSceneRequest.builder().sceneName(sceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Creates a new scene in OBS.
   *
   * @param sceneName Name for the new scene
   * @param callback Consumer&lt;CreateSceneResponse&gt;
   */
  public void createScene(String sceneName, Consumer<CreateSceneResponse> callback) {
    this.sendRequest(CreateSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Creates a new scene in OBS.
   *
   * @param sceneName Name for the new scene
   * @param timeout long timeout in ms
   * @return the CreateSceneResponse, null if the request timed out
   */
  public CreateSceneResponse createScene(String sceneName, long timeout) {
    BlockingConsumer<CreateSceneResponse> callback = new BlockingConsumer<CreateSceneResponse>();
    this.sendRequest(CreateSceneRequest.builder().sceneName(sceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Removes a scene from OBS.
   *
   * @param sceneName Name of the scene to remove
   * @param callback Consumer&lt;RemoveSceneResponse&gt;
   */
  public void removeScene(String sceneName, Consumer<RemoveSceneResponse> callback) {
    this.sendRequest(RemoveSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Removes a scene from OBS.
   *
   * @param sceneName Name of the scene to remove
   * @param timeout long timeout in ms
   * @return the RemoveSceneResponse, null if the request timed out
   */
  public RemoveSceneResponse removeScene(String sceneName, long timeout) {
    BlockingConsumer<RemoveSceneResponse> callback = new BlockingConsumer<RemoveSceneResponse>();
    this.sendRequest(RemoveSceneRequest.builder().sceneName(sceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the name of a scene (rename).
   *
   * @param sceneName Name of the scene to be renamed
   * @param newSceneName New name for the scene
   * @param callback Consumer&lt;SetSceneNameResponse&gt;
   */
  public void setSceneName(String sceneName, String newSceneName,
      Consumer<SetSceneNameResponse> callback) {
    this.sendRequest(SetSceneNameRequest.builder().sceneName(sceneName).newSceneName(newSceneName).build(), callback);
  }

  /**
   * Sets the name of a scene (rename).
   *
   * @param sceneName Name of the scene to be renamed
   * @param newSceneName New name for the scene
   * @param timeout long timeout in ms
   * @return the SetSceneNameResponse, null if the request timed out
   */
  public SetSceneNameResponse setSceneName(String sceneName, String newSceneName, long timeout) {
    BlockingConsumer<SetSceneNameResponse> callback = new BlockingConsumer<SetSceneNameResponse>();
    this.sendRequest(SetSceneNameRequest.builder().sceneName(sceneName).newSceneName(newSceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the scene transition overridden for a scene.
   *
   * @param sceneName Name of the scene
   * @param callback Consumer&lt;GetSceneSceneTransitionOverrideResponse&gt;
   */
  public void getSceneSceneTransitionOverride(String sceneName,
      Consumer<GetSceneSceneTransitionOverrideResponse> callback) {
    this.sendRequest(GetSceneSceneTransitionOverrideRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Gets the scene transition overridden for a scene.
   *
   * @param sceneName Name of the scene
   * @param timeout long timeout in ms
   * @return the GetSceneSceneTransitionOverrideResponse, null if the request timed out
   */
  public GetSceneSceneTransitionOverrideResponse getSceneSceneTransitionOverride(String sceneName,
      long timeout) {
    BlockingConsumer<GetSceneSceneTransitionOverrideResponse> callback = new BlockingConsumer<GetSceneSceneTransitionOverrideResponse>();
    this.sendRequest(GetSceneSceneTransitionOverrideRequest.builder().sceneName(sceneName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the scene transition overridden for a scene.
   *
   * @param sceneName Name of the scene
   * @param transitionName Name of the scene transition to use as override. Specify `null` to remove
   * @param transitionDuration Duration to use for any overridden transition. Specify `null` to remove
   * @param callback Consumer&lt;SetSceneSceneTransitionOverrideResponse&gt;
   */
  public void setSceneSceneTransitionOverride(String sceneName, String transitionName,
      Number transitionDuration, Consumer<SetSceneSceneTransitionOverrideResponse> callback) {
    this.sendRequest(SetSceneSceneTransitionOverrideRequest.builder().sceneName(sceneName).transitionName(transitionName).transitionDuration(transitionDuration).build(), callback);
  }

  /**
   * Gets the scene transition overridden for a scene.
   *
   * @param sceneName Name of the scene
   * @param transitionName Name of the scene transition to use as override. Specify `null` to remove
   * @param transitionDuration Duration to use for any overridden transition. Specify `null` to remove
   * @param timeout long timeout in ms
   * @return the SetSceneSceneTransitionOverrideResponse, null if the request timed out
   */
  public SetSceneSceneTransitionOverrideResponse setSceneSceneTransitionOverride(String sceneName,
      String transitionName, Number transitionDuration, long timeout) {
    BlockingConsumer<SetSceneSceneTransitionOverrideResponse> callback = new BlockingConsumer<SetSceneSceneTransitionOverrideResponse>();
    this.sendRequest(SetSceneSceneTransitionOverrideRequest.builder().sceneName(sceneName).transitionName(transitionName).transitionDuration(transitionDuration).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the active and show state of a source.
   *
   * **Compatible with inputs and scenes.**
   *
   * @param sourceName Name of the source to get the active state of
   * @param callback Consumer&lt;GetSourceActiveResponse&gt;
   */
  public void getSourceActive(String sourceName, Consumer<GetSourceActiveResponse> callback) {
    this.sendRequest(GetSourceActiveRequest.builder().sourceName(sourceName).build(), callback);
  }

  /**
   * Gets the active and show state of a source.
   *
   * **Compatible with inputs and scenes.**
   *
   * @param sourceName Name of the source to get the active state of
   * @param timeout long timeout in ms
   * @return the GetSourceActiveResponse, null if the request timed out
   */
  public GetSourceActiveResponse getSourceActive(String sourceName, long timeout) {
    BlockingConsumer<GetSourceActiveResponse> callback = new BlockingConsumer<GetSourceActiveResponse>();
    this.sendRequest(GetSourceActiveRequest.builder().sourceName(sourceName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets a Base64-encoded screenshot of a source.
   *
   * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
   * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
   *
   * **Compatible with inputs and scenes.**
   *
   * @param sourceName Name of the source to take a screenshot of
   * @param imageFormat Image compression format to use. Use `GetVersion` to get compatible image formats
   * @param imageWidth Width to scale the screenshot to
   * @param imageHeight Height to scale the screenshot to
   * @param imageCompressionQuality Compression quality to use. 0 for high compression, 100 for uncompressed. -1 to use "default" (whatever that means, idk)
   * @param callback Consumer&lt;GetSourceScreenshotResponse&gt;
   */
  public void getSourceScreenshot(String sourceName, String imageFormat, Number imageWidth,
      Number imageHeight, Number imageCompressionQuality,
      Consumer<GetSourceScreenshotResponse> callback) {
    this.sendRequest(GetSourceScreenshotRequest.builder().sourceName(sourceName).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build(), callback);
  }

  /**
   * Gets a Base64-encoded screenshot of a source.
   *
   * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
   * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
   *
   * **Compatible with inputs and scenes.**
   *
   * @param sourceName Name of the source to take a screenshot of
   * @param imageFormat Image compression format to use. Use `GetVersion` to get compatible image formats
   * @param imageWidth Width to scale the screenshot to
   * @param imageHeight Height to scale the screenshot to
   * @param imageCompressionQuality Compression quality to use. 0 for high compression, 100 for uncompressed. -1 to use "default" (whatever that means, idk)
   * @param timeout long timeout in ms
   * @return the GetSourceScreenshotResponse, null if the request timed out
   */
  public GetSourceScreenshotResponse getSourceScreenshot(String sourceName, String imageFormat,
      Number imageWidth, Number imageHeight, Number imageCompressionQuality, long timeout) {
    BlockingConsumer<GetSourceScreenshotResponse> callback = new BlockingConsumer<GetSourceScreenshotResponse>();
    this.sendRequest(GetSourceScreenshotRequest.builder().sourceName(sourceName).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Saves a screenshot of a source to the filesystem.
   *
   * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
   * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
   *
   * **Compatible with inputs and scenes.**
   *
   * @param sourceName Name of the source to take a screenshot of
   * @param imageFormat Image compression format to use. Use `GetVersion` to get compatible image formats
   * @param imageFilePath Path to save the screenshot file to. Eg. `C:\Users\\user\Desktop\screenshot.png`
   * @param imageWidth Width to scale the screenshot to
   * @param imageHeight Height to scale the screenshot to
   * @param imageCompressionQuality Compression quality to use. 0 for high compression, 100 for uncompressed. -1 to use "default" (whatever that means, idk)
   * @param callback Consumer&lt;SaveSourceScreenshotResponse&gt;
   */
  public void saveSourceScreenshot(String sourceName, String imageFormat, String imageFilePath,
      Number imageWidth, Number imageHeight, Number imageCompressionQuality,
      Consumer<SaveSourceScreenshotResponse> callback) {
    this.sendRequest(SaveSourceScreenshotRequest.builder().sourceName(sourceName).imageFormat(imageFormat).imageFilePath(imageFilePath).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build(), callback);
  }

  /**
   * Saves a screenshot of a source to the filesystem.
   *
   * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
   * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
   *
   * **Compatible with inputs and scenes.**
   *
   * @param sourceName Name of the source to take a screenshot of
   * @param imageFormat Image compression format to use. Use `GetVersion` to get compatible image formats
   * @param imageFilePath Path to save the screenshot file to. Eg. `C:\Users\\user\Desktop\screenshot.png`
   * @param imageWidth Width to scale the screenshot to
   * @param imageHeight Height to scale the screenshot to
   * @param imageCompressionQuality Compression quality to use. 0 for high compression, 100 for uncompressed. -1 to use "default" (whatever that means, idk)
   * @param timeout long timeout in ms
   * @return the SaveSourceScreenshotResponse, null if the request timed out
   */
  public SaveSourceScreenshotResponse saveSourceScreenshot(String sourceName, String imageFormat,
      String imageFilePath, Number imageWidth, Number imageHeight, Number imageCompressionQuality,
      long timeout) {
    BlockingConsumer<SaveSourceScreenshotResponse> callback = new BlockingConsumer<SaveSourceScreenshotResponse>();
    this.sendRequest(SaveSourceScreenshotRequest.builder().sourceName(sourceName).imageFormat(imageFormat).imageFilePath(imageFilePath).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the status of the stream output.
   *
   * @param callback Consumer&lt;GetStreamStatusResponse&gt;
   */
  public void getStreamStatus(Consumer<GetStreamStatusResponse> callback) {
    this.sendRequest(GetStreamStatusRequest.builder().build(), callback);
  }

  /**
   * Gets the status of the stream output.
   *
   * @param timeout long timeout in ms
   * @return the GetStreamStatusResponse, null if the request timed out
   */
  public GetStreamStatusResponse getStreamStatus(long timeout) {
    BlockingConsumer<GetStreamStatusResponse> callback = new BlockingConsumer<GetStreamStatusResponse>();
    this.sendRequest(GetStreamStatusRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Toggles the status of the stream output.
   *
   * @param callback Consumer&lt;ToggleStreamResponse&gt;
   */
  public void toggleStream(Consumer<ToggleStreamResponse> callback) {
    this.sendRequest(ToggleStreamRequest.builder().build(), callback);
  }

  /**
   * Toggles the status of the stream output.
   *
   * @param timeout long timeout in ms
   * @return the ToggleStreamResponse, null if the request timed out
   */
  public ToggleStreamResponse toggleStream(long timeout) {
    BlockingConsumer<ToggleStreamResponse> callback = new BlockingConsumer<ToggleStreamResponse>();
    this.sendRequest(ToggleStreamRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Starts the stream output.
   *
   * @param callback Consumer&lt;StartStreamResponse&gt;
   */
  public void startStream(Consumer<StartStreamResponse> callback) {
    this.sendRequest(StartStreamRequest.builder().build(), callback);
  }

  /**
   * Starts the stream output.
   *
   * @param timeout long timeout in ms
   * @return the StartStreamResponse, null if the request timed out
   */
  public StartStreamResponse startStream(long timeout) {
    BlockingConsumer<StartStreamResponse> callback = new BlockingConsumer<StartStreamResponse>();
    this.sendRequest(StartStreamRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Stops the stream output.
   *
   * @param callback Consumer&lt;StopStreamResponse&gt;
   */
  public void stopStream(Consumer<StopStreamResponse> callback) {
    this.sendRequest(StopStreamRequest.builder().build(), callback);
  }

  /**
   * Stops the stream output.
   *
   * @param timeout long timeout in ms
   * @return the StopStreamResponse, null if the request timed out
   */
  public StopStreamResponse stopStream(long timeout) {
    BlockingConsumer<StopStreamResponse> callback = new BlockingConsumer<StopStreamResponse>();
    this.sendRequest(StopStreamRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sends CEA-608 caption text over the stream output.
   *
   * @param captionText Caption text
   * @param callback Consumer&lt;SendStreamCaptionResponse&gt;
   */
  public void sendStreamCaption(String captionText, Consumer<SendStreamCaptionResponse> callback) {
    this.sendRequest(SendStreamCaptionRequest.builder().captionText(captionText).build(), callback);
  }

  /**
   * Sends CEA-608 caption text over the stream output.
   *
   * @param captionText Caption text
   * @param timeout long timeout in ms
   * @return the SendStreamCaptionResponse, null if the request timed out
   */
  public SendStreamCaptionResponse sendStreamCaption(String captionText, long timeout) {
    BlockingConsumer<SendStreamCaptionResponse> callback = new BlockingConsumer<SendStreamCaptionResponse>();
    this.sendRequest(SendStreamCaptionRequest.builder().captionText(captionText).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all available transition kinds.
   *
   * Similar to `GetInputKindList`
   *
   * @param callback Consumer&lt;GetTransitionKindListResponse&gt;
   */
  public void getTransitionKindList(Consumer<GetTransitionKindListResponse> callback) {
    this.sendRequest(GetTransitionKindListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all available transition kinds.
   *
   * Similar to `GetInputKindList`
   *
   * @param timeout long timeout in ms
   * @return the GetTransitionKindListResponse, null if the request timed out
   */
  public GetTransitionKindListResponse getTransitionKindList(long timeout) {
    BlockingConsumer<GetTransitionKindListResponse> callback = new BlockingConsumer<GetTransitionKindListResponse>();
    this.sendRequest(GetTransitionKindListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets an array of all scene transitions in OBS.
   *
   * @param callback Consumer&lt;GetSceneTransitionListResponse&gt;
   */
  public void getSceneTransitionList(Consumer<GetSceneTransitionListResponse> callback) {
    this.sendRequest(GetSceneTransitionListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all scene transitions in OBS.
   *
   * @param timeout long timeout in ms
   * @return the GetSceneTransitionListResponse, null if the request timed out
   */
  public GetSceneTransitionListResponse getSceneTransitionList(long timeout) {
    BlockingConsumer<GetSceneTransitionListResponse> callback = new BlockingConsumer<GetSceneTransitionListResponse>();
    this.sendRequest(GetSceneTransitionListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets information about the current scene transition.
   *
   * @param callback Consumer&lt;GetCurrentSceneTransitionResponse&gt;
   */
  public void getCurrentSceneTransition(Consumer<GetCurrentSceneTransitionResponse> callback) {
    this.sendRequest(GetCurrentSceneTransitionRequest.builder().build(), callback);
  }

  /**
   * Gets information about the current scene transition.
   *
   * @param timeout long timeout in ms
   * @return the GetCurrentSceneTransitionResponse, null if the request timed out
   */
  public GetCurrentSceneTransitionResponse getCurrentSceneTransition(long timeout) {
    BlockingConsumer<GetCurrentSceneTransitionResponse> callback = new BlockingConsumer<GetCurrentSceneTransitionResponse>();
    this.sendRequest(GetCurrentSceneTransitionRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the current scene transition.
   *
   * Small note: While the namespace of scene transitions is generally unique, that uniqueness is not a guarantee as it is with other resources like inputs.
   *
   * @param transitionName Name of the transition to make active
   * @param callback Consumer&lt;SetCurrentSceneTransitionResponse&gt;
   */
  public void setCurrentSceneTransition(String transitionName,
      Consumer<SetCurrentSceneTransitionResponse> callback) {
    this.sendRequest(SetCurrentSceneTransitionRequest.builder().transitionName(transitionName).build(), callback);
  }

  /**
   * Sets the current scene transition.
   *
   * Small note: While the namespace of scene transitions is generally unique, that uniqueness is not a guarantee as it is with other resources like inputs.
   *
   * @param transitionName Name of the transition to make active
   * @param timeout long timeout in ms
   * @return the SetCurrentSceneTransitionResponse, null if the request timed out
   */
  public SetCurrentSceneTransitionResponse setCurrentSceneTransition(String transitionName,
      long timeout) {
    BlockingConsumer<SetCurrentSceneTransitionResponse> callback = new BlockingConsumer<SetCurrentSceneTransitionResponse>();
    this.sendRequest(SetCurrentSceneTransitionRequest.builder().transitionName(transitionName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the duration of the current scene transition, if it is not fixed.
   *
   * @param transitionDuration Duration in milliseconds
   * @param callback Consumer&lt;SetCurrentSceneTransitionDurationResponse&gt;
   */
  public void setCurrentSceneTransitionDuration(Number transitionDuration,
      Consumer<SetCurrentSceneTransitionDurationResponse> callback) {
    this.sendRequest(SetCurrentSceneTransitionDurationRequest.builder().transitionDuration(transitionDuration).build(), callback);
  }

  /**
   * Sets the duration of the current scene transition, if it is not fixed.
   *
   * @param transitionDuration Duration in milliseconds
   * @param timeout long timeout in ms
   * @return the SetCurrentSceneTransitionDurationResponse, null if the request timed out
   */
  public SetCurrentSceneTransitionDurationResponse setCurrentSceneTransitionDuration(
      Number transitionDuration, long timeout) {
    BlockingConsumer<SetCurrentSceneTransitionDurationResponse> callback = new BlockingConsumer<SetCurrentSceneTransitionDurationResponse>();
    this.sendRequest(SetCurrentSceneTransitionDurationRequest.builder().transitionDuration(transitionDuration).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the settings of the current scene transition.
   *
   * @param transitionSettings Settings object to apply to the transition. Can be `{}`
   * @param overlay Whether to overlay over the current settings or replace them
   * @param callback Consumer&lt;SetCurrentSceneTransitionSettingsResponse&gt;
   */
  public void setCurrentSceneTransitionSettings(JsonObject transitionSettings, Boolean overlay,
      Consumer<SetCurrentSceneTransitionSettingsResponse> callback) {
    this.sendRequest(SetCurrentSceneTransitionSettingsRequest.builder().transitionSettings(transitionSettings).overlay(overlay).build(), callback);
  }

  /**
   * Sets the settings of the current scene transition.
   *
   * @param transitionSettings Settings object to apply to the transition. Can be `{}`
   * @param overlay Whether to overlay over the current settings or replace them
   * @param timeout long timeout in ms
   * @return the SetCurrentSceneTransitionSettingsResponse, null if the request timed out
   */
  public SetCurrentSceneTransitionSettingsResponse setCurrentSceneTransitionSettings(
      JsonObject transitionSettings, Boolean overlay, long timeout) {
    BlockingConsumer<SetCurrentSceneTransitionSettingsResponse> callback = new BlockingConsumer<SetCurrentSceneTransitionSettingsResponse>();
    this.sendRequest(SetCurrentSceneTransitionSettingsRequest.builder().transitionSettings(transitionSettings).overlay(overlay).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets the cursor position of the current scene transition.
   *
   * Note: `transitionCursor` will return 1.0 when the transition is inactive.
   *
   * @param callback Consumer&lt;GetCurrentSceneTransitionCursorResponse&gt;
   */
  public void getCurrentSceneTransitionCursor(
      Consumer<GetCurrentSceneTransitionCursorResponse> callback) {
    this.sendRequest(GetCurrentSceneTransitionCursorRequest.builder().build(), callback);
  }

  /**
   * Gets the cursor position of the current scene transition.
   *
   * Note: `transitionCursor` will return 1.0 when the transition is inactive.
   *
   * @param timeout long timeout in ms
   * @return the GetCurrentSceneTransitionCursorResponse, null if the request timed out
   */
  public GetCurrentSceneTransitionCursorResponse getCurrentSceneTransitionCursor(long timeout) {
    BlockingConsumer<GetCurrentSceneTransitionCursorResponse> callback = new BlockingConsumer<GetCurrentSceneTransitionCursorResponse>();
    this.sendRequest(GetCurrentSceneTransitionCursorRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Triggers the current scene transition. Same functionality as the `Transition` button in studio mode.
   *
   * @param callback Consumer&lt;TriggerStudioModeTransitionResponse&gt;
   */
  public void triggerStudioModeTransition(Consumer<TriggerStudioModeTransitionResponse> callback) {
    this.sendRequest(TriggerStudioModeTransitionRequest.builder().build(), callback);
  }

  /**
   * Triggers the current scene transition. Same functionality as the `Transition` button in studio mode.
   *
   * @param timeout long timeout in ms
   * @return the TriggerStudioModeTransitionResponse, null if the request timed out
   */
  public TriggerStudioModeTransitionResponse triggerStudioModeTransition(long timeout) {
    BlockingConsumer<TriggerStudioModeTransitionResponse> callback = new BlockingConsumer<TriggerStudioModeTransitionResponse>();
    this.sendRequest(TriggerStudioModeTransitionRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Sets the position of the TBar.
   *
   * **Very important note**: This will be deprecated and replaced in a future version of obs-websocket.
   *
   * @param position New position
   * @param release Whether to release the TBar. Only set `false` if you know that you will be sending another position update
   * @param callback Consumer&lt;SetTBarPositionResponse&gt;
   */
  public void setTBarPosition(Number position, Boolean release,
      Consumer<SetTBarPositionResponse> callback) {
    this.sendRequest(SetTBarPositionRequest.builder().position(position).release(release).build(), callback);
  }

  /**
   * Sets the position of the TBar.
   *
   * **Very important note**: This will be deprecated and replaced in a future version of obs-websocket.
   *
   * @param position New position
   * @param release Whether to release the TBar. Only set `false` if you know that you will be sending another position update
   * @param timeout long timeout in ms
   * @return the SetTBarPositionResponse, null if the request timed out
   */
  public SetTBarPositionResponse setTBarPosition(Number position, Boolean release, long timeout) {
    BlockingConsumer<SetTBarPositionResponse> callback = new BlockingConsumer<SetTBarPositionResponse>();
    this.sendRequest(SetTBarPositionRequest.builder().position(position).release(release).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets whether studio is enabled.
   *
   * @param callback Consumer&lt;GetStudioModeEnabledResponse&gt;
   */
  public void getStudioModeEnabled(Consumer<GetStudioModeEnabledResponse> callback) {
    this.sendRequest(GetStudioModeEnabledRequest.builder().build(), callback);
  }

  /**
   * Gets whether studio is enabled.
   *
   * @param timeout long timeout in ms
   * @return the GetStudioModeEnabledResponse, null if the request timed out
   */
  public GetStudioModeEnabledResponse getStudioModeEnabled(long timeout) {
    BlockingConsumer<GetStudioModeEnabledResponse> callback = new BlockingConsumer<GetStudioModeEnabledResponse>();
    this.sendRequest(GetStudioModeEnabledRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Enables or disables studio mode
   *
   * @param studioModeEnabled True == Enabled, False == Disabled
   * @param callback Consumer&lt;SetStudioModeEnabledResponse&gt;
   */
  public void setStudioModeEnabled(Boolean studioModeEnabled,
      Consumer<SetStudioModeEnabledResponse> callback) {
    this.sendRequest(SetStudioModeEnabledRequest.builder().studioModeEnabled(studioModeEnabled).build(), callback);
  }

  /**
   * Enables or disables studio mode
   *
   * @param studioModeEnabled True == Enabled, False == Disabled
   * @param timeout long timeout in ms
   * @return the SetStudioModeEnabledResponse, null if the request timed out
   */
  public SetStudioModeEnabledResponse setStudioModeEnabled(Boolean studioModeEnabled,
      long timeout) {
    BlockingConsumer<SetStudioModeEnabledResponse> callback = new BlockingConsumer<SetStudioModeEnabledResponse>();
    this.sendRequest(SetStudioModeEnabledRequest.builder().studioModeEnabled(studioModeEnabled).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Opens the properties dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   * @param callback Consumer&lt;OpenInputPropertiesDialogResponse&gt;
   */
  public void openInputPropertiesDialog(String inputName,
      Consumer<OpenInputPropertiesDialogResponse> callback) {
    this.sendRequest(OpenInputPropertiesDialogRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Opens the properties dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   * @param timeout long timeout in ms
   * @return the OpenInputPropertiesDialogResponse, null if the request timed out
   */
  public OpenInputPropertiesDialogResponse openInputPropertiesDialog(String inputName,
      long timeout) {
    BlockingConsumer<OpenInputPropertiesDialogResponse> callback = new BlockingConsumer<OpenInputPropertiesDialogResponse>();
    this.sendRequest(OpenInputPropertiesDialogRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Opens the filters dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   * @param callback Consumer&lt;OpenInputFiltersDialogResponse&gt;
   */
  public void openInputFiltersDialog(String inputName,
      Consumer<OpenInputFiltersDialogResponse> callback) {
    this.sendRequest(OpenInputFiltersDialogRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Opens the filters dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   * @param timeout long timeout in ms
   * @return the OpenInputFiltersDialogResponse, null if the request timed out
   */
  public OpenInputFiltersDialogResponse openInputFiltersDialog(String inputName, long timeout) {
    BlockingConsumer<OpenInputFiltersDialogResponse> callback = new BlockingConsumer<OpenInputFiltersDialogResponse>();
    this.sendRequest(OpenInputFiltersDialogRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Opens the interact dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   * @param callback Consumer&lt;OpenInputInteractDialogResponse&gt;
   */
  public void openInputInteractDialog(String inputName,
      Consumer<OpenInputInteractDialogResponse> callback) {
    this.sendRequest(OpenInputInteractDialogRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Opens the interact dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   * @param timeout long timeout in ms
   * @return the OpenInputInteractDialogResponse, null if the request timed out
   */
  public OpenInputInteractDialogResponse openInputInteractDialog(String inputName, long timeout) {
    BlockingConsumer<OpenInputInteractDialogResponse> callback = new BlockingConsumer<OpenInputInteractDialogResponse>();
    this.sendRequest(OpenInputInteractDialogRequest.builder().inputName(inputName).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Gets a list of connected monitors and information about them.
   *
   * @param callback Consumer&lt;GetMonitorListResponse&gt;
   */
  public void getMonitorList(Consumer<GetMonitorListResponse> callback) {
    this.sendRequest(GetMonitorListRequest.builder().build(), callback);
  }

  /**
   * Gets a list of connected monitors and information about them.
   *
   * @param timeout long timeout in ms
   * @return the GetMonitorListResponse, null if the request timed out
   */
  public GetMonitorListResponse getMonitorList(long timeout) {
    BlockingConsumer<GetMonitorListResponse> callback = new BlockingConsumer<GetMonitorListResponse>();
    this.sendRequest(GetMonitorListRequest.builder().build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Opens a projector for a specific output video mix.
   *
   * Mix types:
   *
   * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_PREVIEW`
   * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_PROGRAM`
   * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_MULTIVIEW`
   *
   * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
   *
   * @param videoMixType Type of mix to open
   * @param monitorIndex Monitor index, use `GetMonitorList` to obtain index
   * @param projectorGeometry Size/Position data for a windowed projector, in Qt Base64 encoded format. Mutually exclusive with `monitorIndex`
   * @param callback Consumer&lt;OpenVideoMixProjectorResponse&gt;
   */
  public void openVideoMixProjector(VideoMixType videoMixType, Number monitorIndex,
      String projectorGeometry, Consumer<OpenVideoMixProjectorResponse> callback) {
    this.sendRequest(OpenVideoMixProjectorRequest.builder().videoMixType(videoMixType).monitorIndex(monitorIndex).projectorGeometry(projectorGeometry).build(), callback);
  }

  /**
   * Opens a projector for a specific output video mix.
   *
   * Mix types:
   *
   * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_PREVIEW`
   * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_PROGRAM`
   * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_MULTIVIEW`
   *
   * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
   *
   * @param videoMixType Type of mix to open
   * @param monitorIndex Monitor index, use `GetMonitorList` to obtain index
   * @param projectorGeometry Size/Position data for a windowed projector, in Qt Base64 encoded format. Mutually exclusive with `monitorIndex`
   * @param timeout long timeout in ms
   * @return the OpenVideoMixProjectorResponse, null if the request timed out
   */
  public OpenVideoMixProjectorResponse openVideoMixProjector(VideoMixType videoMixType,
      Number monitorIndex, String projectorGeometry, long timeout) {
    BlockingConsumer<OpenVideoMixProjectorResponse> callback = new BlockingConsumer<OpenVideoMixProjectorResponse>();
    this.sendRequest(OpenVideoMixProjectorRequest.builder().videoMixType(videoMixType).monitorIndex(monitorIndex).projectorGeometry(projectorGeometry).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }

  /**
   * Opens a projector for a source.
   *
   * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
   *
   * @param sourceName Name of the source to open a projector for
   * @param monitorIndex Monitor index, use `GetMonitorList` to obtain index
   * @param projectorGeometry Size/Position data for a windowed projector, in Qt Base64 encoded format. Mutually exclusive with `monitorIndex`
   * @param callback Consumer&lt;OpenSourceProjectorResponse&gt;
   */
  public void openSourceProjector(String sourceName, Number monitorIndex, String projectorGeometry,
      Consumer<OpenSourceProjectorResponse> callback) {
    this.sendRequest(OpenSourceProjectorRequest.builder().sourceName(sourceName).monitorIndex(monitorIndex).projectorGeometry(projectorGeometry).build(), callback);
  }

  /**
   * Opens a projector for a source.
   *
   * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
   *
   * @param sourceName Name of the source to open a projector for
   * @param monitorIndex Monitor index, use `GetMonitorList` to obtain index
   * @param projectorGeometry Size/Position data for a windowed projector, in Qt Base64 encoded format. Mutually exclusive with `monitorIndex`
   * @param timeout long timeout in ms
   * @return the OpenSourceProjectorResponse, null if the request timed out
   */
  public OpenSourceProjectorResponse openSourceProjector(String sourceName, Number monitorIndex,
      String projectorGeometry, long timeout) {
    BlockingConsumer<OpenSourceProjectorResponse> callback = new BlockingConsumer<OpenSourceProjectorResponse>();
    this.sendRequest(OpenSourceProjectorRequest.builder().sourceName(sourceName).monitorIndex(monitorIndex).projectorGeometry(projectorGeometry).build(), callback);
    try { return callback.get(timeout); } catch (InterruptedException e) { throw new RuntimeException(e); }
  }
}
