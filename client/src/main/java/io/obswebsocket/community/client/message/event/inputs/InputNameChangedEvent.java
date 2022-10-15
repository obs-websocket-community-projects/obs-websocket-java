package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputNameChangedEvent extends InputEvent<InputNameChangedEvent.SpecificData> {

  protected InputNameChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputNameChangedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private String oldInputName;
  }
}
