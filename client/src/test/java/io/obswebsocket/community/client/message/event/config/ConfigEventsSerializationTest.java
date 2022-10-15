package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class ConfigEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void currentSceneCollectionChangingEvent() {
    CurrentSceneCollectionChangingEvent streamStateChangedEvent = new CurrentSceneCollectionChangingEvent(
        CurrentSceneCollectionChangingEvent.SpecificData.builder()
            .sceneCollectionName("SomeName")
            .build());

    String json = this.readResourceFile("events/config/CurrentSceneCollectionChanging.json");

    assertSerializationAndDeserialization(json, streamStateChangedEvent);
  }

  @Test
  void currentSceneCollectionChangedEvent() {
    CurrentSceneCollectionChangedEvent streamStateChangedEvent = new CurrentSceneCollectionChangedEvent(
        CurrentSceneCollectionChangedEvent.SpecificData.builder()
            .sceneCollectionName("SomeName")
            .build());

    String json = this.readResourceFile("events/config/CurrentSceneCollectionChanged.json");

    assertSerializationAndDeserialization(json, streamStateChangedEvent);
  }
}
