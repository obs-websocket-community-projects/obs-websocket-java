package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SourceScreenshotRequest<T extends SourceScreenshotRequest.Data> extends SourceRequest<T> {

  SourceScreenshotRequest(Request.Data.Type requestType, T data) {
    super(requestType, data);
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
