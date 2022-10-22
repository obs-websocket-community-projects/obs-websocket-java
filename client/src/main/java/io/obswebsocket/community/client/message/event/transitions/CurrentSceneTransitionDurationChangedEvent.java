// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The current scene transition duration has changed.
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

  /**
   * Transition duration in milliseconds
   *
   * @return the transitionDuration
   */
  public Number getTransitionDuration() {
    return getMessageData().getEventData().getTransitionDuration();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Transition duration in milliseconds
     */
    private Number transitionDuration;
  }
}
