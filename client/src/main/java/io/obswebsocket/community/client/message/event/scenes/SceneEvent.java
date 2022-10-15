package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneEvent<T extends SceneEvent.SpecificData> extends Event<T> {

  protected SceneEvent(Intent intent) {
    super(intent);
  }

  protected SceneEvent(Intent intent, T data) {
    super(intent, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {

    private String sceneName;
  }
}
