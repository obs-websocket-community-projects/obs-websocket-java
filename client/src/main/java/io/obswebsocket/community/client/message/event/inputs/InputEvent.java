package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
abstract class InputEvent extends Event {

  protected InputEvent(Event.Type eventType, Category category) {
    super(eventType, category);
  }

  @Getter
  @ToString
  protected static class Data {

    private String inputName;
  }
}
