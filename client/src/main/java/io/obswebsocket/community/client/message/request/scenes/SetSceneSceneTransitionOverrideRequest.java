package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneSceneTransitionOverrideRequest extends
    SceneRequest<SetSceneSceneTransitionOverrideRequest.Data> {

  @Builder
  private SetSceneSceneTransitionOverrideRequest(String sceneName, String transitionName,
      Integer transitionDuration) {
    super(Request.Data.Type.SetSceneSceneTransitionOverride,
        Data.builder().sceneName(sceneName).transitionName(transitionName)
            .transitionDuration(transitionDuration).build());
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends SceneRequest.Data {

    private final String transitionName; // optional
    private final Integer transitionDuration; // optional
  }
}
