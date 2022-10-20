// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A scene item has been created.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemCreatedEvent extends Event<SceneItemCreatedEvent.SpecificData> {
  protected SceneItemCreatedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemCreatedEvent(SceneItemCreatedEvent.SpecificData data) {
    super(Intent.SceneItems, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the scene the item was added to
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

    /**
     * Index position of the item
     */
    @NonNull
    private Number sceneItemIndex;
  }
}
