package io.obswebsocket.community.client.message.event.highvolume;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class InputStateChangedEvent<T extends InputStateChangedEvent.SpecificData> extends
    Event<T> {

  protected InputStateChangedEvent(Intent intent) {
    super(intent);
  }

  protected InputStateChangedEvent(Intent intent, T data) {
    super(intent, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {

    private String inputName;
  }
}
