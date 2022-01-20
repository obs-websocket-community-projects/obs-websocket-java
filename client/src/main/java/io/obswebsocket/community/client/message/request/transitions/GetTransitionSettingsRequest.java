package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetTransitionSettingsRequest extends TransitionRequest {

  private final Data requestData;

  @Builder
  private GetTransitionSettingsRequest(String transitionName) {
    super(Request.Data.Type.GetTransitionSettings);

    this.requestData = Data.builder().transitionName(transitionName).build();
  }
}
