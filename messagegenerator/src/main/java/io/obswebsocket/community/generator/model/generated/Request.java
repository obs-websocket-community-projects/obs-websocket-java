package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
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
  public List<RequestField> requestFields = null;
  @SerializedName("responseFields")
  @Expose
  public List<RequestField> responseFields = null;
}
