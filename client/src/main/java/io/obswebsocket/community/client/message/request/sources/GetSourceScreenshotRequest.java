package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceScreenshotRequest extends SourceScreenshotRequest<SourceScreenshotRequest.Data> {
  @Builder
  private GetSourceScreenshotRequest(String sourceName,
          String imageFormat,
          Integer imageWidth,
          Integer imageHeight,
          Integer imageCompressionQuality) {
    super(Request.Data.Type.GetSourceScreenshot, Data.builder()
                                                     .sourceName(sourceName)
                                                     .imageFormat(imageFormat)
                                                     .imageWidth(imageWidth)
                                                     .imageHeight(imageHeight)
                                                     .imageCompressionQuality(imageCompressionQuality)
                                                     .build());
  }
}
