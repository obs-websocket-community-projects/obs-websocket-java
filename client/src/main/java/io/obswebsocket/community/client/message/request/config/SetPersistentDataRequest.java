package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.message.request.config.PersistentDataRequest.SpecificData.Realm;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetPersistentDataRequest extends PersistentDataRequest {
  @Builder
  private SetPersistentDataRequest(Realm realm, String slotName, Object slotValue) {
    super(RequestType.SetPersistentData,
        SpecificData.builder().realm(realm).slotName(slotName).slotValue(slotValue).build());
  }

  @Getter
  @ToString
  @SuperBuilder
  static class SpecificData extends PersistentDataRequest.SpecificData {

    @NonNull
    private final Object slotValue;
  }
}
