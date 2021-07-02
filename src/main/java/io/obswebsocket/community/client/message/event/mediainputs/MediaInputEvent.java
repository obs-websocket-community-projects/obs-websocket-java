package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class MediaInputEvent extends Event {

  protected MediaInputEvent(Type eventType, Category category) {
    super(eventType, category);
  }

  @Getter
  @ToString
  protected static class Data {

    private String inputName;
  }
}
