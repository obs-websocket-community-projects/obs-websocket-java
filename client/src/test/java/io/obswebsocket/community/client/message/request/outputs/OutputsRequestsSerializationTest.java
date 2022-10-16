package io.obswebsocket.community.client.message.request.outputs;

import com.google.gson.JsonObject;
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

  @Test
  void toggleReplayBufferRequest() {
    assertRequest(TYPE, ToggleReplayBufferRequest.builder().build());
  }

  @Test
  void startReplayBufferRequest() {
    assertRequest(TYPE, StartReplayBufferRequest.builder().build());
  }

  @Test
  void stopReplayBufferRequest() {
    assertRequest(TYPE, StopReplayBufferRequest.builder().build());
  }

  @Test
  void saveReplayBufferRequest() {
    assertRequest(TYPE, SaveReplayBufferRequest.builder().build());
  }

  @Test
  void getLastReplayBufferReplayRequest() {
    assertRequest(TYPE, GetLastReplayBufferReplayRequest.builder().build());
  }

  @Test
  void getOutputListRequest() {
    assertRequest(TYPE, GetOutputListRequest.builder().build());
  }

  @Test
  void getOutputStatusRequest() {
    assertRequest(TYPE, GetOutputStatusRequest.builder().outputName("SomeName").build());
  }

  @Test
  void toggleOutputRequest() {
    assertRequest(TYPE, ToggleOutputRequest.builder().outputName("SomeName").build());
  }

  @Test
  void startOutputRequest() {
    assertRequest(TYPE, StartOutputRequest.builder().outputName("SomeName").build());
  }

  @Test
  void stopOutputRequest() {
    assertRequest(TYPE, StopOutputRequest.builder().outputName("SomeName").build());
  }

  @Test
  void getOutputSettingsRequest() {
    assertRequest(TYPE, GetOutputSettingsRequest.builder().outputName("SomeName").build());
  }

  @Test
  void setOutputSettingsRequest() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("key", "value");
    assertRequest(TYPE, SetOutputSettingsRequest.builder().outputName("SomeName")
        .outputSettings(jsonObject).build());
  }
}
