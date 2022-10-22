// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A scene item's enable state has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemEnableStateChangedEvent extends Event<SceneItemEnableStateChangedEvent.SpecificData> {
  protected SceneItemEnableStateChangedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemEnableStateChangedEvent(SceneItemEnableStateChangedEvent.SpecificData data) {
    super(Intent.SceneItems, data);
  }

  /**
   * Name of the scene the item is in
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
   * Whether the scene item is enabled (visible)
   *
   * @return the sceneItemEnabled
   */
  public Boolean getSceneItemEnabled() {
    return getMessageData().getEventData().getSceneItemEnabled();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the scene the item is in
     */
    private String sceneName;

    /**
     * Numeric ID of the scene item
     */
    private Number sceneItemId;

    /**
     * Whether the scene item is enabled (visible)
     */
    private Boolean sceneItemEnabled;
  }
}
