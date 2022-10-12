package io.obswebsocket.community.client.message.request.filters;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class FilterRequest<T extends FilterRequest.Data> extends Request<T> {

  FilterRequest(Request.Data.Type requestType, T data) {
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
