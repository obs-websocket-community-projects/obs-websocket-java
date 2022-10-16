package io.obswebsocket.community.client.message.response.ui;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Test;

public class UIResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "ui";

  @Test
  void getSceneListResponse() {
    assertResponse(TYPE, GetStudioModeEnabledResponse.class);
  }
}
