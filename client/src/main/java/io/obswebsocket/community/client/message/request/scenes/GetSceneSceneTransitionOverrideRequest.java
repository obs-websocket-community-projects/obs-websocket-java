package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneSceneTransitionOverrideRequest extends SceneRequest<SceneRequest.Data> {

  @Builder
  private GetSceneSceneTransitionOverrideRequest(String sceneName) {
    super(Request.Data.Type.GetSceneSceneTransitionOverride,
        Data.builder().sceneName(sceneName).build());
  }
}
