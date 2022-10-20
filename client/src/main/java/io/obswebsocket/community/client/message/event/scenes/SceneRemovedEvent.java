// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the removed scene
     */
    @NonNull
    private String sceneName;

    /**
     * Whether the scene was a group
     */
    @NonNull
    private Boolean isGroup;
  }
}
