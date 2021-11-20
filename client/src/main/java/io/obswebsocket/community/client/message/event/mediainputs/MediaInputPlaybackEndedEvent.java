package io.obswebsocket.community.client.message.event.mediainputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class MediaInputPlaybackEndedEvent extends MediaInputEvent {

  @SerializedName("d")
  private final Data messageData;

  protected MediaInputPlaybackEndedEvent() {
    super(Type.MediaInputPlaybackEnded, Intent.MediaInputs);

    MediaInputEvent.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends MediaInputEvent.Data {

    protected MediaInputEvent.SpecificData eventData;
  }
}
