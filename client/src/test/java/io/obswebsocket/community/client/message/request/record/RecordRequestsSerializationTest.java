package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class RecordRequestsSerializationTest extends AbstractRequestSerializationTest {

  private static final String TYPE = "record";

  @Test
  void getStudioModeEnabledRequest() {
    assertRequest(TYPE, GetRecordStatusRequest.builder().build());
  }
}
