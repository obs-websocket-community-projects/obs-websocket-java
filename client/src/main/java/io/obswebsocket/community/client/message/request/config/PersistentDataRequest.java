package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class PersistentDataRequest extends Request<PersistentDataRequest.SpecificData> {

  PersistentDataRequest(Request.Data.Type type, SpecificData data) {
    super(type, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  static class SpecificData {

    @NonNull
    private final String realm;
    @NonNull
    private final String slotName;
  }
}
