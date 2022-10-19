package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentTransitionDurationRequest extends Request<SetCurrentTransitionDurationRequest.Data> {
  @Builder
  private SetCurrentTransitionDurationRequest(Integer transitionDuration) {
    super(RequestType.SetCurrentTransitionDuration,
        Data.builder().transitionDuration(transitionDuration).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final Integer transitionDuration;
  }
}
