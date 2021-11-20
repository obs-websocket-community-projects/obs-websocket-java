package io.obswebsocket.community.client.message.event.outputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class ReplayBufferStateChangedEvent extends OutputStateChangedEvent {

  @SerializedName("d")
  private final Data messageData;

  protected ReplayBufferStateChangedEvent() {
    super(Type.ReplayBufferStateChanged, Intent.Outputs);

    OutputStateChangedEvent.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends OutputStateChangedEvent.Data {

    protected OutputStateChangedEvent.SpecificData eventData;
  }
}
