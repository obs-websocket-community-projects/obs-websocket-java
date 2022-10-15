package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class TransitionsEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void currentSceneTransitionChangedEvent() {
    verifyEventListener(new CurrentSceneTransitionChangedEvent());
  }
}
