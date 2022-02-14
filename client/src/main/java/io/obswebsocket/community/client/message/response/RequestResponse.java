package io.obswebsocket.community.client.message.response;

import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public abstract class RequestResponse extends Message {

  protected Request.Type requestType;
  protected String requestId;
  protected Status requestStatus;

  protected RequestResponse(Request.Type requestType) {
    super(Type.RequestResponse);

    this.requestType = requestType;
  }

  public boolean isSuccessful() {
    return this.requestStatus != null && this.requestStatus.result;
  }

  @Getter
  @ToString
  public static class Status {

    protected Boolean result;
    protected Integer code;
    protected String comment;

    enum Code {
      Unknown(0),

      // For internal use to signify a successful parameter check
      NoError(10),

      Success(100),

      // The `requestType` field is missing from the request data
      MissingRequestType(203),
      // The request type is invalid (does not exist)
      UnknownRequestType(204),
      // Generic error code (comment is expected to be provided)
      GenericError(205),

      // A required request parameter is missing
      MissingRequestParameter(300),
      // The request does not have a valid requestData object.
      MissingRequestData(301),

      // Generic invalid request parameter message
      InvalidRequestParameter(400),
      // A request parameter has the wrong data type
      InvalidRequestParameterDataType(401),
      // A request parameter (float or int) is out of valid range
      RequestParameterOutOfRange(402),
      // A request parameter (string or array) is empty and cannot be
      RequestParameterEmpty(403),

      // An output is running and cannot be in order to perform the request (generic)
      OutputRunning(500),
      // An output is not running and should be
      OutputNotRunning(501),
      // Stream is running and cannot be
      StreamRunning(502),
      // Stream is not running and should be
      StreamNotRunning(503),
      // Record is running and cannot be
      RecordRunning(504),
      // Record is not running and should be
      RecordNotRunning(505),
      // Record is paused and cannot be
      RecordPaused(506),
      // Replay buffer is running and cannot be
      ReplayBufferRunning(507),
      // Replay buffer is not running and should be
      ReplayBufferNotRunning(508),
      // Replay buffer is disabled and cannot be
      ReplayBufferDisabled(509),
      // Studio mode is active and cannot be
      StudioModeActive(510),
      // Studio mode is not active and should be
      StudioModeNotActive(511),
      // Virtualcam is running and cannot be
      VirtualcamRunning(512),
      // Virtualcam is not running and should be
      VirtualcamNotRunning(513),

      // The specified source (obs_source_t) was of the invalid type (Eg. input instead of scene)
      InvalidSourceType(600),
      // The specified source (obs_source_t) was not found (generic for input, filter, transition, scene)
      SourceNotFound(601),
      // The specified source (obs_source_t) already exists. Applicable to inputs, filters, transitions, scenes
      SourceAlreadyExists(602),
      // The specified input (obs_source_t-OBS_SOURCE_TYPE_FILTER) was not found
      InputNotFound(603),
      // The specified input (obs_source_t-OBS_SOURCE_TYPE_INPUT) had the wrong kind
      InvalidInputKind(604),
      // The specified filter (obs_source_t-OBS_SOURCE_TYPE_FILTER) was not found
      FilterNotFound(605),
      // The specified transition (obs_source_t-OBS_SOURCE_TYPE_TRANSITION) was not found
      TransitionNotFound(606),
      // The specified transition (obs_source_t-OBS_SOURCE_TYPE_TRANSITION) does not support setting its position (transition is of fixed type)
      TransitionDurationFixed(607),
      // The specified scene (obs_source_t-OBS_SOURCE_TYPE_SCENE), (obs_scene_t) was not found
      SceneNotFound(608),
      // The specified scene item (obs_sceneitem_t) was not found
      SceneItemNotFound(609),
      // The specified scene collection was not found
      SceneCollectionNotFound(610),
      // The specified profile was not found
      ProfileNotFound(611),
      // The specified output (obs_output_t) was not found
      OutputNotFound(612),
      // The specified encoder (obs_encoder_t) was not found
      EncoderNotFound(613),
      // The specified service (obs_service_t) was not found
      ServiceNotFound(614),
      // The specified hotkey was not found
      HotkeyNotFound(615),
      // The specified directory was not found
      DirectoryNotFound(616),
      // The specified config item (config_t) was not found. Could be section or parameter name
      ConfigParameterNotFound(617),
      // The specified property (obs_properties_t) was not found
      PropertyNotFound(618),
      // The specififed key (OBS_KEY_*) was not found
      KeyNotFound(619),

      // Processing the request failed unexpectedly
      RequestProcessingFailed(700),
      // Starting the Output failed
      OutputStartFailed(701),
      // Duplicating the scene item failed
      SceneItemDuplicationFailed(702),
      // Rendering the screenshot failed
      ScreenshotRenderFailed(703),
      // Encoding the screenshot failed
      ScreenshotEncodeFailed(704),
      // Saving the screenshot failed
      ScreenshotSaveFailed(705),
      // Creating the directory failed
      DirectoryCreationFailed(706),
      // The combination of request parameters cannot be used to perform an action
      CannotAct(707);


      private final int value;

      Code(int value) {
        this.value = value;
      }
    }
  }
}
