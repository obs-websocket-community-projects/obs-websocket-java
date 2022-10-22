package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;

public enum VideoMixType {
  @SerializedName("OBS_WEBSOCKET_VIDEO_MIX_TYPE_PREVIEW")
  Preview,
  @SerializedName("OBS_WEBSOCKET_VIDEO_MIX_TYPE_PROGRAM")
  Program,
  @SerializedName("OBS_WEBSOCKET_VIDEO_MIX_TYPE_MULTIVIEW")
  Multiview
}
