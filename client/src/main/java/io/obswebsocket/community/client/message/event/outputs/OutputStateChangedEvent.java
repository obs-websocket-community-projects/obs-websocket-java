package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
abstract class OutputStateChangedEvent extends Event {

  protected OutputStateChangedEvent(Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString
  protected static class Data {

    private Boolean outputActive;
    private String outputState;
  }
}
