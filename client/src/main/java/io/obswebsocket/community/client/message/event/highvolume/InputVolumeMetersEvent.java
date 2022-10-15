package io.obswebsocket.community.client.message.event.highvolume;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Input;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputVolumeMetersEvent extends Event<InputVolumeMetersEvent.SpecificData> {

  protected InputVolumeMetersEvent() {
    super(Intent.InputVolumeMeters);
  }

  protected InputVolumeMetersEvent(SpecificData data) {
    super(Intent.InputVolumeMeters, data);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {

    @Singular
    private List<InputLevels> inputs;
  }

  @Getter
  @Setter
  @ToString(callSuper = true)
  static class InputLevels extends Input {
    private Double inputVolumeDb;
    private Double inputVolumeMul;
  }
}
