package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SourceFilterRemovedEvent extends SourceFilterEvent {

  @SerializedName("d")
  private final SourceFilterEvent.Data messageData;

  protected SourceFilterRemovedEvent() {
    super(Type.SourceFilterRemoved, Intent.Filters);

    SourceFilterEvent.Data superData = super.getMessageData();
    this.messageData = SourceFilterEvent.Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }
}
