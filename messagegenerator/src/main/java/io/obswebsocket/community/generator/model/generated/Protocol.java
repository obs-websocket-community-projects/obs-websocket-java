package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Protocol {

  @SerializedName("enums")
  @Expose
  public List<Enum> enums = null;
  @SerializedName("requests")
  @Expose
  public List<Request> requests = null;
  @SerializedName("events")
  @Expose
  public List<Event> events = null;
}
