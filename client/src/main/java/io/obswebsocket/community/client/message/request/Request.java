package io.obswebsocket.community.client.message.request;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.request.config.*;
import io.obswebsocket.community.client.message.request.filters.*;
import io.obswebsocket.community.client.message.request.general.*;
import io.obswebsocket.community.client.message.request.inputs.*;
import io.obswebsocket.community.client.message.request.mediainputs.*;
import io.obswebsocket.community.client.message.request.outputs.*;
import io.obswebsocket.community.client.message.request.record.*;
import io.obswebsocket.community.client.message.request.sceneitems.*;
import io.obswebsocket.community.client.message.request.scenes.*;
import io.obswebsocket.community.client.message.request.sources.GetSourceActiveRequest;
import io.obswebsocket.community.client.message.request.sources.GetSourceScreenshotRequest;
import io.obswebsocket.community.client.message.request.sources.SaveSourceScreenshotRequest;
import io.obswebsocket.community.client.message.request.stream.*;
import io.obswebsocket.community.client.message.request.transitions.*;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.config.*;
import io.obswebsocket.community.client.message.response.filters.*;
import io.obswebsocket.community.client.message.response.general.*;
import io.obswebsocket.community.client.message.response.inputs.*;
import io.obswebsocket.community.client.message.response.mediainputs.*;
import io.obswebsocket.community.client.message.response.outputs.*;
import io.obswebsocket.community.client.message.response.record.*;
import io.obswebsocket.community.client.message.response.sceneitems.*;
import io.obswebsocket.community.client.message.response.scenes.*;
import io.obswebsocket.community.client.message.response.sources.GetSourceActiveResponse;
import io.obswebsocket.community.client.message.response.sources.GetSourceScreenshotResponse;
import io.obswebsocket.community.client.message.response.sources.SaveSourceScreenshotResponse;
import io.obswebsocket.community.client.message.response.stream.*;
import io.obswebsocket.community.client.message.response.transitions.*;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@ToString(callSuper = true)
public abstract class Request extends Message {

  protected Data data;

  protected Request(Data.Type type) {
    super(OperationCode.Request);

    this.data = Data.builder().requestType(type).requestId(UUID.randomUUID().toString()).build();
  }

  public String getRequestId() {
    return this.data.requestId;
  }

  public Data.Type getRequestType() {
    return this.data.requestType;
  }

  @SuperBuilder
  @Getter
  @ToString
  public static class Data {
    protected Type requestType;
    protected String requestId;

    @Getter
    public enum Type {
      // General
      GetVersion(GetVersionRequest.class, GetVersionResponse.class),
      BroadcastCustomEvent(BroadcastCustomEventRequest.class, BroadcastCustomEventResponse.class),
      GetSystemStats(GetSystemStatsRequest.class, GetSystemStatsResponse.class),
      GetHotkeyList(GetHotkeyListRequest.class, GetHotkeyListResponse.class),
      TriggerHotkeyByName(TriggerHotkeyByNameRequest.class, TriggerHotkeyByNameResponse.class),
      TriggerHotkeyByKeySequence(TriggerHotkeyByKeySequenceRequest.class,
              TriggerHotkeyByKeySequenceResponse.class),
      GetProjectorList(GetProjectorListRequest.class, GetProjectorListResponse.class),
      GetStudioModeEnabled(GetStudioModeEnabledRequest.class, GetStudioModeEnabledResponse.class),
      SetStudioModeEnabled(SetStudioModeEnabledRequest.class, SetStudioModeEnabledResponse.class),
      Sleep(SleepRequest.class, SleepResponse.class),
      OpenProjector(OpenProjectorRequest.class, OpenProjectorResponse.class),
      CloseProjector(CloseProjectorRequest.class, CloseProjectorResponse.class),
      GetStats(GetStatsRequest.class, GetSystemStatsResponse.class),

      // Config
      GetPersistentData(GetPersistentDataRequest.class,
              GetPersistentDataResponse.class),
      SetPersistentData(SetPersistentDataRequest.class,
              SetPersistentDataResponse.class),
      GetSceneCollectionList(GetSceneCollectionListRequest.class,
              GetSceneCollectionListResponse.class),
      SetCurrentSceneCollection(SetCurrentSceneCollectionRequest.class,
              SetCurrentSceneCollectionResponse.class),
      CreateSceneCollection(CreateSceneCollectionRequest.class, CreateSceneCollectionResponse.class),
      RemoveSceneCollection(RemoveSceneCollectionRequest.class, RemoveSceneCollectionResponse.class),
      GetProfileList(GetProfileListRequest.class, GetProfileListResponse.class),
      GetProfileParameter(GetProfileParameterRequest.class, GetProfileParameterResponse.class),
      SetProfileParameter(SetProfileParameterRequest.class, SetProfileParameterResponse.class),
      GetVideoSettings(GetVideoSettingsRequest.class, GetVideoSettingsResponse.class),
      SetCurrentProfile(SetCurrentProfileRequest.class, SetCurrentProfileResponse.class),
      CreateProfile(CreateProfileRequest.class, CreateProfileResponse.class),
      RemoveProfile(RemoveProfileRequest.class, RemoveProfileResponse.class),
      SetVideoSettings(SetVideoSettingsRequest.class, SetVideoSettingsResponse.class),

      // Scenes
      GetSceneList(GetSceneListRequest.class, GetSceneListResponse.class),
      GetCurrentProgramScene(GetCurrentProgramSceneRequest.class,
              GetCurrentProgramSceneResponse.class),
      SetCurrentProgramScene(SetCurrentProgramSceneRequest.class,
              SetCurrentProgramSceneResponse.class),
      GetCurrentPreviewScene(GetCurrentPreviewSceneRequest.class,
              GetCurrentPreviewSceneResponse.class),
      SetCurrentPreviewScene(SetCurrentPreviewSceneRequest.class,
              SetCurrentPreviewSceneResponse.class),
      CreateScene(CreateSceneRequest.class, CreateSceneResponse.class),
      SetSceneIndex(SetSceneIndexRequest.class, SetSceneIndexResponse.class),
      SetSceneName(SetSceneNameRequest.class, SetSceneNameResponse.class),
      RemoveScene(RemoveSceneRequest.class, RemoveSceneResponse.class),
      GetSceneTransitionOverride(GetSceneTransitionOverrideRequest.class,
              GetSceneTransitionOverrideResponse.class),
      SetSceneTransitionOverride(SetSceneTransitionOverrideRequest.class,
              SetSceneTransitionOverrideResponse.class),
      DeleteSceneTransitionOverride(DeleteSceneTransitionOverrideRequest.class,
              DeleteSceneTransitionOverrideResponse.class),

      // Sources
      GetSourceActive(GetSourceActiveRequest.class, GetSourceActiveResponse.class),
      GetSourceScreenshot(GetSourceScreenshotRequest.class, GetSourceScreenshotResponse.class),
      SaveSourceScreenshot(SaveSourceScreenshotRequest.class, SaveSourceScreenshotResponse.class),

      // Inputs
      GetInputList(GetInputListRequest.class, GetInputListResponse.class),
      GetInputKindList(GetInputKindListRequest.class, GetInputKindListResponse.class),
      GetInputDefaultSettings(GetInputDefaultSettingsRequest.class,
              GetInputDefaultSettingsResponse.class),
      GetInputSettings(GetInputSettingsRequest.class, GetInputSettingsResponse.class),
      SetInputSettings(SetInputSettingsRequest.class, SetInputSettingsResponse.class),
      GetInputMute(GetInputMuteRequest.class, GetInputMuteResponse.class),
      SetInputMute(SetInputMuteRequest.class, SetInputMuteResponse.class),
      ToggleInputMute(ToggleInputMuteRequest.class, ToggleInputMuteResponse.class),
      GetInputVolume(GetInputVolumeRequest.class, GetInputVolumeResponse.class),
      GetSpecialInputNames(GetSpecialInputNamesRequest.class, GetSpecialInputNamesResponse.class),
      SetInputName(SetInputNameRequest.class, SetInputNameResponse.class),
      SetInputVolume(SetInputVolumeRequest.class, SetInputVolumeResponse.class),
      CreateInput(CreateInputRequest.class, CreateInputResponse.class),
      RemoveInput(RemoveInputRequest.class, RemoveInputResponse.class),
      GetInputAudioTracks(GetInputAudioTracksRequest.class, GetInputAudioTracksResponse.class),
      GetInputAudioMonitorType(GetInputAudioMonitorTypeRequest.class,
              GetInputAudioMonitorTypeResponse.class),
      SetInputAudioMonitorType(SetInputAudioMonitorTypeRequest.class,
              SetInputAudioMonitorTypeResponse.class),
      GetInputAudioSyncOffset(GetInputAudioSyncOffsetRequest.class,
              GetInputAudioSyncOffsetResponse.class),
      SetInputAudioSyncOffset(SetInputAudioSyncOffsetRequest.class,
              SetInputAudioSyncOffsetResponse.class),
      GetInputPropertiesListPropertyItems(GetInputPropertiesListPropertyItemsRequest.class,
              GetInputPropertiesListPropertyItemsResponse.class),
      PressInputPropertiesButton(PressInputPropertiesButtonRequest.class,
              PressInputPropertiesButtonResponse.class),

      // Stream
      GetStreamStatus(GetStreamStatusRequest.class, GetStreamStatusResponse.class),
      ToggleStream(ToggleStreamRequest.class, ToggleStreamResponse.class),
      StartStream(StartStreamRequest.class, StartStreamResponse.class),
      StopStream(StopStreamRequest.class, StopStreamResponse.class),
      SendStreamCaption(SendStreamCaptionRequest.class, SendStreamCaptionResponse.class),
      GetStreamServiceSettings(GetStreamServiceSettingsRequest.class,
              GetStreamServiceSettingsResponse.class),
      SetStreamServiceSettings(SetStreamServiceSettingsRequest.class,
              SetStreamServiceSettingsResponse.class),

      // Transitions
      GetTransitionList(GetTransitionListRequest.class, GetTransitionListResponse.class),
      GetCurrentTransition(GetCurrentTransitionRequest.class, GetCurrentTransitionResponse.class),
      SetCurrentTransition(SetCurrentTransitionRequest.class, SetCurrentTransitionResponse.class),
      SetCurrentTransitionDuration(SetCurrentTransitionDurationRequest.class,
              SetCurrentTransitionDurationResponse.class),
      GetTransitionSettings(GetTransitionSettingsRequest.class, GetTransitionSettingsResponse.class),
      SetTransitionSettings(SetTransitionSettingsRequest.class, SetTransitionSettingsResponse.class),
      ReleaseTbar(ReleaseTbarRequest.class, ReleaseTbarResponse.class),
      SetTbarPosition(SetTbarPositionRequest.class, SetTbarPositionResponse.class),
      TriggerStudioModeTransition(TriggerStudioModeTransitionRequest.class,
              TriggerStudioModeTransitionResponse.class),

      // Filters
      GetSourceFilterList(GetSourceFilterListRequest.class, GetSourceFilterListResponse.class),
      GetSourceFilter(GetSourceFilterRequest.class, GetSourceFilterResponse.class),
      SetSourceFilterIndex(SetSourceFilterIndexRequest.class, SetSourceFilterIndexResponse.class),
      SetSourceFilterSettings(SetSourceFilterSettingsRequest.class,
              SetSourceFilterSettingsResponse.class),
      SetSourceFilterEnabled(SetSourceFilterEnabledRequest.class,
              SetSourceFilterEnabledResponse.class),
      CreateSourceFilter(CreateSourceFilterRequest.class, CreateSourceFilterResponse.class),
      RemoveSourceFilter(RemoveSourceFilterRequest.class, RemoveSourceFilterResponse.class),

      // Scene Items
      GetSceneItemList(GetSceneItemListRequest.class, GetSceneItemListResponse.class),
      GetSceneItemEnabled(GetSceneItemEnabledRequest.class, GetSceneItemEnabledResponse.class),
      SetSceneItemEnabled(SetSceneItemEnabledRequest.class, SetSceneItemEnabledResponse.class),
      GetSceneItemLocked(GetSceneItemLockedRequest.class, GetSceneItemLockedResponse.class),
      SetSceneItemLocked(SetSceneItemLockedRequest.class, SetSceneItemLockedResponse.class),
      GetSceneItemColor(GetSceneItemColorRequest.class, GetSceneItemColorResponse.class),
      SetSceneItemIndex(SetSceneItemIndexRequest.class, SetSceneItemIndexResponse.class),
      CreateSceneItem(CreateSceneItemRequest.class, CreateSceneItemResponse.class),
      RemoveSceneItem(RemoveSceneItemRequest.class, RemoveSceneItemResponse.class),
      DuplicateSceneItem(DuplicateSceneItemRequest.class, DuplicateSceneItemResponse.class),

      // Outputs
      GetReplayBufferStatus(GetReplayBufferStatusRequest.class, GetReplayBufferStatusResponse.class),
      ToggleReplayBuffer(ToggleReplayBufferRequest.class, ToggleReplayBufferResponse.class),
      StartReplayBuffer(StartReplayBufferRequest.class, StartReplayBufferResponse.class),
      StopReplayBuffer(StopReplayBufferRequest.class, StopReplayBufferResponse.class),
      SaveReplayBuffer(SaveReplayBufferRequest.class, SaveReplayBufferResponse.class),
      GetLastReplayBufferReplay(GetLastReplayBufferReplayRequest.class,
              GetLastReplayBufferReplayResponse.class),
      GetOutputList(GetOutputListRequest.class, GetOutputListResponse.class),
      ToggleOutput(ToggleOutputRequest.class, ToggleOutputResponse.class),
      StartOutput(StartOutputRequest.class, StartOutputResponse.class),
      StopOutput(StopOutputRequest.class, StopOutputResponse.class),

      // Record
      GetRecordStatus(GetRecordStatusRequest.class, GetRecordStatusResponse.class),
      ToggleRecord(ToggleRecordRequest.class, ToggleRecordResponse.class),
      StartRecord(StartRecordRequest.class, StartRecordResponse.class),
      StopRecord(StopRecordRequest.class, StopRecordResponse.class),
      ToggleRecordPause(ToggleRecordPauseRequest.class, ToggleRecordPauseResponse.class),
      PauseRecord(PauseRecordRequest.class, PauseRecordResponse.class),
      ResumeRecord(ResumeRecordRequest.class, ResumeRecordResponse.class),
      GetRecordDirectory(GetRecordDirectoryRequest.class, GetRecordDirectoryResponse.class),
      SetRecordDirectory(SetRecordDirectoryRequest.class, SetRecordDirectoryResponse.class),
      GetRecordFilenameFormatting(GetRecordFilenameFormattingRequest.class,
              GetRecordFilenameFormattingResponse.class),
      SetRecordFilenameFormatting(SetRecordFilenameFormattingRequest.class,
              SetRecordFilenameFormattingResponse.class),

      // Media Inputs
      GetMediaInputStatus(GetMediaInputStatusRequest.class, GetMediaInputStatusResponse.class),
      OffsetMediaInputTimecode(OffsetMediaInputTimecodeRequest.class,
              OffsetMediaInputTimecodeResponse.class),
      SetMediaInputTimecode(SetMediaInputTimecodeRequest.class, SetMediaInputTimecodeResponse.class),
      SetMediaInputPauseState(SetMediaInputPauseStateRequest.class,
              SetMediaInputPauseStateResponse.class),
      StopMediaInput(StopMediaInputRequest.class, StopMediaInputResponse.class),
      RestartMediaInput(RestartMediaInputRequest.class, RestartMediaInputResponse.class),
      NextMediaInputPlaylistItem(NextMediaInputPlaylistItemRequest.class,
              NextMediaInputPlaylistItemResponse.class),
      PreviousMediaInputPlaylistItem(PreviousMediaInputPlaylistItemRequest.class,
              PreviousMediaInputPlaylistItemResponse.class),
      ;

      private final Class<? extends Request> requestClass;
      private final Class<? extends RequestResponse> requestResponseClass;

      Type(Class<? extends Request> requestClass,
           Class<? extends RequestResponse> requestResponseClass) {
        this.requestClass = requestClass;
        this.requestResponseClass = requestResponseClass;
      }
    }
  }

}
