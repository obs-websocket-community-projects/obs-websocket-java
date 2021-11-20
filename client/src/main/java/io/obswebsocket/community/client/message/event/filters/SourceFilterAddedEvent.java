package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SourceFilterAddedEvent extends SourceFilterEvent {

  @SerializedName("d")
  private final SourceFilterEvent.Data messageData;

  protected SourceFilterAddedEvent() {
    super(Type.SourceFilterAdded, Intent.Filters);

    SourceFilterEvent.Data superData = super.getMessageData();
    this.messageData = SourceFilterEvent.Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }
}
