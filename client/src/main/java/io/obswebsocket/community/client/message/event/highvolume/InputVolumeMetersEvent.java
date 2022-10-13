package io.obswebsocket.community.client.message.event.highvolume;

import java.util.List;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Input;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputVolumeMetersEvent extends Event<InputVolumeMetersEvent.SpecificData> {
  protected InputVolumeMetersEvent() {
    super(Intent.InputVolumeMeters);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private List<InputLevels> inputs;
  }

  @Getter
  @ToString(callSuper = true)
  static class InputLevels extends Input {
    private Double inputVolumeDb;
    private Double inputVolumeMul;
  }
}
