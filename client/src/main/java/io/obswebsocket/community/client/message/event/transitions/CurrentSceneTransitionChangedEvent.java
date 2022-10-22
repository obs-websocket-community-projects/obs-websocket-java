// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The current scene transition has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class CurrentSceneTransitionChangedEvent extends Event<CurrentSceneTransitionChangedEvent.SpecificData> {
  protected CurrentSceneTransitionChangedEvent() {
    super(Intent.Transitions);
  }

  protected CurrentSceneTransitionChangedEvent(
      CurrentSceneTransitionChangedEvent.SpecificData data) {
    super(Intent.Transitions, data);
  }

  /**
   * Name of the new transition
   *
   * @return the transitionName
   */
  public String getTransitionName() {
    return getMessageData().getEventData().getTransitionName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the new transition
     */
    private String transitionName;
  }
}
