package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class SceneItemSourceEvent extends SceneItemEvent<SceneItemSourceEvent.SpecificData> {
  protected SceneItemSourceEvent(Intent intent) {
    super(intent);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneItemEvent.SpecificData {
    private String sourceName;
    private Integer sourceItemId;
  }
}
