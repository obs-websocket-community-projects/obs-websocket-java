package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TransitionStartedEvent extends TransitionEvent<TransitionEvent.SpecificData> {
  protected TransitionStartedEvent() {
    super(Intent.Transitions);
  }

  protected TransitionStartedEvent(TransitionEvent.SpecificData data) {
    super(Intent.Transitions, data);
  }
}
