package io.obswebsocket.community.client.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class VirtualcamStateChangedEvent extends OutputStateChangedEvent {

  protected VirtualcamStateChangedEvent() {
    super(Type.VirtualcamStateChanged, Intent.Outputs);
  }
}
