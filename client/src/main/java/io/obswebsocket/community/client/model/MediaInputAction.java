package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;

public enum MediaInputAction {
  @SerializedName("OBS_WEBSOCKET_MEDIA_INPUT_ACTION_NONE")
  NONE,
  @SerializedName("OBS_WEBSOCKET_MEDIA_INPUT_ACTION_PLAY")
  PLAY,
  @SerializedName("OBS_WEBSOCKET_MEDIA_INPUT_ACTION_PAUSE")
  PAUSE,
  @SerializedName("OBS_WEBSOCKET_MEDIA_INPUT_ACTION_STOP")
  STOP,
  @SerializedName("OBS_WEBSOCKET_MEDIA_INPUT_ACTION_RESTART")
  RESTART,
  @SerializedName("OBS_WEBSOCKET_MEDIA_INPUT_ACTION_NEXT")
  NEXT,
  @SerializedName("OBS_WEBSOCKET_MEDIA_INPUT_ACTION_PREVIOUS")
  PREVIOUS
}