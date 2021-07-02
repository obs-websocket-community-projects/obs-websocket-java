package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleReplayBufferResponse extends RequestResponse {

  private Data responseData;

  public ToggleReplayBufferResponse() {
    super(Request.Type.ToggleReplayBuffer);
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean replayBufferActive;
  }
}
