package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class OutputStateChangedEvent<T extends OutputStateChangedEvent.SpecificData> extends Event<T> {
  protected OutputStateChangedEvent(Intent intent) {
    super(intent);
  }

  protected OutputStateChangedEvent(Intent intent, T specificData) {
    super(intent, specificData);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {
    private Boolean outputActive;
    private String outputState;
  }
}
