package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;

public enum SceneItemBlendMode {
  @SerializedName("OBS_BLEND_NORMAL")
  NORMAL,
  @SerializedName("OBS_BLEND_ADDITIVE")
  ADDITIVE,
  @SerializedName("OBS_BLEND_SUBTRACT")
  SUBTRACT,
  @SerializedName("OBS_BLEND_SCREEN")
  SCREEN,
  @SerializedName("OBS_BLEND_MULTIPLY")
  MULTIPLY,
  @SerializedName("OBS_BLEND_LIGHTEN")
  LIGHTEN,
  @SerializedName("OBS_BLEND_DARKEN")
  DARKEN
}
