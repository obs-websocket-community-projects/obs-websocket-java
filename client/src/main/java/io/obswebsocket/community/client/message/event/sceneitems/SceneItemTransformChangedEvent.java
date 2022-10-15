package io.obswebsocket.community.client.message.event.sceneitems;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneItemTransformChangedEvent extends
    SceneItemEvent<SceneItemTransformChangedEvent.SpecificData> {

  protected SceneItemTransformChangedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemTransformChangedEvent(SpecificData data) {
    super(Intent.SceneItems, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneItemEvent.SpecificData {

    private Integer sceneItemId;
    private JsonObject sceneItemTransform; // TODO: Better type?
  }
}
