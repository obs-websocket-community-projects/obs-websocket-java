package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The monitor type of an input has changed.
 *
 * Available types are:
 *
 * - `OBS_MONITORING_TYPE_NONE`
 * - `OBS_MONITORING_TYPE_MONITOR_ONLY`
 * - `OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT`
 *
 * This class is generated, do not edit!
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
     * New monitor type of the input
     */
    @NonNull
    private Input.MonitorType monitorType;
  }
}
