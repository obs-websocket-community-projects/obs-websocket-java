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
   */
  public void getPersistentData(Realm realm, String slotName,
      Consumer<GetPersistentDataResponse> callback) {
    sendRequest(GetPersistentDataRequest.builder().realm(realm).slotName(slotName).build(), callback);
  }

  /**
   * Sets the value of a "slot" from the selected persistent data realm.
   *
   * @param realm The data realm to select. `OBS_WEBSOCKET_DATA_REALM_GLOBAL` or `OBS_WEBSOCKET_DATA_REALM_PROFILE`
   * @param slotName The name of the slot to retrieve data from
   * @param slotValue The value to apply to the slot
   */
  public void setPersistentData(Realm realm, String slotName, JsonElement slotValue,
      Consumer<SetPersistentDataResponse> callback) {
    sendRequest(SetPersistentDataRequest.builder().realm(realm).slotName(slotName).slotValue(slotValue).build(), callback);
  }

  /**
   * Gets an array of all scene collections
   */
  public void getSceneCollectionList(Consumer<GetSceneCollectionListResponse> callback) {
    sendRequest(GetSceneCollectionListRequest.builder().build(), callback);
  }

  /**
   * Switches to a scene collection.
   *
   * Note: This will block until the collection has finished changing.
   *
   * @param sceneCollectionName Name of the scene collection to switch to
   */
  public void setCurrentSceneCollection(String sceneCollectionName,
      Consumer<SetCurrentSceneCollectionResponse> callback) {
    sendRequest(SetCurrentSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
  }

  /**
   * Creates a new scene collection, switching to it in the process.
   *
   * Note: This will block until the collection has finished changing.
   *
   * @param sceneCollectionName Name for the new scene collection
   */
  public void createSceneCollection(String sceneCollectionName,
      Consumer<CreateSceneCollectionResponse> callback) {
    sendRequest(CreateSceneCollectionRequest.builder().sceneCollectionName(sceneCollectionName).build(), callback);
  }

  /**
   * Gets an array of all profiles
   */
  public void getProfileList(Consumer<GetProfileListResponse> callback) {
    sendRequest(GetProfileListRequest.builder().build(), callback);
  }

  /**
   * Switches to a profile.
   *
   * @param profileName Name of the profile to switch to
   */
  public void setCurrentProfile(String profileName, Consumer<SetCurrentProfileResponse> callback) {
    sendRequest(SetCurrentProfileRequest.builder().profileName(profileName).build(), callback);
  }

  /**
   * Creates a new profile, switching to it in the process
   *
   * @param profileName Name for the new profile
   */
  public void createProfile(String profileName, Consumer<CreateProfileResponse> callback) {
    sendRequest(CreateProfileRequest.builder().profileName(profileName).build(), callback);
  }

  /**
   * Removes a profile. If the current profile is chosen, it will change to a different profile first.
   *
   * @param profileName Name of the profile to remove
   */
  public void removeProfile(String profileName, Consumer<RemoveProfileResponse> callback) {
    sendRequest(RemoveProfileRequest.builder().profileName(profileName).build(), callback);
  }

  /**
   * Gets a parameter from the current profile's configuration.
   *
   * @param parameterCategory Category of the parameter to get
   * @param parameterName Name of the parameter to get
   */
  public void getProfileParameter(String parameterCategory, String parameterName,
      Consumer<GetProfileParameterResponse> callback) {
    sendRequest(GetProfileParameterRequest.builder().parameterCategory(parameterCategory).parameterName(parameterName).build(), callback);
  }

  /**
   * Sets the value of a parameter in the current profile's configuration.
   *
   * @param parameterCategory Category of the parameter to set
   * @param parameterName Name of the parameter to set
   * @param parameterValue Value of the parameter to set. Use `null` to delete
   */
  public void setProfileParameter(String parameterCategory, String parameterName,
      String parameterValue, Consumer<SetProfileParameterResponse> callback) {
    sendRequest(SetProfileParameterRequest.builder().parameterCategory(parameterCategory).parameterName(parameterName).parameterValue(parameterValue).build(), callback);
  }

  /**
   * Gets the current video settings.
   *
   * Note: To get the true FPS value, divide the FPS numerator by the FPS denominator. Example: `60000/1001`
   */
  public void getVideoSettings(Consumer<GetVideoSettingsResponse> callback) {
    sendRequest(GetVideoSettingsRequest.builder().build(), callback);
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
   */
  public void setVideoSettings(Number fpsNumerator, Number fpsDenominator, Number baseWidth,
      Number baseHeight, Number outputWidth, Number outputHeight,
      Consumer<SetVideoSettingsResponse> callback) {
    sendRequest(SetVideoSettingsRequest.builder().fpsNumerator(fpsNumerator).fpsDenominator(fpsDenominator).baseWidth(baseWidth).baseHeight(baseHeight).outputWidth(outputWidth).outputHeight(outputHeight).build(), callback);
  }

  /**
   * Gets the current stream service settings (stream destination).
   */
  public void getStreamServiceSettings(Consumer<GetStreamServiceSettingsResponse> callback) {
    sendRequest(GetStreamServiceSettingsRequest.builder().build(), callback);
  }

  /**
   * Sets the current stream service settings (stream destination).
   *
   * Note: Simple RTMP settings can be set with type `rtmp_custom` and the settings fields `server` and `key`.
   *
   * @param streamServiceType Type of stream service to apply. Example: `rtmp_common` or `rtmp_custom`
   * @param streamServiceSettings Settings to apply to the service
   */
  public void setStreamServiceSettings(String streamServiceType, JsonObject streamServiceSettings,
      Consumer<SetStreamServiceSettingsResponse> callback) {
    sendRequest(SetStreamServiceSettingsRequest.builder().streamServiceType(streamServiceType).streamServiceSettings(streamServiceSettings).build(), callback);
  }

  /**
   * Gets the current directory that the record output is set to.
   */
  public void getRecordDirectory(Consumer<GetRecordDirectoryResponse> callback) {
    sendRequest(GetRecordDirectoryRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all of a source's filters.
   *
   * @param sourceName Name of the source
   */
  public void getSourceFilterList(String sourceName,
      Consumer<GetSourceFilterListResponse> callback) {
    sendRequest(GetSourceFilterListRequest.builder().sourceName(sourceName).build(), callback);
  }

  /**
   * Gets the default settings for a filter kind.
   *
   * @param filterKind Filter kind to get the default settings for
   */
  public void getSourceFilterDefaultSettings(String filterKind,
      Consumer<GetSourceFilterDefaultSettingsResponse> callback) {
    sendRequest(GetSourceFilterDefaultSettingsRequest.builder().filterKind(filterKind).build(), callback);
  }

  /**
   * Creates a new filter, adding it to the specified source.
   *
   * @param sourceName Name of the source to add the filter to
   * @param filterName Name of the new filter to be created
   * @param filterKind The kind of filter to be created
   * @param filterSettings Settings object to initialize the filter with
   */
  public void createSourceFilter(String sourceName, String filterName, String filterKind,
      JsonObject filterSettings, Consumer<CreateSourceFilterResponse> callback) {
    sendRequest(CreateSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).filterKind(filterKind).filterSettings(filterSettings).build(), callback);
  }

  /**
   * Removes a filter from a source.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter to remove
   */
  public void removeSourceFilter(String sourceName, String filterName,
      Consumer<RemoveSourceFilterResponse> callback) {
    sendRequest(RemoveSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(), callback);
  }

  /**
   * Sets the name of a source filter (rename).
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Current name of the filter
   * @param newFilterName New name for the filter
   */
  public void setSourceFilterName(String sourceName, String filterName, String newFilterName,
      Consumer<SetSourceFilterNameResponse> callback) {
    sendRequest(SetSourceFilterNameRequest.builder().sourceName(sourceName).filterName(filterName).newFilterName(newFilterName).build(), callback);
  }

  /**
   * Gets the info for a specific source filter.
   *
   * @param sourceName Name of the source
   * @param filterName Name of the filter
   */
  public void getSourceFilter(String sourceName, String filterName,
      Consumer<GetSourceFilterResponse> callback) {
    sendRequest(GetSourceFilterRequest.builder().sourceName(sourceName).filterName(filterName).build(), callback);
  }

  /**
   * Sets the index position of a filter on a source.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter
   * @param filterIndex New index position of the filter
   */
  public void setSourceFilterIndex(String sourceName, String filterName, Number filterIndex,
      Consumer<SetSourceFilterIndexResponse> callback) {
    sendRequest(SetSourceFilterIndexRequest.builder().sourceName(sourceName).filterName(filterName).filterIndex(filterIndex).build(), callback);
  }

  /**
   * Sets the settings of a source filter.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter to set the settings of
   * @param filterSettings Object of settings to apply
   * @param overlay True == apply the settings on top of existing ones, False == reset the input to its defaults, then apply settings.
   */
  public void setSourceFilterSettings(String sourceName, String filterName,
      JsonObject filterSettings, Boolean overlay,
      Consumer<SetSourceFilterSettingsResponse> callback) {
    sendRequest(SetSourceFilterSettingsRequest.builder().sourceName(sourceName).filterName(filterName).filterSettings(filterSettings).overlay(overlay).build(), callback);
  }

  /**
   * Sets the enable state of a source filter.
   *
   * @param sourceName Name of the source the filter is on
   * @param filterName Name of the filter
   * @param filterEnabled New enable state of the filter
   */
  public void setSourceFilterEnabled(String sourceName, String filterName, Boolean filterEnabled,
      Consumer<SetSourceFilterEnabledResponse> callback) {
    sendRequest(SetSourceFilterEnabledRequest.builder().sourceName(sourceName).filterName(filterName).filterEnabled(filterEnabled).build(), callback);
  }

  /**
   * Gets data about the current plugin and RPC version.
   */
  public void getVersion(Consumer<GetVersionResponse> callback) {
    sendRequest(GetVersionRequest.builder().build(), callback);
  }

  /**
   * Gets statistics about OBS, obs-websocket, and the current session.
   */
  public void getStats(Consumer<GetStatsResponse> callback) {
    sendRequest(GetStatsRequest.builder().build(), callback);
  }

  /**
   * Broadcasts a `CustomEvent` to all WebSocket clients. Receivers are clients which are identified and subscribed.
   *
   * @param eventData Data payload to emit to all receivers
   */
  public void broadcastCustomEvent(JsonObject eventData,
      Consumer<BroadcastCustomEventResponse> callback) {
    sendRequest(BroadcastCustomEventRequest.builder().eventData(eventData).build(), callback);
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
   */
  public void callVendorRequest(String vendorName, String requestType, JsonObject requestData,
      Consumer<CallVendorRequestResponse> callback) {
    sendRequest(CallVendorRequestRequest.builder().vendorName(vendorName).requestType(requestType).requestData(requestData).build(), callback);
  }

  /**
   * Gets an array of all hotkey names in OBS
   */
  public void getHotkeyList(Consumer<GetHotkeyListResponse> callback) {
    sendRequest(GetHotkeyListRequest.builder().build(), callback);
  }

  /**
   * Triggers a hotkey using its name. See `GetHotkeyList`
   *
   * @param hotkeyName Name of the hotkey to trigger
   */
  public void triggerHotkeyByName(String hotkeyName,
      Consumer<TriggerHotkeyByNameResponse> callback) {
    sendRequest(TriggerHotkeyByNameRequest.builder().hotkeyName(hotkeyName).build(), callback);
  }

  /**
   * Triggers a hotkey using a sequence of keys.
   *
   * @param keyId The OBS key ID to use. See https://github.com/obsproject/obs-studio/blob/master/libobs/obs-hotkeys.h
   * @param keyModifiers Object containing key modifiers to apply
   */
  public void triggerHotkeyByKeySequence(String keyId, KeyModifiers keyModifiers,
      Consumer<TriggerHotkeyByKeySequenceResponse> callback) {
    sendRequest(TriggerHotkeyByKeySequenceRequest.builder().keyId(keyId).keyModifiers(keyModifiers).build(), callback);
  }

  /**
   * Sleeps for a time duration or number of frames. Only available in request batches with types `SERIAL_REALTIME` or `SERIAL_FRAME`.
   *
   * @param sleepMillis Number of milliseconds to sleep for (if `SERIAL_REALTIME` mode)
   * @param sleepFrames Number of frames to sleep for (if `SERIAL_FRAME` mode)
   */
  public void sleep(Number sleepMillis, Number sleepFrames, Consumer<SleepResponse> callback) {
    sendRequest(SleepRequest.builder().sleepMillis(sleepMillis).sleepFrames(sleepFrames).build(), callback);
  }

  /**
   * Gets an array of all inputs in OBS.
   *
   * @param inputKind Restrict the array to only inputs of the specified kind
   */
  public void getInputList(String inputKind, Consumer<GetInputListResponse> callback) {
    sendRequest(GetInputListRequest.builder().inputKind(inputKind).build(), callback);
  }

  /**
   * Gets an array of all available input kinds in OBS.
   *
   * @param unversioned True == Return all kinds as unversioned, False == Return with version suffixes (if available)
   */
  public void getInputKindList(Boolean unversioned, Consumer<GetInputKindListResponse> callback) {
    sendRequest(GetInputKindListRequest.builder().unversioned(unversioned).build(), callback);
  }

  /**
   * Gets the names of all special inputs.
   */
  public void getSpecialInputs(Consumer<GetSpecialInputsResponse> callback) {
    sendRequest(GetSpecialInputsRequest.builder().build(), callback);
  }

  /**
   * Creates a new input, adding it as a scene item to the specified scene.
   *
   * @param sceneName Name of the scene to add the input to as a scene item
   * @param inputName Name of the new input to created
   * @param inputKind The kind of input to be created
   * @param inputSettings Settings object to initialize the input with
   * @param sceneItemEnabled Whether to set the created scene item to enabled or disabled
   */
  public void createInput(String sceneName, String inputName, String inputKind,
      JsonObject inputSettings, Boolean sceneItemEnabled, Consumer<CreateInputResponse> callback) {
    sendRequest(CreateInputRequest.builder().sceneName(sceneName).inputName(inputName).inputKind(inputKind).inputSettings(inputSettings).sceneItemEnabled(sceneItemEnabled).build(), callback);
  }

  /**
   * Removes an existing input.
   *
   * Note: Will immediately remove all associated scene items.
   *
   * @param inputName Name of the input to remove
   */
  public void removeInput(String inputName, Consumer<RemoveInputResponse> callback) {
    sendRequest(RemoveInputRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the name of an input (rename).
   *
   * @param inputName Current input name
   * @param newInputName New name for the input
   */
  public void setInputName(String inputName, String newInputName,
      Consumer<SetInputNameResponse> callback) {
    sendRequest(SetInputNameRequest.builder().inputName(inputName).newInputName(newInputName).build(), callback);
  }

  /**
   * Gets the default settings for an input kind.
   *
   * @param inputKind Input kind to get the default settings for
   */
  public void getInputDefaultSettings(String inputKind,
      Consumer<GetInputDefaultSettingsResponse> callback) {
    sendRequest(GetInputDefaultSettingsRequest.builder().inputKind(inputKind).build(), callback);
  }

  /**
   * Gets the settings of an input.
   *
   * Note: Does not include defaults. To create the entire settings object, overlay `inputSettings` over the `defaultInputSettings` provided by `GetInputDefaultSettings`.
   *
   * @param inputName Name of the input to get the settings of
   */
  public void getInputSettings(String inputName, Consumer<GetInputSettingsResponse> callback) {
    sendRequest(GetInputSettingsRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the settings of an input.
   *
   * @param inputName Name of the input to set the settings of
   * @param inputSettings Object of settings to apply
   * @param overlay True == apply the settings on top of existing ones, False == reset the input to its defaults, then apply settings.
   */
  public void setInputSettings(String inputName, JsonObject inputSettings, Boolean overlay,
      Consumer<SetInputSettingsResponse> callback) {
    sendRequest(SetInputSettingsRequest.builder().inputName(inputName).inputSettings(inputSettings).overlay(overlay).build(), callback);
  }

  /**
   * Gets the audio mute state of an input.
   *
   * @param inputName Name of input to get the mute state of
   */
  public void getInputMute(String inputName, Consumer<GetInputMuteResponse> callback) {
    sendRequest(GetInputMuteRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the audio mute state of an input.
   *
   * @param inputName Name of the input to set the mute state of
   * @param inputMuted Whether to mute the input or not
   */
  public void setInputMute(String inputName, Boolean inputMuted,
      Consumer<SetInputMuteResponse> callback) {
    sendRequest(SetInputMuteRequest.builder().inputName(inputName).inputMuted(inputMuted).build(), callback);
  }

  /**
   * Toggles the audio mute state of an input.
   *
   * @param inputName Name of the input to toggle the mute state of
   */
  public void toggleInputMute(String inputName, Consumer<ToggleInputMuteResponse> callback) {
    sendRequest(ToggleInputMuteRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets the current volume setting of an input.
   *
   * @param inputName Name of the input to get the volume of
   */
  public void getInputVolume(String inputName, Consumer<GetInputVolumeResponse> callback) {
    sendRequest(GetInputVolumeRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the volume setting of an input.
   *
   * @param inputName Name of the input to set the volume of
   * @param inputVolumeMul Volume setting in mul
   * @param inputVolumeDb Volume setting in dB
   */
  public void setInputVolume(String inputName, Number inputVolumeMul, Number inputVolumeDb,
      Consumer<SetInputVolumeResponse> callback) {
    sendRequest(SetInputVolumeRequest.builder().inputName(inputName).inputVolumeMul(inputVolumeMul).inputVolumeDb(inputVolumeDb).build(), callback);
  }

  /**
   * Gets the audio balance of an input.
   *
   * @param inputName Name of the input to get the audio balance of
   */
  public void getInputAudioBalance(String inputName,
      Consumer<GetInputAudioBalanceResponse> callback) {
    sendRequest(GetInputAudioBalanceRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the audio balance of an input.
   *
   * @param inputName Name of the input to set the audio balance of
   * @param inputAudioBalance New audio balance value
   */
  public void setInputAudioBalance(String inputName, Number inputAudioBalance,
      Consumer<SetInputAudioBalanceResponse> callback) {
    sendRequest(SetInputAudioBalanceRequest.builder().inputName(inputName).inputAudioBalance(inputAudioBalance).build(), callback);
  }

  /**
   * Gets the audio sync offset of an input.
   *
   * Note: The audio sync offset can be negative too!
   *
   * @param inputName Name of the input to get the audio sync offset of
   */
  public void getInputAudioSyncOffset(String inputName,
      Consumer<GetInputAudioSyncOffsetResponse> callback) {
    sendRequest(GetInputAudioSyncOffsetRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the audio sync offset of an input.
   *
   * @param inputName Name of the input to set the audio sync offset of
   * @param inputAudioSyncOffset New audio sync offset in milliseconds
   */
  public void setInputAudioSyncOffset(String inputName, Number inputAudioSyncOffset,
      Consumer<SetInputAudioSyncOffsetResponse> callback) {
    sendRequest(SetInputAudioSyncOffsetRequest.builder().inputName(inputName).inputAudioSyncOffset(inputAudioSyncOffset).build(), callback);
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
   */
  public void getInputAudioMonitorType(String inputName,
      Consumer<GetInputAudioMonitorTypeResponse> callback) {
    sendRequest(GetInputAudioMonitorTypeRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the audio monitor type of an input.
   *
   * @param inputName Name of the input to set the audio monitor type of
   * @param monitorType Audio monitor type
   */
  public void setInputAudioMonitorType(String inputName, Input.MonitorType monitorType,
      Consumer<SetInputAudioMonitorTypeResponse> callback) {
    sendRequest(SetInputAudioMonitorTypeRequest.builder().inputName(inputName).monitorType(monitorType).build(), callback);
  }

  /**
   * Gets the enable state of all audio tracks of an input.
   *
   * @param inputName Name of the input
   */
  public void getInputAudioTracks(String inputName,
      Consumer<GetInputAudioTracksResponse> callback) {
    sendRequest(GetInputAudioTracksRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the enable state of audio tracks of an input.
   *
   * @param inputName Name of the input
   * @param inputAudioTracks Track settings to apply
   */
  public void setInputAudioTracks(String inputName, Input.AudioTracks inputAudioTracks,
      Consumer<SetInputAudioTracksResponse> callback) {
    sendRequest(SetInputAudioTracksRequest.builder().inputName(inputName).inputAudioTracks(inputAudioTracks).build(), callback);
  }

  /**
   * Gets the items of a list property from an input's properties.
   *
   * Note: Use this in cases where an input provides a dynamic, selectable list of items. For example, display capture, where it provides a list of available displays.
   *
   * @param inputName Name of the input
   * @param propertyName Name of the list property to get the items of
   */
  public void getInputPropertiesListPropertyItems(String inputName, String propertyName,
      Consumer<GetInputPropertiesListPropertyItemsResponse> callback) {
    sendRequest(GetInputPropertiesListPropertyItemsRequest.builder().inputName(inputName).propertyName(propertyName).build(), callback);
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
   */
  public void pressInputPropertiesButton(String inputName, String propertyName,
      Consumer<PressInputPropertiesButtonResponse> callback) {
    sendRequest(PressInputPropertiesButtonRequest.builder().inputName(inputName).propertyName(propertyName).build(), callback);
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
   */
  public void getMediaInputStatus(String inputName,
      Consumer<GetMediaInputStatusResponse> callback) {
    sendRequest(GetMediaInputStatusRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Sets the cursor position of a media input.
   *
   * This request does not perform bounds checking of the cursor position.
   *
   * @param inputName Name of the media input
   * @param mediaCursor New cursor position to set
   */
  public void setMediaInputCursor(String inputName, Number mediaCursor,
      Consumer<SetMediaInputCursorResponse> callback) {
    sendRequest(SetMediaInputCursorRequest.builder().inputName(inputName).mediaCursor(mediaCursor).build(), callback);
  }

  /**
   * Offsets the current cursor position of a media input by the specified value.
   *
   * This request does not perform bounds checking of the cursor position.
   *
   * @param inputName Name of the media input
   * @param mediaCursorOffset Value to offset the current cursor position by
   */
  public void offsetMediaInputCursor(String inputName, Number mediaCursorOffset,
      Consumer<OffsetMediaInputCursorResponse> callback) {
    sendRequest(OffsetMediaInputCursorRequest.builder().inputName(inputName).mediaCursorOffset(mediaCursorOffset).build(), callback);
  }

  /**
   * Triggers an action on a media input.
   *
   * @param inputName Name of the media input
   * @param mediaAction Identifier of the `ObsMediaInputAction` enum
   */
  public void triggerMediaInputAction(String inputName, String mediaAction,
      Consumer<TriggerMediaInputActionResponse> callback) {
    sendRequest(TriggerMediaInputActionRequest.builder().inputName(inputName).mediaAction(mediaAction).build(), callback);
  }

  /**
   * Gets the status of the virtualcam output.
   */
  public void getVirtualCamStatus(Consumer<GetVirtualCamStatusResponse> callback) {
    sendRequest(GetVirtualCamStatusRequest.builder().build(), callback);
  }

  /**
   * Toggles the state of the virtualcam output.
   */
  public void toggleVirtualCam(Consumer<ToggleVirtualCamResponse> callback) {
    sendRequest(ToggleVirtualCamRequest.builder().build(), callback);
  }

  /**
   * Starts the virtualcam output.
   */
  public void startVirtualCam(Consumer<StartVirtualCamResponse> callback) {
    sendRequest(StartVirtualCamRequest.builder().build(), callback);
  }

  /**
   * Stops the virtualcam output.
   */
  public void stopVirtualCam(Consumer<StopVirtualCamResponse> callback) {
    sendRequest(StopVirtualCamRequest.builder().build(), callback);
  }

  /**
   * Gets the status of the replay buffer output.
   */
  public void getReplayBufferStatus(Consumer<GetReplayBufferStatusResponse> callback) {
    sendRequest(GetReplayBufferStatusRequest.builder().build(), callback);
  }

  /**
   * Toggles the state of the replay buffer output.
   */
  public void toggleReplayBuffer(Consumer<ToggleReplayBufferResponse> callback) {
    sendRequest(ToggleReplayBufferRequest.builder().build(), callback);
  }

  /**
   * Starts the replay buffer output.
   */
  public void startReplayBuffer(Consumer<StartReplayBufferResponse> callback) {
    sendRequest(StartReplayBufferRequest.builder().build(), callback);
  }

  /**
   * Stops the replay buffer output.
   */
  public void stopReplayBuffer(Consumer<StopReplayBufferResponse> callback) {
    sendRequest(StopReplayBufferRequest.builder().build(), callback);
  }

  /**
   * Saves the contents of the replay buffer output.
   */
  public void saveReplayBuffer(Consumer<SaveReplayBufferResponse> callback) {
    sendRequest(SaveReplayBufferRequest.builder().build(), callback);
  }

  /**
   * Gets the filename of the last replay buffer save file.
   */
  public void getLastReplayBufferReplay(Consumer<GetLastReplayBufferReplayResponse> callback) {
    sendRequest(GetLastReplayBufferReplayRequest.builder().build(), callback);
  }

  /**
   * Gets the list of available outputs.
   */
  public void getOutputList(Consumer<GetOutputListResponse> callback) {
    sendRequest(GetOutputListRequest.builder().build(), callback);
  }

  /**
   * Gets the status of an output.
   *
   * @param outputName Output name
   */
  public void getOutputStatus(String outputName, Consumer<GetOutputStatusResponse> callback) {
    sendRequest(GetOutputStatusRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Toggles the status of an output.
   *
   * @param outputName Output name
   */
  public void toggleOutput(String outputName, Consumer<ToggleOutputResponse> callback) {
    sendRequest(ToggleOutputRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Starts an output.
   *
   * @param outputName Output name
   */
  public void startOutput(String outputName, Consumer<StartOutputResponse> callback) {
    sendRequest(StartOutputRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Stops an output.
   *
   * @param outputName Output name
   */
  public void stopOutput(String outputName, Consumer<StopOutputResponse> callback) {
    sendRequest(StopOutputRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Gets the settings of an output.
   *
   * @param outputName Output name
   */
  public void getOutputSettings(String outputName, Consumer<GetOutputSettingsResponse> callback) {
    sendRequest(GetOutputSettingsRequest.builder().outputName(outputName).build(), callback);
  }

  /**
   * Sets the settings of an output.
   *
   * @param outputName Output name
   * @param outputSettings Output settings
   */
  public void setOutputSettings(String outputName, JsonObject outputSettings,
      Consumer<SetOutputSettingsResponse> callback) {
    sendRequest(SetOutputSettingsRequest.builder().outputName(outputName).outputSettings(outputSettings).build(), callback);
  }

  /**
   * Gets the status of the record output.
   */
  public void getRecordStatus(Consumer<GetRecordStatusResponse> callback) {
    sendRequest(GetRecordStatusRequest.builder().build(), callback);
  }

  /**
   * Toggles the status of the record output.
   */
  public void toggleRecord(Consumer<ToggleRecordResponse> callback) {
    sendRequest(ToggleRecordRequest.builder().build(), callback);
  }

  /**
   * Starts the record output.
   */
  public void startRecord(Consumer<StartRecordResponse> callback) {
    sendRequest(StartRecordRequest.builder().build(), callback);
  }

  /**
   * Stops the record output.
   */
  public void stopRecord(Consumer<StopRecordResponse> callback) {
    sendRequest(StopRecordRequest.builder().build(), callback);
  }

  /**
   * Toggles pause on the record output.
   */
  public void toggleRecordPause(Consumer<ToggleRecordPauseResponse> callback) {
    sendRequest(ToggleRecordPauseRequest.builder().build(), callback);
  }

  /**
   * Pauses the record output.
   */
  public void pauseRecord(Consumer<PauseRecordResponse> callback) {
    sendRequest(PauseRecordRequest.builder().build(), callback);
  }

  /**
   * Resumes the record output.
   */
  public void resumeRecord(Consumer<ResumeRecordResponse> callback) {
    sendRequest(ResumeRecordRequest.builder().build(), callback);
  }

  /**
   * Gets a list of all scene items in a scene.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene to get the items of
   */
  public void getSceneItemList(String sceneName, Consumer<GetSceneItemListResponse> callback) {
    sendRequest(GetSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Basically GetSceneItemList, but for groups.
   *
   * Using groups at all in OBS is discouraged, as they are very broken under the hood. Please use nested scenes instead.
   *
   * Groups only
   *
   * @param sceneName Name of the group to get the items of
   */
  public void getGroupSceneItemList(String sceneName,
      Consumer<GetGroupSceneItemListResponse> callback) {
    sendRequest(GetGroupSceneItemListRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Searches a scene for a source, and returns its id.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene or group to search in
   * @param sourceName Name of the source to find
   * @param searchOffset Number of matches to skip during search. >= 0 means first forward. -1 means last (top) item
   */
  public void getSceneItemId(String sceneName, String sourceName, Number searchOffset,
      Consumer<GetSceneItemIdResponse> callback) {
    sendRequest(GetSceneItemIdRequest.builder().sceneName(sceneName).sourceName(sourceName).searchOffset(searchOffset).build(), callback);
  }

  /**
   * Creates a new scene item using a source.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene to create the new item in
   * @param sourceName Name of the source to add to the scene
   * @param sceneItemEnabled Enable state to apply to the scene item on creation
   */
  public void createSceneItem(String sceneName, String sourceName, Boolean sceneItemEnabled,
      Consumer<CreateSceneItemResponse> callback) {
    sendRequest(CreateSceneItemRequest.builder().sceneName(sceneName).sourceName(sourceName).sceneItemEnabled(sceneItemEnabled).build(), callback);
  }

  /**
   * Removes a scene item from a scene.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   */
  public void removeSceneItem(String sceneName, Number sceneItemId,
      Consumer<RemoveSceneItemResponse> callback) {
    sendRequest(RemoveSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Duplicates a scene item, copying all transform and crop info.
   *
   * Scenes only
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param destinationSceneName Name of the scene to create the duplicated item in
   */
  public void duplicateSceneItem(String sceneName, Number sceneItemId, String destinationSceneName,
      Consumer<DuplicateSceneItemResponse> callback) {
    sendRequest(DuplicateSceneItemRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).destinationSceneName(destinationSceneName).build(), callback);
  }

  /**
   * Gets the transform and crop info of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   */
  public void getSceneItemTransform(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemTransformResponse> callback) {
    sendRequest(GetSceneItemTransformRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Sets the transform and crop info of a scene item.
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemTransform Object containing scene item transform info to update
   */
  public void setSceneItemTransform(String sceneName, Number sceneItemId,
      SceneItem.Transform sceneItemTransform, Consumer<SetSceneItemTransformResponse> callback) {
    sendRequest(SetSceneItemTransformRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemTransform(sceneItemTransform).build(), callback);
  }

  /**
   * Gets the enable state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   */
  public void getSceneItemEnabled(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemEnabledResponse> callback) {
    sendRequest(GetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Sets the enable state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemEnabled New enable state of the scene item
   */
  public void setSceneItemEnabled(String sceneName, Number sceneItemId, Boolean sceneItemEnabled,
      Consumer<SetSceneItemEnabledResponse> callback) {
    sendRequest(SetSceneItemEnabledRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemEnabled(sceneItemEnabled).build(), callback);
  }

  /**
   * Gets the lock state of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   */
  public void getSceneItemLocked(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemLockedResponse> callback) {
    sendRequest(GetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Sets the lock state of a scene item.
   *
   * Scenes and Group
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemLocked New lock state of the scene item
   */
  public void setSceneItemLocked(String sceneName, Number sceneItemId, Boolean sceneItemLocked,
      Consumer<SetSceneItemLockedResponse> callback) {
    sendRequest(SetSceneItemLockedRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemLocked(sceneItemLocked).build(), callback);
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
   */
  public void getSceneItemIndex(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemIndexResponse> callback) {
    sendRequest(GetSceneItemIndexRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Sets the index position of a scene item in a scene.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemIndex New index position of the scene item
   */
  public void setSceneItemIndex(String sceneName, Number sceneItemId, Number sceneItemIndex,
      Consumer<SetSceneItemIndexResponse> callback) {
    sendRequest(SetSceneItemIndexRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemIndex(sceneItemIndex).build(), callback);
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
   */
  public void getSceneItemBlendMode(String sceneName, Number sceneItemId,
      Consumer<GetSceneItemBlendModeResponse> callback) {
    sendRequest(GetSceneItemBlendModeRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).build(), callback);
  }

  /**
   * Sets the blend mode of a scene item.
   *
   * Scenes and Groups
   *
   * @param sceneName Name of the scene the item is in
   * @param sceneItemId Numeric ID of the scene item
   * @param sceneItemBlendMode New blend mode
   */
  public void setSceneItemBlendMode(String sceneName, Number sceneItemId,
      SceneItem.BlendMode sceneItemBlendMode, Consumer<SetSceneItemBlendModeResponse> callback) {
    sendRequest(SetSceneItemBlendModeRequest.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemBlendMode(sceneItemBlendMode).build(), callback);
  }

  /**
   * Gets an array of all scenes in OBS.
   */
  public void getSceneList(Consumer<GetSceneListResponse> callback) {
    sendRequest(GetSceneListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all groups in OBS.
   *
   * Groups in OBS are actually scenes, but renamed and modified. In obs-websocket, we treat them as scenes where we can.
   */
  public void getGroupList(Consumer<GetGroupListResponse> callback) {
    sendRequest(GetGroupListRequest.builder().build(), callback);
  }

  /**
   * Gets the current program scene.
   */
  public void getCurrentProgramScene(Consumer<GetCurrentProgramSceneResponse> callback) {
    sendRequest(GetCurrentProgramSceneRequest.builder().build(), callback);
  }

  /**
   * Sets the current program scene.
   *
   * @param sceneName Scene to set as the current program scene
   */
  public void setCurrentProgramScene(String sceneName,
      Consumer<SetCurrentProgramSceneResponse> callback) {
    sendRequest(SetCurrentProgramSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Gets the current preview scene.
   *
   * Only available when studio mode is enabled.
   */
  public void getCurrentPreviewScene(Consumer<GetCurrentPreviewSceneResponse> callback) {
    sendRequest(GetCurrentPreviewSceneRequest.builder().build(), callback);
  }

  /**
   * Sets the current preview scene.
   *
   * Only available when studio mode is enabled.
   *
   * @param sceneName Scene to set as the current preview scene
   */
  public void setCurrentPreviewScene(String sceneName,
      Consumer<SetCurrentPreviewSceneResponse> callback) {
    sendRequest(SetCurrentPreviewSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Creates a new scene in OBS.
   *
   * @param sceneName Name for the new scene
   */
  public void createScene(String sceneName, Consumer<CreateSceneResponse> callback) {
    sendRequest(CreateSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Removes a scene from OBS.
   *
   * @param sceneName Name of the scene to remove
   */
  public void removeScene(String sceneName, Consumer<RemoveSceneResponse> callback) {
    sendRequest(RemoveSceneRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Sets the name of a scene (rename).
   *
   * @param sceneName Name of the scene to be renamed
   * @param newSceneName New name for the scene
   */
  public void setSceneName(String sceneName, String newSceneName,
      Consumer<SetSceneNameResponse> callback) {
    sendRequest(SetSceneNameRequest.builder().sceneName(sceneName).newSceneName(newSceneName).build(), callback);
  }

  /**
   * Gets the scene transition overridden for a scene.
   *
   * @param sceneName Name of the scene
   */
  public void getSceneSceneTransitionOverride(String sceneName,
      Consumer<GetSceneSceneTransitionOverrideResponse> callback) {
    sendRequest(GetSceneSceneTransitionOverrideRequest.builder().sceneName(sceneName).build(), callback);
  }

  /**
   * Gets the scene transition overridden for a scene.
   *
   * @param sceneName Name of the scene
   * @param transitionName Name of the scene transition to use as override. Specify `null` to remove
   * @param transitionDuration Duration to use for any overridden transition. Specify `null` to remove
   */
  public void setSceneSceneTransitionOverride(String sceneName, String transitionName,
      Number transitionDuration, Consumer<SetSceneSceneTransitionOverrideResponse> callback) {
    sendRequest(SetSceneSceneTransitionOverrideRequest.builder().sceneName(sceneName).transitionName(transitionName).transitionDuration(transitionDuration).build(), callback);
  }

  /**
   * Gets the active and show state of a source.
   *
   * **Compatible with inputs and scenes.**
   *
   * @param sourceName Name of the source to get the active state of
   */
  public void getSourceActive(String sourceName, Consumer<GetSourceActiveResponse> callback) {
    sendRequest(GetSourceActiveRequest.builder().sourceName(sourceName).build(), callback);
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
   */
  public void getSourceScreenshot(String sourceName, String imageFormat, Number imageWidth,
      Number imageHeight, Number imageCompressionQuality,
      Consumer<GetSourceScreenshotResponse> callback) {
    sendRequest(GetSourceScreenshotRequest.builder().sourceName(sourceName).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build(), callback);
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
   */
  public void saveSourceScreenshot(String sourceName, String imageFormat, String imageFilePath,
      Number imageWidth, Number imageHeight, Number imageCompressionQuality,
      Consumer<SaveSourceScreenshotResponse> callback) {
    sendRequest(SaveSourceScreenshotRequest.builder().sourceName(sourceName).imageFormat(imageFormat).imageFilePath(imageFilePath).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build(), callback);
  }

  /**
   * Gets the status of the stream output.
   */
  public void getStreamStatus(Consumer<GetStreamStatusResponse> callback) {
    sendRequest(GetStreamStatusRequest.builder().build(), callback);
  }

  /**
   * Toggles the status of the stream output.
   */
  public void toggleStream(Consumer<ToggleStreamResponse> callback) {
    sendRequest(ToggleStreamRequest.builder().build(), callback);
  }

  /**
   * Starts the stream output.
   */
  public void startStream(Consumer<StartStreamResponse> callback) {
    sendRequest(StartStreamRequest.builder().build(), callback);
  }

  /**
   * Stops the stream output.
   */
  public void stopStream(Consumer<StopStreamResponse> callback) {
    sendRequest(StopStreamRequest.builder().build(), callback);
  }

  /**
   * Sends CEA-608 caption text over the stream output.
   *
   * @param captionText Caption text
   */
  public void sendStreamCaption(String captionText, Consumer<SendStreamCaptionResponse> callback) {
    sendRequest(SendStreamCaptionRequest.builder().captionText(captionText).build(), callback);
  }

  /**
   * Gets an array of all available transition kinds.
   *
   * Similar to `GetInputKindList`
   */
  public void getTransitionKindList(Consumer<GetTransitionKindListResponse> callback) {
    sendRequest(GetTransitionKindListRequest.builder().build(), callback);
  }

  /**
   * Gets an array of all scene transitions in OBS.
   */
  public void getSceneTransitionList(Consumer<GetSceneTransitionListResponse> callback) {
    sendRequest(GetSceneTransitionListRequest.builder().build(), callback);
  }

  /**
   * Gets information about the current scene transition.
   */
  public void getCurrentSceneTransition(Consumer<GetCurrentSceneTransitionResponse> callback) {
    sendRequest(GetCurrentSceneTransitionRequest.builder().build(), callback);
  }

  /**
   * Sets the current scene transition.
   *
   * Small note: While the namespace of scene transitions is generally unique, that uniqueness is not a guarantee as it is with other resources like inputs.
   *
   * @param transitionName Name of the transition to make active
   */
  public void setCurrentSceneTransition(String transitionName,
      Consumer<SetCurrentSceneTransitionResponse> callback) {
    sendRequest(SetCurrentSceneTransitionRequest.builder().transitionName(transitionName).build(), callback);
  }

  /**
   * Sets the duration of the current scene transition, if it is not fixed.
   *
   * @param transitionDuration Duration in milliseconds
   */
  public void setCurrentSceneTransitionDuration(Number transitionDuration,
      Consumer<SetCurrentSceneTransitionDurationResponse> callback) {
    sendRequest(SetCurrentSceneTransitionDurationRequest.builder().transitionDuration(transitionDuration).build(), callback);
  }

  /**
   * Sets the settings of the current scene transition.
   *
   * @param transitionSettings Settings object to apply to the transition. Can be `{}`
   * @param overlay Whether to overlay over the current settings or replace them
   */
  public void setCurrentSceneTransitionSettings(JsonObject transitionSettings, Boolean overlay,
      Consumer<SetCurrentSceneTransitionSettingsResponse> callback) {
    sendRequest(SetCurrentSceneTransitionSettingsRequest.builder().transitionSettings(transitionSettings).overlay(overlay).build(), callback);
  }

  /**
   * Gets the cursor position of the current scene transition.
   *
   * Note: `transitionCursor` will return 1.0 when the transition is inactive.
   */
  public void getCurrentSceneTransitionCursor(
      Consumer<GetCurrentSceneTransitionCursorResponse> callback) {
    sendRequest(GetCurrentSceneTransitionCursorRequest.builder().build(), callback);
  }

  /**
   * Triggers the current scene transition. Same functionality as the `Transition` button in studio mode.
   */
  public void triggerStudioModeTransition(Consumer<TriggerStudioModeTransitionResponse> callback) {
    sendRequest(TriggerStudioModeTransitionRequest.builder().build(), callback);
  }

  /**
   * Sets the position of the TBar.
   *
   * **Very important note**: This will be deprecated and replaced in a future version of obs-websocket.
   *
   * @param position New position
   * @param release Whether to release the TBar. Only set `false` if you know that you will be sending another position update
   */
  public void setTBarPosition(Number position, Boolean release,
      Consumer<SetTBarPositionResponse> callback) {
    sendRequest(SetTBarPositionRequest.builder().position(position).release(release).build(), callback);
  }

  /**
   * Gets whether studio is enabled.
   */
  public void getStudioModeEnabled(Consumer<GetStudioModeEnabledResponse> callback) {
    sendRequest(GetStudioModeEnabledRequest.builder().build(), callback);
  }

  /**
   * Enables or disables studio mode
   *
   * @param studioModeEnabled True == Enabled, False == Disabled
   */
  public void setStudioModeEnabled(Boolean studioModeEnabled,
      Consumer<SetStudioModeEnabledResponse> callback) {
    sendRequest(SetStudioModeEnabledRequest.builder().studioModeEnabled(studioModeEnabled).build(), callback);
  }

  /**
   * Opens the properties dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   */
  public void openInputPropertiesDialog(String inputName,
      Consumer<OpenInputPropertiesDialogResponse> callback) {
    sendRequest(OpenInputPropertiesDialogRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Opens the filters dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   */
  public void openInputFiltersDialog(String inputName,
      Consumer<OpenInputFiltersDialogResponse> callback) {
    sendRequest(OpenInputFiltersDialogRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Opens the interact dialog of an input.
   *
   * @param inputName Name of the input to open the dialog of
   */
  public void openInputInteractDialog(String inputName,
      Consumer<OpenInputInteractDialogResponse> callback) {
    sendRequest(OpenInputInteractDialogRequest.builder().inputName(inputName).build(), callback);
  }

  /**
   * Gets a list of connected monitors and information about them.
   */
  public void getMonitorList(Consumer<GetMonitorListResponse> callback) {
    sendRequest(GetMonitorListRequest.builder().build(), callback);
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
   */
  public void openVideoMixProjector(VideoMixType videoMixType, Number monitorIndex,
      String projectorGeometry, Consumer<OpenVideoMixProjectorResponse> callback) {
    sendRequest(OpenVideoMixProjectorRequest.builder().videoMixType(videoMixType).monitorIndex(monitorIndex).projectorGeometry(projectorGeometry).build(), callback);
  }

  /**
   * Opens a projector for a source.
   *
   * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
   *
   * @param sourceName Name of the source to open a projector for
   * @param monitorIndex Monitor index, use `GetMonitorList` to obtain index
   * @param projectorGeometry Size/Position data for a windowed projector, in Qt Base64 encoded format. Mutually exclusive with `monitorIndex`
   */
  public void openSourceProjector(String sourceName, Number monitorIndex, String projectorGeometry,
      Consumer<OpenSourceProjectorResponse> callback) {
    sendRequest(OpenSourceProjectorRequest.builder().sourceName(sourceName).monitorIndex(monitorIndex).projectorGeometry(projectorGeometry).build(), callback);
  }
}
