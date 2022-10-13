package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetVideoSettingsResponse extends RequestResponse<GetVideoSettingsResponse.Data> {
  public GetVideoSettingsResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {

    private Double fpsNumerator;
    private Double fpsDenominator;
    private Integer baseWidth;
    private Integer baseHeight;
    private Integer outputWidth;
    private Integer outputHeight;
  }
}
