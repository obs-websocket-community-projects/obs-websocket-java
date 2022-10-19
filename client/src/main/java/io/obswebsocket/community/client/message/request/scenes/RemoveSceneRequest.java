package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneRequest extends SceneRequest<SceneRequest.Data> {
  @Builder
  private RemoveSceneRequest(String sceneName) {
    super(RequestType.RemoveScene, Data.builder().sceneName(sceneName).build());
  }
}
