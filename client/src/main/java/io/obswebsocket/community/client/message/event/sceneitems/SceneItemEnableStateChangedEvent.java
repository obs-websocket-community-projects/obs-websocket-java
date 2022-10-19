package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A scene item's enable state has changed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemEnableStateChangedEvent extends Event<SceneItemEnableStateChangedEvent.SpecificData> {
  protected SceneItemEnableStateChangedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemEnableStateChangedEvent(SceneItemEnableStateChangedEvent.SpecificData data) {
    super(Intent.SceneItems, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the scene the item is in
     */
    @NonNull
    private String sceneName;

    /**
     * Numeric ID of the scene item
     */
    @NonNull
    private Number sceneItemId;

    /**
     * Whether the scene item is enabled (visible)
     */
    @NonNull
    private Boolean sceneItemEnabled;
  }
}
