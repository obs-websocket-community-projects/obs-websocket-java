package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class RequestField {

  @SerializedName("valueName")
  @Expose
  public String valueName;
  @SerializedName("valueType")
  @Expose
  public String valueType;
  @SerializedName("valueDescription")
  @Expose
  public String valueDescription;
  @SerializedName("valueRestrictions")
  @Expose
  public Object valueRestrictions;
  @SerializedName("valueOptional")
  @Expose
  public Boolean valueOptional;
  @SerializedName("valueOptionalBehavior")
  @Expose
  public Object valueOptionalBehavior;
}
