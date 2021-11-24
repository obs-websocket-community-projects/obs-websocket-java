package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class TransitionEvent extends Event {

  private transient Data messageData;

  protected TransitionEvent(Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private String transitionName; // TODO TransitionEvent.Data
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends Event.Data {

    protected transient SpecificData eventData;
  }
}
