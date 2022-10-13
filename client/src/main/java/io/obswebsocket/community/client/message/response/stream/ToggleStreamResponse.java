package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleStreamResponse extends RequestResponse<ToggleStreamResponse.Data> {
  public ToggleStreamResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Boolean outputActive;
  }
}
