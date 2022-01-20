package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneCollectionRequest extends Request {

  SceneCollectionRequest(Request.Data.Type requestType) {
    super(requestType);
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
    private final String sceneCollectionName;
  }
}
