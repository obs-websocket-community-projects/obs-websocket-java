package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleStreamResponse extends RequestResponse {

  private Data responseData;

  public ToggleStreamResponse() {
    super(Request.Data.Type.ToggleStream);
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean outputActive;
  }
}
