package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputAudioMonitorTypeChangedEvent extends
    InputEvent<InputAudioMonitorTypeChangedEvent.SpecificData> {

  protected InputAudioMonitorTypeChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioMonitorTypeChangedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private MonitorType monitorType;
  }

  @ToString
  public enum MonitorType { // TODO: Are these different from Input.MonitorType?
    @SerializedName("OBS_MONITORING_TYPE_NONE")
    NONE,
    @SerializedName("OBS_MONITORING_TYPE_MONITOR_ONLY")
    MONITOR_ONLY,
    @SerializedName("OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT")
    MONITOR_AND_OUTPUT
  }
}
