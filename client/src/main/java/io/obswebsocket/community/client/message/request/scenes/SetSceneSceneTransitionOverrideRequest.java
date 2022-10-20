// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetSceneSceneTransitionOverrideRequest extends Request<SetSceneSceneTransitionOverrideRequest.SpecificData> {
  @Builder
  private SetSceneSceneTransitionOverrideRequest(String sceneName, String transitionName,
      Number transitionDuration) {
    super(RequestType.SetSceneSceneTransitionOverride, SpecificData.builder().sceneName(sceneName).transitionName(transitionName).transitionDuration(transitionDuration).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;

    private String transitionName;

    private Number transitionDuration;
  }
}
