package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputVolumeChangedEvent extends InputEvent<InputVolumeChangedEvent.SpecificData> {

  protected InputVolumeChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputVolumeChangedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private float inputVolumeMul;
    private float inputVolumeDb;
  }
}
