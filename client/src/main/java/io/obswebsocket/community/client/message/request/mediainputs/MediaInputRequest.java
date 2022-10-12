package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class MediaInputRequest<T extends MediaInputRequest.Data> extends Request<T> {

  MediaInputRequest(Request.Data.Type type, T data) {
    super(type, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data {

    @NonNull
    private final String inputName;
  }
}
