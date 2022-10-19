package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A scene item's lock state has changed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemLockStateChangedEvent extends Event<SceneItemLockStateChangedEvent.SpecificData> {
  protected SceneItemLockStateChangedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemLockStateChangedEvent(SceneItemLockStateChangedEvent.SpecificData data) {
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
     * Whether the scene item is locked
     */
    @NonNull
    private Boolean sceneItemLocked;
  }
}
