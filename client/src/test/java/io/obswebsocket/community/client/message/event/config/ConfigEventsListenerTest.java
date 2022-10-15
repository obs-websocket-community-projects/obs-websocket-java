package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class ConfigEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void currentSceneCollectionChangingEvent() {
    verifyEventListener(new CurrentSceneCollectionChangingEvent());
  }

  @Test
  void currentSceneCollectionChangedEvent() {
    verifyEventListener(new CurrentSceneCollectionChangedEvent());
  }
}
