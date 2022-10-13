package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneRequest extends SceneRequest<SceneRequest.Data> {
  @Builder
  private RemoveSceneRequest(String sceneName) {
    super(Request.Data.Type.RemoveScene, Data.builder().sceneName(sceneName).build());
  }
}
