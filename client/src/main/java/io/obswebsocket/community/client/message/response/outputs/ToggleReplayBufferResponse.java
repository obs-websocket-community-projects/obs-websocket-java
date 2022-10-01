package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class ToggleReplayBufferResponse extends RequestResponse<ToggleReplayBufferResponse.Data> {
  public ToggleReplayBufferResponse() {
    super(Request.Data.Type.ToggleReplayBuffer);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Boolean replayBufferActive;
  }
}
