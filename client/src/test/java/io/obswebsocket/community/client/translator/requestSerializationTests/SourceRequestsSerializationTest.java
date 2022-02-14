package io.obswebsocket.community.client.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.sources.GetSourceActiveRequest;
import io.obswebsocket.community.client.message.request.sources.GetSourceScreenshotRequest;
import io.obswebsocket.community.client.message.request.sources.SaveSourceScreenshotRequest;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class SourceRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getSourceActiveRequest() {
    GetSourceActiveRequest getSourceActiveRequest = GetSourceActiveRequest.builder()
        .sourceName("source").build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sourceName\": \"source\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"GetSourceActive\",\n" +
        "\t\"requestId\": " + getSourceActiveRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getSourceActiveRequest);
  }

  @Test
  void getSourceScreenshotRequest() {
    GetSourceScreenshotRequest getSourceScreenshotRequest = GetSourceScreenshotRequest.builder()
        .sourceName("source")
        .imageFormat("png")
        .imageWidth(1920)
        .imageHeight(1080)
        .imageCompressionQuality(-1)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"imageFormat\": \"png\",\n" +
        "\t\t\"imageWidth\": 1920,\n" +
        "\t\t\"imageHeight\": 1080,\n" +
        "\t\t\"imageCompressionQuality\": -1,\n" +
        "\t\t\"sourceName\": \"source\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"GetSourceScreenshot\",\n" +
        "\t\"requestId\": " + getSourceScreenshotRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getSourceScreenshotRequest);
  }

  @Test
  void saveSourceScreenshotRequest() {
    SaveSourceScreenshotRequest saveSourceScreenshotRequest = SaveSourceScreenshotRequest.builder()
        .sourceName("source")
        .imageFilePath("C:/path/to/this/image.png")
        .imageFormat("png")
        .imageWidth(1920)
        .imageHeight(1080)
        .imageCompressionQuality(-1)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"imageFilePath\": \"C:/path/to/this/image.png\",\n" +
        "\t\t\"imageFormat\": \"png\",\n" +
        "\t\t\"imageWidth\": 1920,\n" +
        "\t\t\"imageHeight\": 1080,\n" +
        "\t\t\"imageCompressionQuality\": -1,\n" +
        "\t\t\"sourceName\": \"source\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SaveSourceScreenshot\",\n" +
        "\t\"requestId\": " + saveSourceScreenshotRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, saveSourceScreenshotRequest);
  }
}
