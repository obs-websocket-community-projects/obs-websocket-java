package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputAudioBalanceChangedEvent extends
    InputEvent<InputAudioBalanceChangedEvent.SpecificData> {

  protected InputAudioBalanceChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioBalanceChangedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private float inputAudioBalance;
  }
}
