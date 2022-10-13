package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneRequest<T extends SceneRequest.Data> extends Request<T> {

  SceneRequest(Request.Data.Type requestType, T data) {
    super(requestType, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends Request.Data {

    @NonNull
    private final String sceneName;
  }
}
