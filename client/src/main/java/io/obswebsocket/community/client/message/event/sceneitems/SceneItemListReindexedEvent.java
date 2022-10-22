// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.SceneItemIdAndIndex;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

/**
 * A scene's item list has been reindexed.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemListReindexedEvent extends Event<SceneItemListReindexedEvent.SpecificData> {
  protected SceneItemListReindexedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemListReindexedEvent(SceneItemListReindexedEvent.SpecificData data) {
    super(Intent.SceneItems, data);
  }

  /**
   * Name of the scene
   *
   * @return the sceneName
   */
  public String getSceneName() {
    return getMessageData().getEventData().getSceneName();
  }

  /**
   * Array of scene item objects
   *
   * @return the sceneItems
   */
  public List<SceneItemIdAndIndex> getSceneItems() {
    return getMessageData().getEventData().getSceneItems();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the scene
     */
    private String sceneName;

    /**
     * Array of scene item objects
     */
    @Singular
    private List<SceneItemIdAndIndex> sceneItems;
  }
}
