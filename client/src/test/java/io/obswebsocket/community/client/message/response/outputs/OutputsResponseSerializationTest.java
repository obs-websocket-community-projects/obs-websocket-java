package io.obswebsocket.community.client.message.response.outputs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Test;

public class OutputsResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "outputs";

  @Test
  void getVirtualCamStatusResponse() {
    assertResponse(TYPE, GetVirtualCamStatusResponse.class, d -> assertTrue(d.isOutputActive()));
  }
}
