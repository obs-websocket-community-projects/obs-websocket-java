package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class PersistentDataRequest extends Request {

  PersistentDataRequest(Request.Data.Type type) {
    super(type);
  }

  @SuperBuilder
  @Getter
  @ToString
  static class Data extends Request.Data {
    private SpecificData requestData;
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
