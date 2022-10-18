package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DataField {

  @SerializedName("valueName")
  @Expose
  public String valueName;
  @SerializedName("valueType")
  @Expose
  public String valueType;
  @SerializedName("valueDescription")
  @Expose
  public String valueDescription;
}
