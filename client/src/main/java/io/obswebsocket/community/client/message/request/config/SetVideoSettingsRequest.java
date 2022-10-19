package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetVideoSettingsRequest extends Request<SetVideoSettingsRequest.Data> {

  @Builder
  private SetVideoSettingsRequest(Integer fpsNumerator,
      Integer fpsDenominator,
      Integer baseWidth,
      Integer baseHeight,
      Integer outputWidth,
      Integer outputHeight) {
    super(RequestType.SetVideoSettings, Data.builder()
        .fpsNumerator(fpsNumerator)
        .fpsDenominator(fpsDenominator)
        .baseWidth(baseWidth)
        .baseHeight(baseHeight)
        .outputWidth(outputWidth)
        .outputHeight(outputHeight)
        .build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    private final Integer fpsNumerator;
    private final Integer fpsDenominator;
    private final Integer baseWidth;
    private final Integer baseHeight;
    private final Integer outputWidth;
    private final Integer outputHeight;
  }
}
