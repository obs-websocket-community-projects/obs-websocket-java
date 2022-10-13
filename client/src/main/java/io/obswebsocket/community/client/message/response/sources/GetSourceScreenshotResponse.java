package io.obswebsocket.community.client.message.response.sources;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceScreenshotResponse extends RequestResponse<GetSourceScreenshotResponse.Data> {
  public GetSourceScreenshotResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private String imageData;
  }
}
