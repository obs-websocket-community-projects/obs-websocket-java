package io.obswebsocket.community.client.message.request;

import static org.assertj.core.api.Assertions.assertThat;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestSerializationTest extends AbstractSerializationTest {

  @Test
  void notOrUnknownRequest() {
    Assertions.assertThat(deserializeTo("[]", Request.class)).isNull();
    assertThat(deserializeTo("{}", Request.class)).isNull();
    assertThat(deserializeTo("{'op':6}", Request.class)).isNull();
    assertThat(deserializeTo("{'op':6, 'requestType':'SomethingGibberish'}",
        Request.class)).isNull();
  }
}
