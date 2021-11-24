package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
abstract class OutputStateChangedEvent extends Event {

  private transient Data messageData;

  protected OutputStateChangedEvent(Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private Boolean outputActive;
    private String outputState;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {

    protected transient SpecificData eventData;
  }
}
