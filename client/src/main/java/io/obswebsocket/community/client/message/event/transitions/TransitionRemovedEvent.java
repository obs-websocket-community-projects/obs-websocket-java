package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TransitionRemovedEvent extends TransitionEvent<TransitionEvent.SpecificData> {
  protected TransitionRemovedEvent() {
    super(Intent.Transitions);
  }
}
