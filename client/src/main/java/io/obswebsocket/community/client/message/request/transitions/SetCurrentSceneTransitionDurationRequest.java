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
public class SetCurrentSceneTransitionDurationRequest extends Request<SetCurrentSceneTransitionDurationRequest.SpecificData> {
  @Builder
  private SetCurrentSceneTransitionDurationRequest(Number transitionDuration) {
    super(RequestType.SetCurrentSceneTransitionDuration, SpecificData.builder().transitionDuration(transitionDuration).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private Number transitionDuration;
  }
}
