package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import io.obswebsocket.community.client.model.Scene;
import org.junit.jupiter.api.Test;

class ConfigEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "scenes";

  @Test
  void currentSceneCollectionChangingEvent() {
    assertEventType(TYPE, new SceneCreatedEvent(
        SceneCreatedEvent.SpecificData.builder()
            .sceneName("SomeName")
            .isGroup(true)
            .build()));
  }

  @Test
  void sceneRemovedEvent() {
    assertEventType(TYPE, new SceneRemovedEvent(
        SceneRemovedEvent.SpecificData.builder()
            .sceneName("SomeName")
            .isGroup(true)
            .build()));
  }

  @Test
  void sceneNameChangedEvent() {
    assertEventType(TYPE, new SceneNameChangedEvent(
        SceneNameChangedEvent.SpecificData.builder()
            .sceneName("SomeName")
            .oldSceneName("OldName")
            .build()));
  }

  @Test
  void currentProgramSceneChangedEvent() {
    assertEventType(TYPE, new CurrentProgramSceneChangedEvent(
        CurrentProgramSceneChangedEvent.SpecificData.builder()
            .sceneName("SomeName")
            .build()));
  }

  @Test
  void currentPreviewSceneChangedEvent() {
    assertEventType(TYPE, new CurrentPreviewSceneChangedEvent(
        CurrentPreviewSceneChangedEvent.SpecificData.builder()
            .sceneName("SomeName")
            .build()));
  }

  @Test
  void sceneListChangedEvent() {
    assertEventType(TYPE, new SceneListChangedEvent(
        SceneListChangedEvent.SpecificData.builder()
            .scene(new Scene("Scene 1", 0))
            .scene(new Scene("Scene 2", 1))
            .build()));
  }
}
