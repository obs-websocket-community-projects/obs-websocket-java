package io.obswebsocket.community.client.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneTransitionOverrideRequest extends SceneRequest {

  private final Data requestData;

  @Builder
  private SetSceneTransitionOverrideRequest(String sceneName, String transitionName,
      Integer transitionDuration) {
    super(Type.SetSceneTransitionOverride);

    this.requestData = Data.builder().sceneName(sceneName).transitionName(transitionName)
        .transitionDuration(transitionDuration).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends SceneRequest.Data {

    private final String transitionName; // optional
    private final Integer transitionDuration; // optional
  }
}
