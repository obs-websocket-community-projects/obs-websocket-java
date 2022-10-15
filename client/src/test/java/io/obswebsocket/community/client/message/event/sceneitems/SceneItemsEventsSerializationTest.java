package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import org.junit.jupiter.api.Test;

public class SceneItemsEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "sceneitems";

  @Test
  void sceneItemCreatedEvent() {
    assertEventType(TYPE, new SceneItemCreatedEvent(
        SceneItemCreatedEvent.SpecificData.builder()
            .sceneName("SceneName")
            .sourceName("SourceName")
            .sceneItemId(1)
            .sceneItemIndex(2)
            .build()));
  }

}
