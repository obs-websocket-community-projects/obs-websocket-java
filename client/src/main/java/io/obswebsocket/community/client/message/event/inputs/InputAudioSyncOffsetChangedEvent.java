package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputAudioSyncOffsetChangedEvent extends Event {

  @SerializedName("d")
  private final Data messageData;

  protected InputAudioSyncOffsetChangedEvent() {
    super(Type.InputAudioSyncOffsetChanged, Intent.Inputs);

    Event.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString
  public static class SpecificData {

    private Long inputAudioSyncOffset;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {

    protected SpecificData eventData;
  }
}
