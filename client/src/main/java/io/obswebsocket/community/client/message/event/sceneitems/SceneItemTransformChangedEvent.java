// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.SceneItem;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The transform/crop of a scene item has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemTransformChangedEvent extends Event<SceneItemTransformChangedEvent.SpecificData> {
  protected SceneItemTransformChangedEvent() {
    super(Intent.SceneItemTransformChanged);
  }

  protected SceneItemTransformChangedEvent(SceneItemTransformChangedEvent.SpecificData data) {
    super(Intent.SceneItemTransformChanged, data);
  }

  /**
   * The name of the scene the item is in
   *
   * @return the sceneName
   */
  public String getSceneName() {
    return getMessageData().getEventData().getSceneName();
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
   * New transform/crop info of the scene item
   *
   * @return the sceneItemTransform
   */
  public SceneItem.Transform getSceneItemTransform() {
    return getMessageData().getEventData().getSceneItemTransform();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * The name of the scene the item is in
     */
    private String sceneName;

    /**
     * Numeric ID of the scene item
     */
    private Number sceneItemId;

    /**
     * New transform/crop info of the scene item
     */
    private SceneItem.Transform sceneItemTransform;
  }
}
