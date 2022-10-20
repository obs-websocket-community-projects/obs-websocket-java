// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.sceneitems;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A scene item has been selected in the Ui.
 */
@Getter
@ToString(
    callSuper = true
)
public class SceneItemSelectedEvent extends Event<SceneItemSelectedEvent.SpecificData> {
  protected SceneItemSelectedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemSelectedEvent(SceneItemSelectedEvent.SpecificData data) {
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
  }
}
