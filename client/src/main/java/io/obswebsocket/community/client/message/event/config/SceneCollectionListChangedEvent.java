// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

/**
 * The scene collection list has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneCollectionListChangedEvent extends Event<SceneCollectionListChangedEvent.SpecificData> {
  protected SceneCollectionListChangedEvent() {
    super(Intent.Config);
  }

  protected SceneCollectionListChangedEvent(SceneCollectionListChangedEvent.SpecificData data) {
    super(Intent.Config, data);
  }

  /**
   * Updated list of scene collections
   *
   * @return the sceneCollections
   */
  public List<String> getSceneCollections() {
    return getMessageData().getEventData().getSceneCollections();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Updated list of scene collections
     */
    @Singular
    private List<String> sceneCollections;
  }
}
