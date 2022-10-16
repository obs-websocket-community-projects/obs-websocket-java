package io.obswebsocket.community.client.message.response.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Test;

public class StreamResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "stream";

  @Test
  void getStreamStatusResponse() {
    assertResponse(TYPE, GetStreamStatusResponse.class, d -> {
      assertTrue(d.getOutputActive());
      assertTrue(d.getOutputReconnecting());
      assertEquals("TimeCode", d.getOutputTimecode());
      assertEquals(1, d.getOutputDuration());
      assertEquals(2, d.getOutputCongestion());
      assertEquals(3, d.getOutputBytes());
      assertEquals(4, d.getOutputSkippedFrames());
      assertEquals(5, d.getOutputTotalFrames());
    });
  }
}
