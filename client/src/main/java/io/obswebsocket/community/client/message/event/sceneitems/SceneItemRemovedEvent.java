// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A scene item has been removed.
 *
 * This event is not emitted when the scene the item is in is removed.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemRemovedEvent extends Event<SceneItemRemovedEvent.SpecificData> {
  protected SceneItemRemovedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemRemovedEvent(SceneItemRemovedEvent.SpecificData data) {
    super(Intent.SceneItems, data);
  }

  /**
   * Name of the scene the item was removed from
   *
   * @return the sceneName
   */
  public String getSceneName() {
    return getMessageData().getEventData().getSceneName();
  }

  /**
   * Name of the underlying source (input/scene)
   *
   * @return the sourceName
   */
  public String getSourceName() {
    return getMessageData().getEventData().getSourceName();
  }

  /**
   * Numeric ID of the scene item
   *
   * @return the sceneItemId
   */
  public Number getSceneItemId() {
    return getMessageData().getEventData().getSceneItemId();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the scene the item was removed from
     */
    private String sceneName;

    /**
     * Name of the underlying source (input/scene)
     */
    private String sourceName;

    /**
     * Numeric ID of the scene item
     */
    private Number sceneItemId;
  }
}
