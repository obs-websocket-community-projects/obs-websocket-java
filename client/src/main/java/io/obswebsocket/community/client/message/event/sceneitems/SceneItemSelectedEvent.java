package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneItemSelectedEvent extends
    SceneItemEvent<SceneItemSelectedEvent.SpecificData> {

  protected SceneItemSelectedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemSelectedEvent(SpecificData data) {
    super(Intent.SceneItems, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneItemEvent.SpecificData {

    private Integer sceneItemId;
  }
}
