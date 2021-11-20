package io.obswebsocket.community.client.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputPlaybackEndedEvent extends MediaInputEvent {

  protected MediaInputPlaybackEndedEvent() {
    super(Type.MediaInputPlaybackEnded, Intent.MediaInputs);
  }
}
