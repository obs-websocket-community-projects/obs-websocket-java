package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetVideoSettingsRequest extends Request<SetVideoSettingsRequest.Data> {
  @Builder
  private SetVideoSettingsRequest(Integer baseWidth,
          Integer baseHeight,
          Integer outputWidth,
          Integer outputHeight,
          Integer fpsNumerator,
          Integer fpsDenominator) {
    super(Request.Data.Type.SetVideoSettings, Data.builder()
                                                  .baseWidth(baseWidth)
                                                  .baseHeight(baseHeight)
                                                  .outputWidth(outputWidth)
                                                  .outputHeight(outputHeight)
                                                  .fpsNumerator(fpsNumerator)
                                                  .fpsDenominator(fpsDenominator)
                                                  .build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    private final Integer baseWidth;
    private final Integer baseHeight;
    private final Integer outputWidth;
    private final Integer outputHeight;
    private final Integer fpsNumerator;
    private final Integer fpsDenominator;
  }
}
