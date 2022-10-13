package io.obswebsocket.community.client.message.response.transitions;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Transition;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetCurrentTransitionResponse extends RequestResponse<GetCurrentTransitionResponse.Data> {
  public GetCurrentTransitionResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data extends Transition {
    private Double transitionDuration;
    private Double transitionPosition; // optional
  }
}
