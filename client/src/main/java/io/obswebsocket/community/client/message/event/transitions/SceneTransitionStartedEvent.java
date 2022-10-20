// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A scene transition has started.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneTransitionStartedEvent extends Event<SceneTransitionStartedEvent.SpecificData> {
  protected SceneTransitionStartedEvent() {
    super(Intent.Transitions);
  }

  protected SceneTransitionStartedEvent(SceneTransitionStartedEvent.SpecificData data) {
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
