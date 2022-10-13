package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputMuteStateChangedEvent extends InputEvent<InputMuteStateChangedEvent.SpecificData> {
  protected InputMuteStateChangedEvent() {
    super(Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {
    private Boolean inputMuted;
  }
}
