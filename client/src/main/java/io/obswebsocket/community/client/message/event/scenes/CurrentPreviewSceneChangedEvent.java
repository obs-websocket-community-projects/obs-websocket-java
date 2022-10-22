// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The current preview scene has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class CurrentPreviewSceneChangedEvent extends Event<CurrentPreviewSceneChangedEvent.SpecificData> {
  protected CurrentPreviewSceneChangedEvent() {
    super(Intent.Scenes);
  }

  protected CurrentPreviewSceneChangedEvent(CurrentPreviewSceneChangedEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }

  /**
   * Name of the scene that was switched to
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
     * Name of the scene that was switched to
     */
    private String sceneName;
  }
}
