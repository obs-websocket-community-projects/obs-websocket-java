package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class FilterCreatedEvent extends FilterEvent {

  @SerializedName("d")
  private final FilterEvent.Data messageData;

  protected FilterCreatedEvent() {
    super(Type.FilterCreated, Intent.Filters);

    FilterEvent.Data superData = super.getMessageData();
    this.messageData = FilterEvent.Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }
}
