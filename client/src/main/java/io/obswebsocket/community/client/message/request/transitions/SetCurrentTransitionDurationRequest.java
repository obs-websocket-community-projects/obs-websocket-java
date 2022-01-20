package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentTransitionDurationRequest extends Request {

  private final Data requestData;

  @Builder
  private SetCurrentTransitionDurationRequest(Integer transitionDuration) {
    super(Request.Data.Type.SetCurrentTransitionDuration);

    this.requestData = Data.builder().transitionDuration(transitionDuration).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final Integer transitionDuration;
  }
}
