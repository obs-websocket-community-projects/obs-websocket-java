package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;

public enum Realm {
  @SerializedName("OBS_WEBSOCKET_DATA_REALM_GLOBAL")
  GLOBAL,
  @SerializedName("OBS_WEBSOCKET_DATA_REALM_PROFILE")
  PROFILE
}
