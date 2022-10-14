package io.obswebsocket.community.client.message.event.outputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class VirtualcamStateChangedEvent extends OutputStateChangedEvent<OutputStateChangedEvent.SpecificData> {
  protected VirtualcamStateChangedEvent() {
    super(Intent.Outputs);
  }

  protected VirtualcamStateChangedEvent(OutputStateChangedEvent.SpecificData specificData) {
    super(Intent.Outputs, specificData);
  }
}
