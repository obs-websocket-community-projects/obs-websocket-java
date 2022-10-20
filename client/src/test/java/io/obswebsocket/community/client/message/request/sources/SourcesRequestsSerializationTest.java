package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class SourcesRequestsSerializationTest extends AbstractRequestSerializationTest {

  private static final String TYPE = "sources";

  @Test
  void getSourceActiveRequest() {
    GetSourceActiveRequest getSourceActiveRequest = GetSourceActiveRequest.builder()
        .sourceName("Source Name").build();

    assertRequest(TYPE, getSourceActiveRequest);
  }

  @Test
  void getSourceScreenshotRequest() {
    GetSourceScreenshotRequest getSourceScreenshotRequest = GetSourceScreenshotRequest.builder()
        .sourceName("Source Name")
        .imageFormat("png")
        .imageWidth(1920)
        .imageHeight(1080)
        .imageCompressionQuality(-1)
        .build();

    assertRequest(TYPE, getSourceScreenshotRequest);
  }

  @Test
  void saveSourceScreenshotRequest() {
    SaveSourceScreenshotRequest saveSourceScreenshotRequest = SaveSourceScreenshotRequest.builder()
        .sourceName("Source Name")
        .imageFilePath("C:\\Users\\user\\Desktop\\screenshot.png")
        .imageFormat("png")
        .imageWidth(1920)
        .imageHeight(1080)
        .imageCompressionQuality(-1)
        .build();

    assertRequest(TYPE, saveSourceScreenshotRequest);
  }
}
