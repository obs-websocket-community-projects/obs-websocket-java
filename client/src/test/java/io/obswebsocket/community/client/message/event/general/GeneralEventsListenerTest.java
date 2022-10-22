package io.obswebsocket.community.client.message.event.general;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class GeneralEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void exitStartedEventTriggered() {
    verifyEventListener(new ExitStartedEvent());
  }
}
