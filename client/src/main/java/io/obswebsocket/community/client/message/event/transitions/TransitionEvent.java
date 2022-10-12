package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class TransitionEvent<T extends TransitionEvent.SpecificData> extends Event<T> {
  protected TransitionEvent(Intent intent) {
    super(intent);
  }

  protected TransitionEvent(Intent intent, T data) {
    super(intent, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {
    protected String transitionName; // TODO TransitionEvent.Data
  }
}
