package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StartReplayBufferResponse extends RequestResponse<Void> {
  public StartReplayBufferResponse() {
    super();
  }
}
