package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Data
@Setter
@Builder
@ToString
public class Request {

  @SerializedName("description")
  @Expose
  public String description;
  @SerializedName("requestType")
  @Expose
  public String requestType;
  @SerializedName("complexity")
  @Expose
  public Integer complexity;
  @SerializedName("rpcVersion")
  @Expose
  public String rpcVersion;
  @SerializedName("deprecated")
  @Expose
  public Boolean deprecated;
  @SerializedName("initialVersion")
  @Expose
  public String initialVersion;
  @SerializedName("category")
  @Expose
  public String category;
  @SerializedName("requestFields")
  @Expose
  @Singular
  public List<RequestField> requestFields;
  @SerializedName("responseFields")
  @Expose
  @Singular
  public List<RequestField> responseFields;
}
