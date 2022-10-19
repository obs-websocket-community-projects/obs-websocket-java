package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneSceneTransitionOverrideRequest extends SceneRequest<SceneRequest.Data> {

  @Builder
  private GetSceneSceneTransitionOverrideRequest(String sceneName) {
    super(RequestType.GetSceneSceneTransitionOverride,
        Data.builder().sceneName(sceneName).build());
  }
}
