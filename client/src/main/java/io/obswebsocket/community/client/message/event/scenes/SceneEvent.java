package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class SceneEvent<T extends SceneEvent.SpecificData> extends Event<T> {
  protected SceneEvent(Intent intent) {
    super(intent);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private String sceneName;
  }
}
