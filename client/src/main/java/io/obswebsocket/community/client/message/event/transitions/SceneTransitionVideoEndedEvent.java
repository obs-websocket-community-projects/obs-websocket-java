package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A scene transition's video has completed fully.
 * <p>
 * Useful for stinger transitions to tell when the video *actually* ends. `SceneTransitionEnded`
 * only signifies the cut point, not the completion of transition playback.
 * <p>
 * Note: Appears to be called by every transition, regardless of relevance.
 * <p>
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneTransitionVideoEndedEvent extends
    Event<SceneTransitionVideoEndedEvent.SpecificData> {

  protected SceneTransitionVideoEndedEvent() {
    super(Intent.Transitions);
  }

  protected SceneTransitionVideoEndedEvent(SceneTransitionVideoEndedEvent.SpecificData data) {
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
