package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The current scene transition duration has changed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class CurrentSceneTransitionDurationChangedEvent extends Event<CurrentSceneTransitionDurationChangedEvent.SpecificData> {
  protected CurrentSceneTransitionDurationChangedEvent() {
    super(Intent.Transitions);
  }

  protected CurrentSceneTransitionDurationChangedEvent(
      CurrentSceneTransitionDurationChangedEvent.SpecificData data) {
    super(Intent.Transitions, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Transition duration in milliseconds
     */
    @NonNull
    private Number transitionDuration;
  }
}
