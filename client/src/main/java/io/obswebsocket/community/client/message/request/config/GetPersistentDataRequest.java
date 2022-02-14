package io.obswebsocket.community.client.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetPersistentDataRequest extends PersistentDataRequest {

  private final Data requestData;

  @Builder
  private GetPersistentDataRequest(String realm, String slotName) {
    super(Type.GetPersistentData);

    this.requestData = Data.builder().realm(realm).slotName(slotName).build();
  }

}
