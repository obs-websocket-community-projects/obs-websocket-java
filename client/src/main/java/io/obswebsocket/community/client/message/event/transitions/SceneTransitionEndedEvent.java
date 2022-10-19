package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A scene transition has completed fully.
 *
 * Note: Does not appear to trigger when the transition is interrupted by the user.
 *
 * This class is generated, do not edit!
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Scene transition name
     */
    @NonNull
    private String transitionName;
  }
}
