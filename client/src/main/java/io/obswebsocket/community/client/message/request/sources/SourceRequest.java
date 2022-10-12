package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SourceRequest<T extends SourceRequest.Data> extends Request<T> {

  SourceRequest(Request.Data.Type requestType, T data) {
    super(requestType, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data {

    @NonNull
    private final String sourceName;
  }
}
