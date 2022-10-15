package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class InputEvent<T extends InputEvent.SpecificData> extends Event<T> {

  protected InputEvent(Intent intent) {
    super(intent);
  }

  protected InputEvent(Intent intent, T data) {
    super(intent, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {

    protected String inputName;
  }
}
