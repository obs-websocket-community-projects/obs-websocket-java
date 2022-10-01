package io.obswebsocket.community.client.message.response.sources;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSourceScreenshotResponse extends RequestResponse<GetSourceScreenshotResponse.Data> {
  public GetSourceScreenshotResponse() {
    super(Request.Data.Type.GetSourceScreenshot);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private String imageData;
  }
}
