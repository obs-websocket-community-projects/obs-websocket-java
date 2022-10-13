package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneRequest extends SceneRequest<SceneRequest.Data> {
  @Builder
  private CreateSceneRequest(String sceneName) {
    super(Request.Data.Type.CreateScene, Data.builder().sceneName(sceneName).build());
  }
}
