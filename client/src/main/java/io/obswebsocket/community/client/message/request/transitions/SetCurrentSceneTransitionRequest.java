// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.transitions;

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
public class SetCurrentSceneTransitionRequest extends Request<SetCurrentSceneTransitionRequest.SpecificData> {
  @Builder
  private SetCurrentSceneTransitionRequest(String transitionName) {
    super(RequestType.SetCurrentSceneTransition, SpecificData.builder().transitionName(transitionName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String transitionName;
  }
}
