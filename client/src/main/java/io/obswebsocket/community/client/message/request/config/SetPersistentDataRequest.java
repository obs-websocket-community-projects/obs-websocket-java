package io.obswebsocket.community.client.message.request.config;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetPersistentDataRequest extends PersistentDataRequest {

  private final Data requestData;

  @Builder
  private SetPersistentDataRequest(String realm, String slotName, JsonObject data) {
    super(Type.SetPersistentData);

    this.requestData = Data.builder().realm(realm).slotName(slotName).data(data).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends PersistentDataRequest.Data {

    @NonNull
    private final JsonObject data;  // TODO: type might change
  }

}
