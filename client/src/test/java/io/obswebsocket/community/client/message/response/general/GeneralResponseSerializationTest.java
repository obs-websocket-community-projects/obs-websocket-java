package io.obswebsocket.community.client.message.response.general;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class GeneralResponseSerializationTest extends AbstractSerializationTest {

  @Test
  void getVersionResponse() {

    String json = this.readResourceFile("responses/general/GetVersionResponse.json");

    GetVersionResponse response = deserialize(json, GetVersionResponse.class);
    assertNotNull(response);
    assertEquals(7, response.getOperationCode().getRawCode());
    assertNotNull(response.getMessageData());
    assertTrue(response.isSuccessful());
    assertNotNull(response.getMessageData().getResponseData());
    assertEquals("28.0.0", response.getMessageData().getResponseData().getObsVersion());
    assertEquals("5.0.0", response.getMessageData().getResponseData().getObsWebSocketVersion());
    assertEquals(1, response.getMessageData().getResponseData().getRpcVersion());
    assertEquals(0, response.getMessageData().getResponseData().getAvailableRequests().size());
    assertEquals(0, response.getMessageData().getResponseData().getSupportedImageFormats().size());
    assertEquals("windows", response.getMessageData().getResponseData().getPlatform());
    assertEquals("Windows 11 (11.0)", response.getMessageData().getResponseData().getPlatformDescription());
  }
}
