// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.SceneItemIdAndIndex;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * A scene's item list has been reindexed.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemListReindexedEvent extends Event<SceneItemListReindexedEvent.SpecificData> {
  protected SceneItemListReindexedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemListReindexedEvent(SceneItemListReindexedEvent.SpecificData data) {
    super(Intent.SceneItems, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the scene
     */
    @NonNull
    private String sceneName;

    /**
     * Array of scene item objects
     */
    @NonNull
    @Singular
    private List<SceneItemIdAndIndex> sceneItems;
  }
}
