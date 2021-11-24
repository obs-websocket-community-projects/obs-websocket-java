package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class SceneItemEvent extends Event {

  private transient Data messageData;

  protected SceneItemEvent(Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private String sceneName;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends Event.Data {

    protected transient SpecificData eventData;
  }
}
