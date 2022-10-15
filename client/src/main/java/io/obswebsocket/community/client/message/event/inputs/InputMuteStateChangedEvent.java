package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputMuteStateChangedEvent extends
    InputEvent<InputMuteStateChangedEvent.SpecificData> {

  protected InputMuteStateChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputMuteStateChangedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private Boolean inputMuted;
  }
}
