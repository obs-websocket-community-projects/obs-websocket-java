package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetTbarPositionRequest extends Request {

  private final Data requestData;

  @Builder
  private SetTbarPositionRequest(Double position, Boolean release) {
    super(Type.SetTbarPosition);

    this.requestData = Data.builder().position(position).release(release).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final Double position;
    @NonNull
    private final Boolean release;
  }
}
