package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.event.config.CurrentSceneCollectionChangingEvent.SpecificData;
import org.junit.jupiter.api.Test;

class ConfigEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void currentSceneCollectionChangingEvent() {
    CurrentSceneCollectionChangingEvent streamStateChangedEvent = new CurrentSceneCollectionChangingEvent(
        SpecificData.builder()
            .sceneCollectionName("SomeName")
            .build());

    String json = this.readResourceFile("events/config/CurrentSceneCollectionChanging.json");

    assertSerializationAndDeserialization(json, streamStateChangedEvent);
  }
}
