package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Output {

  private String outputName;
  private String outputKind;
  private Integer outputWidth;
  private Integer outputHeight;
  private Boolean outputActive;
  private OutputFlags outputFlags;

  @Getter
  @ToString
  public static class OutputFlags {

    @SerializedName("OBS_OUTPUT_AUDIO")
    private Boolean audio;
    @SerializedName("OBS_OUTPUT_VIDEO")
    private Boolean video;
    @SerializedName("OBS_OUTPUT_ENCODED")
    private Boolean encoded;
    @SerializedName("OBS_OUTPUT_MULTI_TRACK")
    private Boolean multiTrack;
    @SerializedName("OBS_OUTPUT_SERVICE")
    private Boolean service;
  }
}
