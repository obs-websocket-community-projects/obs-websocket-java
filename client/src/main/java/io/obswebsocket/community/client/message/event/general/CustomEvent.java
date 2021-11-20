package io.obswebsocket.community.client.message.event.general;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CustomEvent extends Event {

  @SerializedName("d")
  private final Data messageData;

  protected CustomEvent() {
    super(Type.CustomEvent, Intent.General);

    Event.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data extends Event.Data {

    protected JsonObject eventData;
  }
}
