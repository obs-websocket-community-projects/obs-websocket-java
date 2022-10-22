package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;

public enum MediaState {
  @SerializedName("none")
  NONE,
  @SerializedName("playing")
  PLAYING,
  @SerializedName("opening")
  OPENING,
  @SerializedName("buffering")
  BUFFERING,
  @SerializedName("paused")
  PAUSED,
  @SerializedName("stopped")
  STOPPED,
  @SerializedName("ended")
  ENDED,
  @SerializedName("error")
  ERROR,
  @SerializedName("unknown")
  UNKNOWN
}
