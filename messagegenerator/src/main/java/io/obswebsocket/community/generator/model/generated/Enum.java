package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Enum {

  @SerializedName("enumType")
  @Expose
  public String enumType;
  @SerializedName("enumIdentifiers")
  @Expose
  public List<EnumIdentifier> enumIdentifiers = null;
}
