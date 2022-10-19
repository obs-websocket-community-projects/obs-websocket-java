package io.obswebsocket.community.client.message.request.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class PersistentDataRequest extends Request<PersistentDataRequest.SpecificData> {

  PersistentDataRequest(RequestType type, SpecificData data) {
    super(type, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  static class SpecificData {

    @NonNull
    private final Realm realm;
    @NonNull
    private final String slotName;

    public enum Realm {
      @SerializedName("OBS_WEBSOCKET_DATA_REALM_GLOBAL")
      GLOBAL,
      @SerializedName("OBS_WEBSOCKET_DATA_REALM_PROFILE")
      PROFILE;
    }
  }
}
