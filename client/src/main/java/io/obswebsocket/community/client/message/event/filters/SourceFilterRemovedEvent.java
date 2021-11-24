package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SourceFilterRemovedEvent extends SourceFilterEvent {

  @SerializedName("d")
  private SourceFilterEvent.Data messageData;

  protected SourceFilterRemovedEvent() {
    super(Type.SourceFilterRemoved, Intent.Filters);
  }
}
