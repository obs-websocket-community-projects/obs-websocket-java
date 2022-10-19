package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Input {

  private String inputName;
  private String inputKind;
  private String unversionedInputKind;

  @ToString
  public enum MonitorType {
    @SerializedName("OBS_MONITORING_TYPE_NONE")
    NONE,
    @SerializedName("OBS_MONITORING_TYPE_MONITOR_ONLY")
    MONITOR_ONLY,
    @SerializedName("OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT")
    MONITOR_AND_OUTPUT
  }

  @Getter
  @ToString
  public static class PropertyItem {
    private String itemName;
    private String itemValue;
    private Boolean itemEnabled;
  }
}
