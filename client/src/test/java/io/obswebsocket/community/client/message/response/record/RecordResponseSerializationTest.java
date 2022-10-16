package io.obswebsocket.community.client.message.response.record;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecordResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "record";

  @Test
  void getSceneListResponse() {
    assertResponse(TYPE, GetRecordStatusResponse.class, d -> {
      assertTrue(d.getOutputActive());
      assertTrue(d.getOutputPaused());
      assertEquals(123, d.getOutputTimecode());
      assertEquals(321, d.getOutputDuration());
      assertEquals(132, d.getOutputBytes());
    });
  }

  @Test
  void toggleRecordResponse() {
    assertResponse(TYPE, ToggleRecordResponse.class, Assertions::assertNull);
  }

  @Test
  void startRecordResponse() {
    assertResponse(TYPE, StartRecordResponse.class, Assertions::assertNull);
  }

  @Test
  void stopRecordResponse() {
    assertResponse(TYPE, StopRecordResponse.class,
        d -> assertEquals("SomePath", d.getOutputPath()));
  }
}
