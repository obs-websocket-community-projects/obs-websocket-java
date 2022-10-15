package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputAudioSyncOffsetChangedEvent extends
    InputEvent<InputAudioSyncOffsetChangedEvent.SpecificData> {

  protected InputAudioSyncOffsetChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioSyncOffsetChangedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private Long inputAudioSyncOffset;
  }
}
