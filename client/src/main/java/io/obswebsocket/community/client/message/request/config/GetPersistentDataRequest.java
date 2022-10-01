package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetPersistentDataRequest extends PersistentDataRequest {
  @Builder
  private GetPersistentDataRequest(String realm, String slotName) {
    super(Request.Data.Type.GetPersistentData, SpecificData.builder().realm(realm).slotName(slotName).build());
  }
}
