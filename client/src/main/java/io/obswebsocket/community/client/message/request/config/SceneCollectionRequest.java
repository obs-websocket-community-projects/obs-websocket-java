package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneCollectionRequest<T extends SceneCollectionRequest.SpecificData> extends Request<T> {

  SceneCollectionRequest(RequestType requestType, T data) {
    super(requestType, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  static class SpecificData {

    @NonNull
    private final String sceneCollectionName;
  }
}
