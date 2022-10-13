package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetReplayBufferStatusRequest extends Request<Void> {
  @Builder
  private GetReplayBufferStatusRequest() {
    super(Data.Type.GetReplayBufferStatus, null);
  }
}
