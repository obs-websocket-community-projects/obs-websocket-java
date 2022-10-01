package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneTransitionOverrideRequest extends SceneRequest<SceneRequest.Data> {
  @Builder
  private GetSceneTransitionOverrideRequest(String sceneName) {
    super(Request.Data.Type.GetSceneTransitionOverride, Data.builder().sceneName(sceneName).build());
  }
}
