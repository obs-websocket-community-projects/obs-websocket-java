package io.obswebsocket.community.client.message.response.outputs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OutputsResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "outputs";

  @Test
  void getVirtualCamStatusResponse() {
    assertResponse(TYPE, GetVirtualCamStatusResponse.class, d -> assertTrue(d.isOutputActive()));
  }

  @Test
  void toggleVirtualCamResponse() {
    assertResponse(TYPE, ToggleVirtualCamResponse.class, d -> assertTrue(d.isOutputActive()));
  }

  @Test
  void startVirtualCamResponse() {
    assertResponse(TYPE, StartVirtualCamResponse.class, Assertions::assertNull);
  }

  @Test
  void stopVirtualCamResponse() {
    assertResponse(TYPE, StartVirtualCamResponse.class, Assertions::assertNull);
  }

  @Test
  void getReplayBufferStatusResponse() {
    assertResponse(TYPE, GetReplayBufferStatusResponse.class,
        d -> assertTrue(d.getOutputActive()));
  }

  @Test
  void toggleReplayBufferResponse() {
    assertResponse(TYPE, ToggleReplayBufferResponse.class,
        d -> assertTrue(d.getOutputActive()));
  }

  @Test
  void startReplayBufferResponse() {
    assertResponse(TYPE, StartReplayBufferResponse.class, Assertions::assertNull);
  }
}
