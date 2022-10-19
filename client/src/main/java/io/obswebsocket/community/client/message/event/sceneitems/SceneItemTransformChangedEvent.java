package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.SceneItem;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The transform/crop of a scene item has changed.
 * <p>
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemTransformChangedEvent extends
    Event<SceneItemTransformChangedEvent.SpecificData> {

  protected SceneItemTransformChangedEvent() {
    super(Intent.SceneItemTransformChanged);
  }

  protected SceneItemTransformChangedEvent(SceneItemTransformChangedEvent.SpecificData data) {
    super(Intent.SceneItemTransformChanged, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * The name of the scene the item is in
     */
    @NonNull
    private String sceneName;

    /**
     * Numeric ID of the scene item
     */
    @NonNull
    private Number sceneItemId;

    /**
     * New transform/crop info of the scene item
     */
    @NonNull
    private SceneItem.Transform sceneItemTransform;
  }
}
