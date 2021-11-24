package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class TransitionEvent extends Event {

  protected transient Data messageData;

  protected TransitionEvent(Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {

    protected String transitionName; // TODO TransitionEvent.Data
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {

    protected transient SpecificData eventData;
  }
}
