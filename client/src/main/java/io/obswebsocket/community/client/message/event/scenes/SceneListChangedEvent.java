// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

/**
 * The list of scenes has changed.
 *
 * TODO: Make OBS fire this event when scenes are reordered.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneListChangedEvent extends Event<SceneListChangedEvent.SpecificData> {
  protected SceneListChangedEvent() {
    super(Intent.Scenes);
  }

  protected SceneListChangedEvent(SceneListChangedEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }

  /**
   * Updated array of scenes
   *
   * @return the scenes
   */
  public List<Scene> getScenes() {
    return getMessageData().getEventData().getScenes();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Updated array of scenes
     */
    @Singular
    private List<Scene> scenes;
  }
}
