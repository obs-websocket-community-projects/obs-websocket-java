package io.obswebsocket.community.client.message.event.general;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import org.junit.jupiter.api.Test;

class GeneralEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "general";

  @Test
  void exitStartedEvent() {
    assertEventType(TYPE, new ExitStartedEvent());
  }
}
