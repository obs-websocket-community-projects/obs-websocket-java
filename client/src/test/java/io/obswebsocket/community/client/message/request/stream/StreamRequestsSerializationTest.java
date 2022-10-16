package io.obswebsocket.community.client.message.request.stream;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class StreamRequestsSerializationTest extends AbstractRequestSerializationTest {

  private static final String TYPE = "stream";

  @Test
  void getStreamStatusRequest() {
    assertRequest(TYPE, GetStreamStatusRequest.builder().build());
  }

  @Test
  void toggleStreamRequest() {
    assertRequest(TYPE, ToggleStreamRequest.builder().build());
  }
}
