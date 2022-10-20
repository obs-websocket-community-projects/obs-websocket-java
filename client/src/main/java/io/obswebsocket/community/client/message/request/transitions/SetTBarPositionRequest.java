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
public class SetTBarPositionRequest extends Request<SetTBarPositionRequest.SpecificData> {
  @Builder
  private SetTBarPositionRequest(Number position, Boolean release) {
    super(RequestType.SetTBarPosition, SpecificData.builder().position(position).release(release).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private Number position;

    private Boolean release;
  }
}
