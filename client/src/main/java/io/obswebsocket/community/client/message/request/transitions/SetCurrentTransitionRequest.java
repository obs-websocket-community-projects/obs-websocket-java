package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentTransitionRequest extends TransitionRequest {

  private final Data requestData;

  @Builder
  private SetCurrentTransitionRequest(String transitionName) {
    super(Request.Data.Type.SetCurrentTransition);

    this.requestData = Data.builder().transitionName(transitionName).build();
  }
}
