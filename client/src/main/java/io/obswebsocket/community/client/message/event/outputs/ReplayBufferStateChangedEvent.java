package io.obswebsocket.community.client.message.event.outputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ReplayBufferStateChangedEvent extends OutputStateChangedEvent<OutputStateChangedEvent.SpecificData> {
  protected ReplayBufferStateChangedEvent() {
    super(Intent.Outputs);
  }

  protected ReplayBufferStateChangedEvent(OutputStateChangedEvent.SpecificData specificData) {
    super(Intent.Outputs, specificData);
  }
}
