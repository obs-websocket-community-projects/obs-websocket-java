package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The current program scene has changed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class CurrentProgramSceneChangedEvent extends Event<CurrentProgramSceneChangedEvent.SpecificData> {
  protected CurrentProgramSceneChangedEvent() {
    super(Intent.Scenes);
  }

  protected CurrentProgramSceneChangedEvent(CurrentProgramSceneChangedEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the scene that was switched to
     */
    @NonNull
    private String sceneName;
  }
}
