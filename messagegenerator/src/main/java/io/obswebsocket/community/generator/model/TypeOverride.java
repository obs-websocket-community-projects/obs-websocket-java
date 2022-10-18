package io.obswebsocket.community.generator.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TypeOverride {

  @SerializedName("msg")
  @Expose
  public String msg;
  @SerializedName("property")
  @Expose
  public String property;
  @SerializedName("type")
  @Expose
  public String type;

  public String getKey() {
    return msg + ":" + property;
  }
}
