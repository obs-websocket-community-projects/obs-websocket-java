package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class MediaInputEvent<T extends MediaInputEvent.SpecificData> extends Event<T> {
  protected MediaInputEvent(Intent intent) {
    super(intent);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private String inputName;
  }
}
