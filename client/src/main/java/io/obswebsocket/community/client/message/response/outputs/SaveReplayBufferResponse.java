package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SaveReplayBufferResponse extends RequestResponse<Void> {
  public SaveReplayBufferResponse() {
    super(Request.Data.Type.SaveReplayBuffer);
  }
}
