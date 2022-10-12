package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentTransitionChangedEvent extends TransitionEvent<TransitionEvent.SpecificData> {
  protected CurrentTransitionChangedEvent() {
    super(Intent.Transitions);
  }
}
