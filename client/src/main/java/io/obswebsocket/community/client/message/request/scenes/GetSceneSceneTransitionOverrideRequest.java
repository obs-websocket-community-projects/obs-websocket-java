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
public class GetSceneSceneTransitionOverrideRequest extends Request<GetSceneSceneTransitionOverrideRequest.SpecificData> {
  @Builder
  private GetSceneSceneTransitionOverrideRequest(String sceneName) {
    super(RequestType.GetSceneSceneTransitionOverride, SpecificData.builder().sceneName(sceneName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;
  }
}
