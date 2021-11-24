package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class FilterRemovedEvent extends FilterEvent {

  @SerializedName("d")
  private FilterEvent.Data messageData;

  protected FilterRemovedEvent() {
    super(Type.FilterRemoved, Intent.Filters);
  }
}
