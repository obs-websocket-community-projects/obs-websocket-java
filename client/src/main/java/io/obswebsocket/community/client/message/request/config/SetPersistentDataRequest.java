package io.obswebsocket.community.client.message.request.config;

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
  private SetPersistentDataRequest(String realm, String slotName, Object slotValue) {
    super(Type.SetPersistentData);

    this.requestData = Data.builder().realm(realm).slotName(slotName).slotValue(slotValue).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends PersistentDataRequest.Data {

    @NonNull
    private final Object slotValue;  // TODO: type might change
  }

}
