package io.obswebsocket.community.client.message.response.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.internal.LazilyParsedNumber;
import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StreamResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "stream";

  @Test
  void getStreamStatusResponse() {
    assertResponse(TYPE, GetStreamStatusResponse.class, d -> {
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
  void toggleStreamResponse() {
    assertResponse(TYPE, ToggleStreamResponse.class, d -> assertTrue(d.getOutputActive()));
  }

  @Test
  void startStreamResponse() {
    assertResponse(TYPE, StartStreamResponse.class, Assertions::assertNull);
  }

  @Test
  void stopStreamResponse() {
    assertResponse(TYPE, StopStreamResponse.class, Assertions::assertNull);
  }

  @Test
  void sendStreamCaptionResponse() {
    assertResponse(TYPE, SendStreamCaptionResponse.class, Assertions::assertNull);
  }
}
