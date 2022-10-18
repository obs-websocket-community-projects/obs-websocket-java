package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import io.obswebsocket.community.client.message.event.sceneitems.SceneItemListReindexedEvent.SpecificData.SceneItemIdAndIndex;
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

  @Test
  void sceneItemRemovedEvent() {
    assertEventType(TYPE, new SceneItemRemovedEvent(
        SceneItemRemovedEvent.SpecificData.builder()
            .sceneName("SceneName")
            .sourceName("SourceName")
            .sceneItemId(1)
            .build()));
  }

  @Test
  void sceneItemListReindexedEvent() {
    SceneItemIdAndIndex item1 = new SceneItemIdAndIndex();
    item1.setSceneItemId(1);
    item1.setSceneItemIndex(2);
    SceneItemIdAndIndex item2 = new SceneItemIdAndIndex();
    item2.setSceneItemId(3);
    item2.setSceneItemIndex(4);

    assertEventType(TYPE, new SceneItemListReindexedEvent(
        SceneItemListReindexedEvent.SpecificData.builder()
            .sceneName("SceneName")
            .sceneItem(item1)
            .sceneItem(item2)
            .build()));
  }

  @Test
  void sceneItemEnableStateChangedEvent() {
    assertEventType(TYPE, new SceneItemEnableStateChangedEvent(
        SceneItemEnableStateChangedEvent.SpecificData.builder()
            .sceneName("SceneName")
            .sceneItemId(1)
            .sceneItemEnabled(true)
            .build()));
  }

  @Test
  void sceneItemLockStateChangedEvent() {
    assertEventType(TYPE, new SceneItemLockStateChangedEvent(
        SceneItemLockStateChangedEvent.SpecificData.builder()
            .sceneName("SceneName")
            .sceneItemId(1)
            .sceneItemLocked(true)
            .build()));
  }

  @Test
  void sceneItemSelectedEvent() {
    assertEventType(TYPE, new SceneItemSelectedEvent(
        SceneItemSelectedEvent.SpecificData.builder()
            .sceneName("SceneName")
            .sceneItemId(1)
            .build()));
  }
}
