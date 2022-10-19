package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The current scene transition has changed.
 *
 * This class is generated, do not edit!
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the new transition
     */
    @NonNull
    private String transitionName;
  }
}
