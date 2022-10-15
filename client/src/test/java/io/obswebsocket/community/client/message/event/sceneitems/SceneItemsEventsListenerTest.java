package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class SceneItemsEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void sceneItemCreatedEvent() {
    verifyEventListener(new SceneItemCreatedEvent());
  }

  @Test
  void sceneItemRemovedEvent() {
    verifyEventListener(new SceneItemRemovedEvent());
  }

  @Test
  void sceneItemListReindexedEvent() {
    verifyEventListener(new SceneItemListReindexedEvent());
  }
}
