package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneItemRequest extends Request {

  SceneItemRequest(Request.Data.Type type) {
    super(type);
  }

  @Getter
  @ToString
  @SuperBuilder
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
