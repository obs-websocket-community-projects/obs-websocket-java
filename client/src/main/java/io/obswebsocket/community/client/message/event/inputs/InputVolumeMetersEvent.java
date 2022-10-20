// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.InputLevels;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * A high-volume event providing volume levels of all active inputs every 50 milliseconds.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputVolumeMetersEvent extends Event<InputVolumeMetersEvent.SpecificData> {
  protected InputVolumeMetersEvent() {
    super(Intent.InputVolumeMeters);
  }

  protected InputVolumeMetersEvent(InputVolumeMetersEvent.SpecificData data) {
    super(Intent.InputVolumeMeters, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of active inputs with their associated volume levels
     */
    @NonNull
    @Singular
    private List<InputLevels> inputs;
  }
}
