package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Event {

  @SerializedName("description")
  @Expose
  public String description;
  @SerializedName("eventType")
  @Expose
  public String eventType;
  @SerializedName("eventSubscription")
  @Expose
  public String eventSubscription;
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
  @SerializedName("dataFields")
  @Expose
  public List<DataField> dataFields = null;
}
