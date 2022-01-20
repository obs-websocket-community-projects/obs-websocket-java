package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemColorRequest extends SceneItemRequest {

  private final DataWithId requestData;

  @Builder
  private GetSceneItemColorRequest(String sceneName, Integer sceneItemId) {
    super(Request.Data.Type.GetSceneItemColor);

    this.requestData = DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build();
  }
}
