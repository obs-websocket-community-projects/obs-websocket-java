package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class RecordRequestsSerializationTest extends AbstractRequestSerializationTest {

  private static final String TYPE = "record";

  @Test
  void getStudioModeEnabledRequest() {
    assertRequest(TYPE, GetRecordStatusRequest.builder().build());
  }

  @Test
  void toggleRecordRequest() {
    assertRequest(TYPE, ToggleRecordRequest.builder().build());
  }

  @Test
  void startRecordRequest() {
    assertRequest(TYPE, StartRecordRequest.builder().build());
  }

  @Test
  void stopRecordRequest() {
    assertRequest(TYPE, StopRecordRequest.builder().build());
  }

  @Test
  void toggleRecordPauseRequest() {
    assertRequest(TYPE, ToggleRecordPauseRequest.builder().build());
  }

  @Test
  void pauseRecordRequest() {
    assertRequest(TYPE, PauseRecordRequest.builder().build());
  }

  @Test
  void resumeRecordRequest() {
    assertRequest(TYPE, ResumeRecordRequest.builder().build());
  }
}
