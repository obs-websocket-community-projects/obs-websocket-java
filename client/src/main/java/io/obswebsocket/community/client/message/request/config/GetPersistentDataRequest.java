// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.config;

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
public class GetPersistentDataRequest extends Request<GetPersistentDataRequest.SpecificData> {
  @Builder
  private GetPersistentDataRequest(Realm realm, String slotName) {
    super(RequestType.GetPersistentData, SpecificData.builder().realm(realm).slotName(slotName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private Realm realm;

    @NonNull
    private String slotName;
  }
}
