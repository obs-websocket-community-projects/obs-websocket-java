// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSourceScreenshotRequest extends Request<GetSourceScreenshotRequest.SpecificData> {
  @Builder
  private GetSourceScreenshotRequest(String sourceName, String imageFormat, Number imageWidth,
      Number imageHeight, Number imageCompressionQuality) {
    super(RequestType.GetSourceScreenshot, SpecificData.builder().sourceName(sourceName).imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight).imageCompressionQuality(imageCompressionQuality).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sourceName;

    @NonNull
    private String imageFormat;

    private Number imageWidth;

    private Number imageHeight;

    private Number imageCompressionQuality;
  }
}
