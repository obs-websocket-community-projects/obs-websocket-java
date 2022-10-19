package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SaveSourceScreenshotRequest extends SourceScreenshotRequest<SaveSourceScreenshotRequest.Data> {
  @Builder
  private SaveSourceScreenshotRequest(String sourceName, String imageFilePath, String imageFormat,
          Integer imageWidth, Integer imageHeight, Integer imageCompressionQuality) {
    super(RequestType.SaveSourceScreenshot,
        Data.builder().sourceName(sourceName).imageFilePath(imageFilePath)
            .imageFormat(imageFormat).imageWidth(imageWidth).imageHeight(imageHeight)
            .imageCompressionQuality(imageCompressionQuality).build());
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends SourceScreenshotRequest.Data {

    @NonNull
    private final String imageFilePath;
  }
}
