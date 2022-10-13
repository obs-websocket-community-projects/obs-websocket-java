package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request.Data.Type;
import lombok.Builder;

public class GetSceneItemBlendModeRequest extends SceneItemRequest<SceneItemRequest.DataWithId> {

  @Builder
  private GetSceneItemBlendModeRequest(String sceneName, Integer sceneItemId) {
    super(Type.GetSceneItemBlendMode, DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build());
  }

}
