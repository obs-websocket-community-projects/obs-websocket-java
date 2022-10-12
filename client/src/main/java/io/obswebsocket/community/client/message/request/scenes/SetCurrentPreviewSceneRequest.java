package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentPreviewSceneRequest extends SceneRequest<SceneRequest.Data> {
  @Builder
  private SetCurrentPreviewSceneRequest(String sceneName) {
    super(Request.Data.Type.SetCurrentPreviewScene, Data.builder().sceneName(sceneName).build());
  }
}
