package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputNameChangedEvent extends InputEvent<InputNameChangedEvent.SpecificData> {
  protected InputNameChangedEvent() {
    super(Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {
    private String oldInputName;
  }
}
