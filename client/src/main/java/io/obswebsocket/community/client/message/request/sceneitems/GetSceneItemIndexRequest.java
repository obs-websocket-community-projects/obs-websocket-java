package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request.Data.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemIndexRequest extends SceneItemRequest<SceneItemRequest.DataWithId> {

  @Builder
  private GetSceneItemIndexRequest(String sceneName, Integer sceneItemId) {
    super(Type.GetSceneItemIndex, DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build());
  }

}
