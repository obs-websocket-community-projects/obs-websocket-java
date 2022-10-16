package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class MediaInputRequestsSerializationTest extends AbstractRequestSerializationTest {

  public static final String TYPE = "mediainputs";

  @Test
  void getMediaInputStatusRequest() {
    assertRequest(TYPE, GetMediaInputStatusRequest.builder().inputName("SomeName").build());
  }
}
