package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneItemRequest extends SceneItemRequest {

  private final DataWithId requestData;

  @Builder
  private RemoveSceneItemRequest(String sceneName, Integer sceneItemId) {
    super(Request.Data.Type.RemoveSceneItem);

    this.requestData = DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build();
  }
}
