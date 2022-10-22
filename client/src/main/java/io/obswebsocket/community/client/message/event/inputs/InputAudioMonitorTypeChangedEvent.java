// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The monitor type of an input has changed.
 *
 * Available types are:
 *
 * - `OBS_MONITORING_TYPE_NONE`
 * - `OBS_MONITORING_TYPE_MONITOR_ONLY`
 * - `OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT`
 */
@Getter
@ToString(
    callSuper = true
)
public class InputAudioMonitorTypeChangedEvent extends Event<InputAudioMonitorTypeChangedEvent.SpecificData> {
  protected InputAudioMonitorTypeChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioMonitorTypeChangedEvent(InputAudioMonitorTypeChangedEvent.SpecificData data) {
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
   * New monitor type of the input
   *
   * @return the monitorType
   */
  public Input.MonitorType getMonitorType() {
    return getMessageData().getEventData().getMonitorType();
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
     * New monitor type of the input
     */
    private Input.MonitorType monitorType;
  }
}
