package io.obswebsocket.community.client.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputPlaybackStartedEvent extends MediaInputEvent {

  protected MediaInputPlaybackStartedEvent() {
    super(Type.MediaInputPlaybackStarted, Category.MediaInputs);
  }
}
