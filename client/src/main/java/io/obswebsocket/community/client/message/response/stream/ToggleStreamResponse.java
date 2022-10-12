package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class ToggleStreamResponse extends RequestResponse<ToggleStreamResponse.Data> {
  public ToggleStreamResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Boolean outputActive;
  }
}
