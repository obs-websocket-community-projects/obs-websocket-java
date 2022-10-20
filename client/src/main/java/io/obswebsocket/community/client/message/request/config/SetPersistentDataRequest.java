// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.config;

import com.google.gson.JsonElement;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.Realm;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetPersistentDataRequest extends Request<SetPersistentDataRequest.SpecificData> {
  @Builder
  private SetPersistentDataRequest(Realm realm, String slotName, JsonElement slotValue) {
    super(RequestType.SetPersistentData, SpecificData.builder().realm(realm).slotName(slotName).slotValue(slotValue).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private Realm realm;

    @NonNull
    private String slotName;

    @NonNull
    private JsonElement slotValue;
  }
}
