// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * An input's volume level has changed.
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

  /**
   * Name of the input
   *
   * @return the inputName
   */
  public String getInputName() {
    return getMessageData().getEventData().getInputName();
  }

  /**
   * New volume level multiplier
   *
   * @return the inputVolumeMul
   */
  public Number getInputVolumeMul() {
    return getMessageData().getEventData().getInputVolumeMul();
  }

  /**
   * New volume level in dB
   *
   * @return the inputVolumeDb
   */
  public Number getInputVolumeDb() {
    return getMessageData().getEventData().getInputVolumeDb();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    private String inputName;

    /**
     * New volume level multiplier
     */
    private Number inputVolumeMul;

    /**
     * New volume level in dB
     */
    private Number inputVolumeDb;
  }
}
