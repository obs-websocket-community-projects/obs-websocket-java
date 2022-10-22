// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetVideoSettingsResponse extends RequestResponse<GetVideoSettingsResponse.SpecificData> {
  /**
   * Numerator of the fractional FPS value
   *
   * @return the fpsNumerator
   */
  public Number getFpsNumerator() {
    return getMessageData().getResponseData().getFpsNumerator();
  }

  /**
   * Denominator of the fractional FPS value
   *
   * @return the fpsDenominator
   */
  public Number getFpsDenominator() {
    return getMessageData().getResponseData().getFpsDenominator();
  }

  /**
   * Width of the base (canvas) resolution in pixels
   *
   * @return the baseWidth
   */
  public Number getBaseWidth() {
    return getMessageData().getResponseData().getBaseWidth();
  }

  /**
   * Height of the base (canvas) resolution in pixels
   *
   * @return the baseHeight
   */
  public Number getBaseHeight() {
    return getMessageData().getResponseData().getBaseHeight();
  }

  /**
   * Width of the output resolution in pixels
   *
   * @return the outputWidth
   */
  public Number getOutputWidth() {
    return getMessageData().getResponseData().getOutputWidth();
  }

  /**
   * Height of the output resolution in pixels
   *
   * @return the outputHeight
   */
  public Number getOutputHeight() {
    return getMessageData().getResponseData().getOutputHeight();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Numerator of the fractional FPS value
     */
    private Number fpsNumerator;

    /**
     * Denominator of the fractional FPS value
     */
    private Number fpsDenominator;

    /**
     * Width of the base (canvas) resolution in pixels
     */
    private Number baseWidth;

    /**
     * Height of the base (canvas) resolution in pixels
     */
    private Number baseHeight;

    /**
     * Width of the output resolution in pixels
     */
    private Number outputWidth;

    /**
     * Height of the output resolution in pixels
     */
    private Number outputHeight;
  }
}
