package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputVolumeChangedEvent extends InputEvent {

  private Data eventData;

  protected InputVolumeChangedEvent() {
    super(Type.InputVolumeChanged, Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {

    private float inputVolumeMul;
    private float inputVolumeDb;
  }
}
