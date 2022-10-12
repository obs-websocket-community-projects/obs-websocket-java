package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneItemRequest<T extends SceneItemRequest.Data> extends Request<T> {

  SceneItemRequest(Request.Data.Type type, T data) {
    super(type, data);
  }

  @Getter
  @ToString
  @SuperBuilder(builderMethodName = "dataBuilder")
  static class Data {

    @NonNull
    private final String sceneName;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class DataWithId extends Data {

    @NonNull
    private final Integer sceneItemId;
  }
}
