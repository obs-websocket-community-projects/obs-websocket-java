// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A scene transition has completed fully.
 *
 * Note: Does not appear to trigger when the transition is interrupted by the user.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneTransitionEndedEvent extends Event<SceneTransitionEndedEvent.SpecificData> {
  protected SceneTransitionEndedEvent() {
    super(Intent.Transitions);
  }

  protected SceneTransitionEndedEvent(SceneTransitionEndedEvent.SpecificData data) {
    super(Intent.Transitions, data);
  }

  /**
   * Scene transition name
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
     * Scene transition name
     */
    private String transitionName;
  }
}
