package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetVideoSettingsResponse extends RequestResponse {

  private Data responseData;

  public GetVideoSettingsResponse() {
    super(Request.Type.GetVideoSettings);
  }

  @Getter
  @ToString
  public static class Data {

    private Integer baseWidth;
    private Integer baseHeight;
    private Integer outputWidth;
    private Integer outputHeight;
    private Double fpsNumerator;
    private Double fpsDenominator;
  }
}
