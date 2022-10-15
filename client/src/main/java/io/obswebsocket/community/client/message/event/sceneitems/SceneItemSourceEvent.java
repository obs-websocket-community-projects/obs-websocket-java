package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneItemSourceEvent<T extends SceneItemSourceEvent.SpecificData> extends
    SceneItemEvent<T> {

  protected SceneItemSourceEvent(Intent intent) {
    super(intent);
  }

  protected SceneItemSourceEvent(Intent intent, T data) {
    super(intent, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneItemEvent.SpecificData {

    private String sourceName;
    private Integer sceneItemId;
  }
}
