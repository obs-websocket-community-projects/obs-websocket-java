package io.obswebsocket.community.client.message.response.outputs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.internal.LazilyParsedNumber;
import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OutputsResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "outputs";

  @Test
  void getVirtualCamStatusResponse() {
    assertResponse(TYPE, GetVirtualCamStatusResponse.class, d -> assertTrue(d.getOutputActive()));
  }

  @Test
  void toggleVirtualCamResponse() {
    assertResponse(TYPE, ToggleVirtualCamResponse.class, d -> assertTrue(d.getOutputActive()));
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
  void stopReplayBufferResponse() {
    assertResponse(TYPE, StopReplayBufferResponse.class, Assertions::assertNull);
  }

  @Test
  void saveReplayBufferResponse() {
    assertResponse(TYPE, SaveReplayBufferResponse.class, Assertions::assertNull);
  }

  @Test
  void getLastReplayBufferReplayResponse() {
    assertResponse(TYPE, GetLastReplayBufferReplayResponse.class,
        d -> assertEquals("SomePath", d.getSavedReplayPath()));
  }

  @Test
  void getOutputListResponse() {
    // TODO: Documentation states this has no data
//    assertResponse(TYPE, GetOutputListResponse.class, d -> {
//      assertEquals(1, d.getOutputs().size());
//      Output output = d.getOutputs().get(0);
//      assertEquals("OutputName", output.getOutputName());
//      assertEquals("OutputKind", output.getOutputKind());
//      assertEquals(123, output.getOutputWidth());
//      assertEquals(321, output.getOutputHeight());
//      assertTrue(output.getOutputActive());
//      assertEquals(true, output.getOutputFlags().getAudio());
//    });
  }

  @Test
  void getOutputStatusResponse() {
    assertResponse(TYPE, GetOutputStatusResponse.class, d -> {
      assertTrue(d.getOutputActive());
      assertTrue(d.getOutputReconnecting());
      assertEquals("TimeCode", d.getOutputTimecode());
      assertEquals(new LazilyParsedNumber("1"), d.getOutputDuration());
      assertEquals(new LazilyParsedNumber("2"), d.getOutputCongestion());
      assertEquals(new LazilyParsedNumber("3"), d.getOutputBytes());
      assertEquals(new LazilyParsedNumber("4"), d.getOutputSkippedFrames());
      assertEquals(new LazilyParsedNumber("5"), d.getOutputTotalFrames());
    });
  }

  @Test
  void toggleOutputResponse() {
    assertResponse(TYPE, ToggleOutputResponse.class, d -> assertTrue(d.getOutputActive()));
  }

  @Test
  void startOutputResponse() {
    assertResponse(TYPE, StartOutputResponse.class, Assertions::assertNull);
  }

  @Test
  void stopOutputResponse() {
    assertResponse(TYPE, StopOutputResponse.class, Assertions::assertNull);
  }

  @Test
  void getOutputSettingsResponse() {
    assertResponse(TYPE, GetOutputSettingsResponse.class,
        d -> assertEquals("value", d.getOutputSettings().get("key").getAsString()));
  }

  @Test
  void setOutputSettingsResponse() {
    assertResponse(TYPE, SetOutputSettingsResponse.class, Assertions::assertNull);
  }
}
