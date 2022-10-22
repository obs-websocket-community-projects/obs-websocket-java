// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The name of a scene has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneNameChangedEvent extends Event<SceneNameChangedEvent.SpecificData> {
  protected SceneNameChangedEvent() {
    super(Intent.Scenes);
  }

  protected SceneNameChangedEvent(SceneNameChangedEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }

  /**
   * Old name of the scene
   *
   * @return the oldSceneName
   */
  public String getOldSceneName() {
    return getMessageData().getEventData().getOldSceneName();
  }

  /**
   * New name of the scene
   *
   * @return the sceneName
   */
  public String getSceneName() {
    return getMessageData().getEventData().getSceneName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Old name of the scene
     */
    private String oldSceneName;

    /**
     * New name of the scene
     */
    private String sceneName;
  }
}
