package io.obswebsocket.community.client.message.event.mediainputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputPlaybackEndedEvent extends MediaInputEvent {

  @SerializedName("d")
  private Data messageData;

  protected MediaInputPlaybackEndedEvent() {
    super(Type.MediaInputPlaybackEnded, Intent.MediaInputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends MediaInputEvent.Data {

    protected MediaInputEvent.SpecificData eventData;
  }
}
