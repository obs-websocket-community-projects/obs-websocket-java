package io.obswebsocket.community.client.message.event.outputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class VirtualcamStateChangedEvent extends OutputStateChangedEvent {
  protected VirtualcamStateChangedEvent() {
    super(Intent.Outputs);
  }
}
