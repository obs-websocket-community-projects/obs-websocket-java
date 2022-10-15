package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import org.junit.jupiter.api.Test;

class ConfigEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "config";

  @Test
  void currentSceneCollectionChangingEvent() {
    assertEventType(TYPE, new CurrentSceneCollectionChangingEvent(
        CurrentSceneCollectionChangingEvent.SpecificData.builder()
            .sceneCollectionName("SomeName")
            .build()));
  }

  @Test
  void currentSceneCollectionChangedEvent() {
    assertEventType(TYPE, new CurrentSceneCollectionChangedEvent(
        CurrentSceneCollectionChangedEvent.SpecificData.builder()
            .sceneCollectionName("SomeName")
            .build()));
  }
}
