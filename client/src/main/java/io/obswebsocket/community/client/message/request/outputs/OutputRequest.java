package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class OutputRequest<T extends OutputRequest.Data> extends Request<T> {

  OutputRequest(Request.Data.Type type, T data) {
    super(type, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data {

    @NonNull
    private final String outputName;
  }
}
