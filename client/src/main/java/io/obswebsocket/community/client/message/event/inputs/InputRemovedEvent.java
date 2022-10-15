package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputRemovedEvent extends InputEvent<InputEvent.SpecificData> {

  protected InputRemovedEvent() {
    super(Intent.Inputs);
  }

  public InputRemovedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }
}
