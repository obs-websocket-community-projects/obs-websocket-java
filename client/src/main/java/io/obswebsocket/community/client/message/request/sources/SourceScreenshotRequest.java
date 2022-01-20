package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SourceScreenshotRequest extends SourceRequest {

  SourceScreenshotRequest(Request.Data.Type requestType) {
    super(requestType);
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends SourceRequest.Data {

    @NonNull
    private final String imageFormat;
    private final Integer imageWidth; // optional
    private final Integer imageHeight; // optional
    private final Integer imageCompressionQuality; // optional
  }
}
