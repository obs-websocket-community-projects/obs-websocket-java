package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class MediaInputEvent<T extends MediaInputEvent.SpecificData> extends Event<T> {
  protected MediaInputEvent(Intent intent) {
    super(intent);
  }

  protected MediaInputEvent(Intent intent, T data) {
    super(intent, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {
    private String inputName;
  }
}
