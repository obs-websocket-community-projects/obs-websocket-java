package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class FilterNameChangedEvent extends FilterEvent {

  @SerializedName("d")
  private Data messageData;

  protected FilterNameChangedEvent() {
    super(Type.FilterNameChanged, Intent.Filters);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends FilterEvent.SpecificData {

    private String oldFilterName;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends FilterEvent.Data {

    protected SpecificData eventData;
  }
}
