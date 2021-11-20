package io.obswebsocket.community.client.message.event.inputs;

import lombok.ToString;

@ToString(callSuper = true)
public class InputRemovedEvent extends InputEvent {

  protected InputRemovedEvent() {
    super(Type.InputRemoved, Intent.Inputs);
  }
}
