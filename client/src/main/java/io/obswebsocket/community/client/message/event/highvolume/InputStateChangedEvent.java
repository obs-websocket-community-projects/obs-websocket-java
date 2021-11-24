package io.obswebsocket.community.client.message.event.highvolume;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class InputStateChangedEvent extends Event {

  private transient Data messageData;

  protected InputStateChangedEvent(Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private String inputName;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends Event.Data {

    protected transient SpecificData eventData;
  }
}
