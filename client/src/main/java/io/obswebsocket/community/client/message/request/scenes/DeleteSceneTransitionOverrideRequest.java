package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class DeleteSceneTransitionOverrideRequest extends SceneRequest<SceneRequest.Data> {
  @Builder
  private DeleteSceneTransitionOverrideRequest(String sceneName) {
    super(Request.Data.Type.DeleteSceneTransitionOverride, Data.builder().sceneName(sceneName).build());
  }
}
