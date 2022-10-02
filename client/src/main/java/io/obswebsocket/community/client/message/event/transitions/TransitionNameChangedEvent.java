package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class TransitionNameChangedEvent extends TransitionEvent<TransitionNameChangedEvent.SpecificData> {
  protected TransitionNameChangedEvent() {
    super(Intent.Transitions);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends TransitionEvent.SpecificData {
    private String oldTransitionName; // TODO TransitionNameChangedEvent.Data
  }
}
