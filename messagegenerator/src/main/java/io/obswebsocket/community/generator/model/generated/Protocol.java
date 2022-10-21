package io.obswebsocket.community.generator.model.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Protocol {

  @SerializedName("enums")
  @Expose
  @Singular
  public List<Enum> enums;
  @SerializedName("requests")
  @Expose
  @Singular
  public List<Request> requests;
  @SerializedName("events")
  @Expose
  @Singular
  public List<Event> events;
}
