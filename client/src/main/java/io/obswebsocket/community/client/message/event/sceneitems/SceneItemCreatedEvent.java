// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A scene item has been created.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemCreatedEvent extends Event<SceneItemCreatedEvent.SpecificData> {
  protected SceneItemCreatedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemCreatedEvent(SceneItemCreatedEvent.SpecificData data) {
    super(Intent.SceneItems, data);
  }

  /**
   * Name of the scene the item was added to
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

  /**
   * Index position of the item
   *
   * @return the sceneItemIndex
   */
  public Number getSceneItemIndex() {
    return getMessageData().getEventData().getSceneItemIndex();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the scene the item was added to
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

    /**
     * Index position of the item
     */
    private Number sceneItemIndex;
  }
}
