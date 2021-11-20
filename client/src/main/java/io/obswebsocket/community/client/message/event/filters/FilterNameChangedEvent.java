package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class FilterNameChangedEvent extends FilterEvent {

  @SerializedName("d")
  private final Data messageData;

  protected FilterNameChangedEvent() {
    super(Type.FilterNameChanged, Intent.Filters);

    FilterEvent.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends FilterEvent.SpecificData {

    private String oldFilterName;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends FilterEvent.Data {

    protected SpecificData eventData;
  }
}
