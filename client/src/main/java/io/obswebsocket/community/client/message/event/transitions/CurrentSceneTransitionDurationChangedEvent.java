package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentSceneTransitionDurationChangedEvent extends
    Event<CurrentSceneTransitionDurationChangedEvent.SpecificData> {

  protected CurrentSceneTransitionDurationChangedEvent() {
    super(Intent.Transitions);
  }

  protected CurrentSceneTransitionDurationChangedEvent(SpecificData data) {
    super(Intent.Transitions, data);
  }

  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {

    private Long transitionDuration;
  }
}
