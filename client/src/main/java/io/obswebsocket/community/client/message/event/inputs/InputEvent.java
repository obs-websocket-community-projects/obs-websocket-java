package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
abstract class InputEvent extends Event {

  private transient Data messageData;

  protected InputEvent(Event.Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString
  public static class SpecificData {

    protected String inputName;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {

    protected transient SpecificData eventData;
  }
}
