package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnumIdentifier {

  @SerializedName("description")
  @Expose
  public String description;
  @SerializedName("enumIdentifier")
  @Expose
  public String enumIdentifier;
  @SerializedName("rpcVersion")
  @Expose
  public Integer rpcVersion;
  @SerializedName("deprecated")
  @Expose
  public Boolean deprecated;
  @SerializedName("initialVersion")
  @Expose
  public String initialVersion;
  @SerializedName("enumValue")
  @Expose
  public String enumValue;
}
