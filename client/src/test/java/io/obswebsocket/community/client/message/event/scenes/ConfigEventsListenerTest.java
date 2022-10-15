package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class ConfigEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void sceneCreatedEvent() {
    verifyEventListener(new SceneCreatedEvent());
  }

  @Test
  void sceneRemovedEvent() {
    verifyEventListener(new SceneRemovedEvent());
  }

  @Test
  void sceneNameChangedEvent() {
    verifyEventListener(new SceneNameChangedEvent());
  }

  @Test
  void currentProgramSceneChangedEvent() {
    verifyEventListener(new CurrentProgramSceneChangedEvent());
  }
}
