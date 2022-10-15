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

  @Test
  void sceneCollectionListChangedEvent() {
    verifyEventListener(new SceneCollectionListChangedEvent());
  }

  @Test
  void currentProfileChangingEvent() {
    verifyEventListener(new CurrentProfileChangingEvent());
  }

  @Test
  void currentProfileChangedEvent() {
    verifyEventListener(new CurrentProfileChangedEvent());
  }
}
