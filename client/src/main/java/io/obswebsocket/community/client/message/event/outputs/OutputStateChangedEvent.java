package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class OutputStateChangedEvent extends Event<OutputStateChangedEvent.SpecificData> {
  protected OutputStateChangedEvent(Intent intent) {
    super(intent);
  }

  protected OutputStateChangedEvent(Intent intent, OutputStateChangedEvent.SpecificData specificData) {
    super(intent, specificData);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {
    private Boolean outputActive;
    private String outputState;
  }
}
