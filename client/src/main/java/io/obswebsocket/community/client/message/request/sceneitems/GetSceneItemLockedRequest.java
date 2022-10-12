package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemLockedRequest extends SceneItemRequest<SceneItemRequest.DataWithId> {
  @Builder
  private GetSceneItemLockedRequest(String sceneName, Integer sceneItemId) {
    super(Request.Data.Type.GetSceneItemLocked, DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build());
  }
}
