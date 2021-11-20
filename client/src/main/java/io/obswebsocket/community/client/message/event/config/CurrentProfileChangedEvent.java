package io.obswebsocket.community.client.message.event.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CurrentProfileChangedEvent extends Event {

  @SerializedName("d")
  private final Data messageData;


  protected CurrentProfileChangedEvent() {
    super(Type.CurrentProfileChanged, Intent.Config);

    Event.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {

    private String currentProfileName;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {

    @SerializedName("eventData")
    protected SpecificData eventData;
  }
}
