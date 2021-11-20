package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
public class InputRemovedEvent extends InputEvent {

  @SerializedName("d")
  private final Data messageData;

  protected InputRemovedEvent() {
    super(Type.InputRemoved, Intent.Inputs);

    InputEvent.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends InputEvent.Data {

    @SerializedName("eventData")
    protected InputEvent.SpecificData eventData;
  }
}
