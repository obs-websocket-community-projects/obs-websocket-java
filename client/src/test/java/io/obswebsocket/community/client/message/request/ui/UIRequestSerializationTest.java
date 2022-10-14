package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class UIRequestSerializationTest extends AbstractSerializationTest {

  @Test
  void getStudioModeEnabledRequest() {
    GetStudioModeEnabledRequest getStudioModeEnabledRequest = GetStudioModeEnabledRequest.builder()
        .build();

    String json = "{'d': {\n" +
        "\t'requestType': 'GetStudioModeEnabled',\n" +
        "\t'requestId': " + getStudioModeEnabledRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}\n";

    assertSerializationAndDeserialization(json, getStudioModeEnabledRequest);
  }

  @Test
  void setStudioModeEnabledRequest() {
    SetStudioModeEnabledRequest setStudioModeEnabledRequest = SetStudioModeEnabledRequest.builder()
        .studioModeEnabled(false).build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'studioModeEnabled': false\n" +
        "\t},\n" +
        "\t'requestType': 'SetStudioModeEnabled',\n" +
        "\t'requestId': " + setStudioModeEnabledRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setStudioModeEnabledRequest);
  }
}
