// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A new scene has been created.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneCreatedEvent extends Event<SceneCreatedEvent.SpecificData> {
  protected SceneCreatedEvent() {
    super(Intent.Scenes);
  }

  protected SceneCreatedEvent(SceneCreatedEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }

  /**
   * Name of the new scene
   *
   * @return the sceneName
   */
  public String getSceneName() {
    return getMessageData().getEventData().getSceneName();
  }

  /**
   * Whether the new scene is a group
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
     * Name of the new scene
     */
    private String sceneName;

    /**
     * Whether the new scene is a group
     */
    private Boolean isGroup;
  }
}
