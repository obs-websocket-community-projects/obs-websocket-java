// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetVideoSettingsRequest extends Request<SetVideoSettingsRequest.SpecificData> {
  @Builder
  private SetVideoSettingsRequest(Number fpsNumerator, Number fpsDenominator, Number baseWidth,
      Number baseHeight, Number outputWidth, Number outputHeight) {
    super(RequestType.SetVideoSettings, SpecificData.builder().fpsNumerator(fpsNumerator).fpsDenominator(fpsDenominator).baseWidth(baseWidth).baseHeight(baseHeight).outputWidth(outputWidth).outputHeight(outputHeight).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    private Number fpsNumerator;

    private Number fpsDenominator;

    private Number baseWidth;

    private Number baseHeight;

    private Number outputWidth;

    private Number outputHeight;
  }
}
