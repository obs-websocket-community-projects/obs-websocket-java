package io.obswebsocket.community.client.message.event.mediainputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputActionTriggeredEvent extends MediaInputEvent {

  @SerializedName("d")
  private Data messageData;

  protected MediaInputActionTriggeredEvent() {
    super(Type.MediaInputActionTriggered, Intent.MediaInputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends MediaInputEvent.SpecificData {

    private String mediaAction;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends MediaInputEvent.Data {

    protected SpecificData eventData;
  }
}
