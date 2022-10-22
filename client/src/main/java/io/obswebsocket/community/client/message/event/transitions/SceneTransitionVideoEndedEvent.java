// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A scene transition's video has completed fully.
 *
 * Useful for stinger transitions to tell when the video *actually* ends.
 * `SceneTransitionEnded` only signifies the cut point, not the completion of transition playback.
 *
 * Note: Appears to be called by every transition, regardless of relevance.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneTransitionVideoEndedEvent extends Event<SceneTransitionVideoEndedEvent.SpecificData> {
  protected SceneTransitionVideoEndedEvent() {
    super(Intent.Transitions);
  }

  protected SceneTransitionVideoEndedEvent(SceneTransitionVideoEndedEvent.SpecificData data) {
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
