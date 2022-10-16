package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.model.SceneItem;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneItemTransformChangedEvent extends
    SceneItemEvent<SceneItemTransformChangedEvent.SpecificData> {

  protected SceneItemTransformChangedEvent() {
    super(Intent.SceneItemTransformChanged);
  }

  protected SceneItemTransformChangedEvent(SpecificData data) {
    super(Intent.SceneItemTransformChanged, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneItemEvent.SpecificData {

    private Integer sceneItemId;
    private SceneItem.Transform sceneItemTransform;
  }
}
