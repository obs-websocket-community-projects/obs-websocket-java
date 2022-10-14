package io.obswebsocket.community.client.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class MediaInputActionTriggeredEvent extends MediaInputEvent<MediaInputActionTriggeredEvent.SpecificData> {
  protected MediaInputActionTriggeredEvent() {
    super(Intent.MediaInputs);
  }

  protected MediaInputActionTriggeredEvent(MediaInputActionTriggeredEvent.SpecificData data) {
    super(Intent.MediaInputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends MediaInputEvent.SpecificData {
    private String mediaAction;
  }
}
