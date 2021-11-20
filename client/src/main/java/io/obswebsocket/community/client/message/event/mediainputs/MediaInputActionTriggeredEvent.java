package io.obswebsocket.community.client.message.event.mediainputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class MediaInputActionTriggeredEvent extends MediaInputEvent {

  @SerializedName("d")
  private final Data messageData;

  protected MediaInputActionTriggeredEvent() {
    super(Type.MediaInputActionTriggered, Intent.MediaInputs);

    MediaInputEvent.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends MediaInputEvent.SpecificData {

    private String mediaAction;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends MediaInputEvent.Data {

    protected SpecificData eventData;
  }
}
