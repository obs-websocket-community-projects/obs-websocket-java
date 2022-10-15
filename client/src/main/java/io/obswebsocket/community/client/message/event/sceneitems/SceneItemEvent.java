package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneItemEvent<T extends SceneItemEvent.SpecificData> extends Event<T> {

  protected SceneItemEvent(Intent intent) {
    super(intent);
  }

  protected SceneItemEvent(Intent intent, T data) {
    super(intent, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {

    private String sceneName;
  }
}
