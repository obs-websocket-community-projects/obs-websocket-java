package io.obswebsocket.community.client.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetGlobalPersistentDataRequest extends GlobalPersistentDataRequest {

  private final Data requestData;

  @Builder
  private GetGlobalPersistentDataRequest(String slotName) {
    super(Type.GetGlobalPersistentData);

    this.requestData = Data.builder().slotName(slotName).build();
  }

}
