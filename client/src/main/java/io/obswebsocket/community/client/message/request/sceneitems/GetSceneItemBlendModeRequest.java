package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;

public class GetSceneItemBlendModeRequest extends SceneItemRequest<SceneItemRequest.DataWithId> {

  @Builder
  private GetSceneItemBlendModeRequest(String sceneName, Integer sceneItemId) {
    super(RequestType.GetSceneItemBlendMode,
        DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build());
  }

}
