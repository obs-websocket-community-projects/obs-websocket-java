package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class OutputsRequestsSerializationTest extends AbstractRequestSerializationTest {

  private static final String TYPE = "outputs";

  @Test
  void getVirtualCamStatusRequest() {
    assertRequest(TYPE, GetVirtualCamStatusRequest.builder().build());
  }

  @Test
  void toggleVirtualCamRequest() {
    assertRequest(TYPE, ToggleVirtualCamRequest.builder().build());
  }

  @Test
  void startVirtualCamRequest() {
    assertRequest(TYPE, StartVirtualCamRequest.builder().build());
  }

  @Test
  void stopVirtualCamRequest() {
    assertRequest(TYPE, StopVirtualCamRequest.builder().build());
  }

  @Test
  void getReplayBufferStatusRequest() {
    assertRequest(TYPE, GetReplayBufferStatusRequest.builder().build());
  }
}
