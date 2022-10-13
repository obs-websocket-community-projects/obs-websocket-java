package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request.Data.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneItemTransformRequest extends SceneItemRequest<SetSceneItemTransformRequest.Data> {

  @Builder
  private SetSceneItemTransformRequest(String sceneName, Integer sceneItemId, Object sceneItemTransform) {
    super(Type.SetSceneItemTransform, Data.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemTransform(sceneItemTransform).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends SceneItemRequest.DataWithId {

    @NonNull
    // TODO: Find actual type
    private Object sceneItemTransform;
  }
}
