package io.obswebsocket.community.client.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputActionTriggeredEvent extends MediaInputEvent<MediaInputActionTriggeredEvent.SpecificData> {
  protected MediaInputActionTriggeredEvent() {
    super(Intent.MediaInputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends MediaInputEvent.SpecificData {
    private String mediaAction;
  }
}
