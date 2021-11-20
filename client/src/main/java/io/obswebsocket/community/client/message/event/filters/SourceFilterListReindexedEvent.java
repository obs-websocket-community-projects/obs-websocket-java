package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SourceFilterListReindexedEvent extends Event {

  @SerializedName("d")
  private final Data messageData;

  protected SourceFilterListReindexedEvent() {
    super(Type.SourceFilterListReindexed, Intent.Filters);

    Event.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString
  public static class SpecificData {
    // TODO SourceFilterListReindexedEvent.Data
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {

    protected SpecificData eventData;
  }
}
