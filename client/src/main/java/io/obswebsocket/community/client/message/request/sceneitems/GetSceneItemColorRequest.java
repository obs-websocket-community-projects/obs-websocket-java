package io.obswebsocket.community.client.message.request.sceneitems;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemColorRequest extends SceneItemRequest {

  private final DataWithId requestData;

  @Builder
  private GetSceneItemColorRequest(String sceneName, Integer sceneItemId) {
    super(Type.GetSceneItemColor);

    this.requestData = DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build();
  }
}
