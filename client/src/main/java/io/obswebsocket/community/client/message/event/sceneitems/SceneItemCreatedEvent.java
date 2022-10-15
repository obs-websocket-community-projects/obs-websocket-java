package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.sceneitems.SceneItemCreatedEvent.SpecificData;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneItemCreatedEvent extends SceneItemSourceEvent<SpecificData> {

  protected SceneItemCreatedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemCreatedEvent(SpecificData data) {
    super(Intent.SceneItems, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneItemSourceEvent.SpecificData {

    private Integer sceneItemIndex;
  }
}
