package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * An input's volume level has changed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class InputVolumeChangedEvent extends Event<InputVolumeChangedEvent.SpecificData> {
  protected InputVolumeChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputVolumeChangedEvent(InputVolumeChangedEvent.SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    @NonNull
    private String inputName;

    /**
     * New volume level in multimap
     */
    @NonNull
    private Number inputVolumeMul;

    /**
     * New volume level in dB
     */
    @NonNull
    private Number inputVolumeDb;
  }
}
