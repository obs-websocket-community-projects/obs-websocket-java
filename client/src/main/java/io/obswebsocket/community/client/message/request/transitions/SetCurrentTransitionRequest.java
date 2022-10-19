package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentTransitionRequest extends TransitionRequest<TransitionRequest.Data> {
  @Builder
  private SetCurrentTransitionRequest(String transitionName) {
    super(RequestType.SetCurrentTransition, Data.builder().transitionName(transitionName).build());
  }
}
