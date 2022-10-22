package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
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

  @ToString
  @Getter
  @Builder
  public static class AudioTracks {

    @SerializedName("1")
    private Boolean one;
    @SerializedName("2")
    private Boolean two;
    @SerializedName("3")
    private Boolean three;
    @SerializedName("4")
    private Boolean four;
    @SerializedName("5")
    private Boolean five;
    @SerializedName("6")
    private Boolean six;
  }

  @Getter
  @ToString
  public static class PropertyItem {

    private String itemName;
    private String itemValue;
    private Boolean itemEnabled;
  }
}
