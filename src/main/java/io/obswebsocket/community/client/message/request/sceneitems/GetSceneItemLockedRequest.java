package io.obswebsocket.community.client.message.request.sceneitems;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemLockedRequest extends SceneItemRequest {

  private final DataWithId requestData;

  @Builder
  private GetSceneItemLockedRequest(String sceneName, Integer sceneItemId) {
    super(Type.GetSceneItemLocked);

    this.requestData = DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build();
  }
}
