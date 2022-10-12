package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetVideoSettingsResponse extends RequestResponse<GetVideoSettingsResponse.Data> {
  public GetVideoSettingsResponse() {
    super(Request.Data.Type.GetVideoSettings);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Integer baseWidth;
    private Integer baseHeight;
    private Integer outputWidth;
    private Integer outputHeight;
    private Double fpsNumerator;
    private Double fpsDenominator;
  }
}
