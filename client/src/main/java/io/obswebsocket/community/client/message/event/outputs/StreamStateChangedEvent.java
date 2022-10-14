package io.obswebsocket.community.client.message.event.outputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StreamStateChangedEvent extends OutputStateChangedEvent {
  protected StreamStateChangedEvent() {
    super(Intent.Outputs);
  }

  protected StreamStateChangedEvent(SpecificData specificData) {
    super(Intent.Outputs, specificData);
  }
}
