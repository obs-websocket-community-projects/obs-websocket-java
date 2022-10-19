package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemLockedRequest extends SceneItemRequest<SceneItemRequest.DataWithId> {
  @Builder
  private GetSceneItemLockedRequest(String sceneName, Integer sceneItemId) {
    super(RequestType.GetSceneItemLocked,
        DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build());
  }
}
