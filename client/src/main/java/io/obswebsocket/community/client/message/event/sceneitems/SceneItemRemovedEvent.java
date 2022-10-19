package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A scene item has been removed.
 * <p>
 * This event is not emitted when the scene the item is in is removed.
 * <p>
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemRemovedEvent extends Event<SceneItemRemovedEvent.SpecificData> {

  protected SceneItemRemovedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemRemovedEvent(SceneItemRemovedEvent.SpecificData data) {
    super(Intent.SceneItems, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * Name of the scene the item was removed from
     */
    @NonNull
    private String sceneName;

    /**
     * Name of the underlying source (input/scene)
     */
    @NonNull
    private String sourceName;

    /**
     * Numeric ID of the scene item
     */
    @NonNull
    private Number sceneItemId;
  }
}
