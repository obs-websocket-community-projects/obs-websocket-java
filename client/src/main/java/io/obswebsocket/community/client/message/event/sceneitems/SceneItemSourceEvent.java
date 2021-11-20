package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class SceneItemSourceEvent extends SceneItemEvent {

  protected SceneItemSourceEvent(Type eventType, Intent intent) {
    super(eventType, intent);
  }

  @Getter
  @ToString(callSuper = true)
  protected static class Data extends SceneItemEvent.Data {

    private String sourceName;
    private Integer sourceItemId;
  }
}
