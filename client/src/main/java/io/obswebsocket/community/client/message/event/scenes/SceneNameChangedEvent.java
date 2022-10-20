// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Old name of the scene
     */
    @NonNull
    private String oldSceneName;

    /**
     * New name of the scene
     */
    @NonNull
    private String sceneName;
  }
}
