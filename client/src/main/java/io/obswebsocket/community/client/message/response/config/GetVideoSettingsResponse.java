// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetVideoSettingsResponse extends RequestResponse<GetVideoSettingsResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Numerator of the fractional FPS value
     */
    @NonNull
    private Number fpsNumerator;

    /**
     * Denominator of the fractional FPS value
     */
    @NonNull
    private Number fpsDenominator;

    /**
     * Width of the base (canvas) resolution in pixels
     */
    @NonNull
    private Number baseWidth;

    /**
     * Height of the base (canvas) resolution in pixels
     */
    @NonNull
    private Number baseHeight;

    /**
     * Width of the output resolution in pixels
     */
    @NonNull
    private Number outputWidth;

    /**
     * Height of the output resolution in pixels
     */
    @NonNull
    private Number outputHeight;
  }
}
