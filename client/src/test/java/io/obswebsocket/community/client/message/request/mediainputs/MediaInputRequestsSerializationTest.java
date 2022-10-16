package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class MediaInputRequestsSerializationTest extends AbstractRequestSerializationTest {

  public static final String TYPE = "mediainputs";

  @Test
  void getMediaInputStatusRequest() {
    assertRequest(TYPE, GetMediaInputStatusRequest.builder().inputName("SomeName").build());
  }

  @Test
  void setMediaInputCursorRequest() {
    assertRequest(TYPE,
        SetMediaInputCursorRequest.builder().inputName("SomeName").mediaCursor(123).build());
  }

  @Test
  void offsetMediaInputCursorRequest() {
    assertRequest(TYPE,
        OffsetMediaInputCursorRequest.builder().inputName("SomeName").mediaCursorOffset(123)
            .build());
  }

  @Test
  void TriggerMediaInputActionRequest() {
    assertRequest(TYPE,
        TriggerMediaInputActionRequest.builder().inputName("SomeName").mediaAction("play")
            .build());
  }
}
