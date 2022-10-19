package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class AudioTracks {

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
