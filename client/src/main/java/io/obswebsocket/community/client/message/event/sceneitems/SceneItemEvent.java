package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class SceneItemEvent extends Event {

  protected SceneItemEvent(Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString
  protected static class Data {

    private String sceneName;
  }
}
