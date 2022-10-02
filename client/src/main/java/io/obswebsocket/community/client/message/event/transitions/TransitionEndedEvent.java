package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TransitionEndedEvent extends TransitionEvent<TransitionEvent.SpecificData> {
  protected TransitionEndedEvent() {
    super(Intent.Transitions);
  }
}
