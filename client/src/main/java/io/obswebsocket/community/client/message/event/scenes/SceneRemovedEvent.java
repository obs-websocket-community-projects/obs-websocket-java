// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A scene has been removed.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneRemovedEvent extends Event<SceneRemovedEvent.SpecificData> {
  protected SceneRemovedEvent() {
    super(Intent.Scenes);
  }

  protected SceneRemovedEvent(SceneRemovedEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }

  /**
   * Name of the removed scene
   *
   * @return the sceneName
   */
  public String getSceneName() {
    return getMessageData().getEventData().getSceneName();
  }

  /**
   * Whether the scene was a group
   *
   * @return the isGroup
   */
  public Boolean getIsGroup() {
    return getMessageData().getEventData().getIsGroup();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the removed scene
     */
    private String sceneName;

    /**
     * Whether the scene was a group
     */
    private Boolean isGroup;
  }
}
