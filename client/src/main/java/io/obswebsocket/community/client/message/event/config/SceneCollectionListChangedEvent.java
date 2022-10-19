package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * The scene collection list has changed.
 * <p>
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneCollectionListChangedEvent extends
    Event<SceneCollectionListChangedEvent.SpecificData> {

  protected SceneCollectionListChangedEvent() {
    super(Intent.Config);
  }

  protected SceneCollectionListChangedEvent(SceneCollectionListChangedEvent.SpecificData data) {
    super(Intent.Config, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * Updated list of scene collections
     */
    @NonNull
    @Singular
    private List<String> sceneCollections;
  }
}
