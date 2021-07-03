package io.obswebsocket.community.client.message.request.config;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetGlobalPersistentDataRequest extends GlobalPersistentDataRequest {

  private final Data requestData;

  @Builder
  private SetGlobalPersistentDataRequest(String slotName, JsonObject data) {
    super(Type.SetGlobalPersistentData);

    this.requestData = Data.builder().slotName(slotName).data(data).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends GlobalPersistentDataRequest.Data {

    @NonNull
    private final JsonObject data;  // TODO: type might change
  }

}
