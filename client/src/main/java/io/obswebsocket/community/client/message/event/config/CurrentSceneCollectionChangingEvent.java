// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The current scene collection has begun changing.
 *
 * Note: We recommend using this event to trigger a pause of all polling requests, as performing any requests during a
 * scene collection change is considered undefined behavior and can cause crashes!
 */
@Getter
@ToString(
    callSuper = true
)
public class CurrentSceneCollectionChangingEvent extends Event<CurrentSceneCollectionChangingEvent.SpecificData> {
  protected CurrentSceneCollectionChangingEvent() {
    super(Intent.Config);
  }

  protected CurrentSceneCollectionChangingEvent(
      CurrentSceneCollectionChangingEvent.SpecificData data) {
    super(Intent.Config, data);
  }

  /**
   * Name of the current scene collection
   *
   * @return the sceneCollectionName
   */
  public String getSceneCollectionName() {
    return getMessageData().getEventData().getSceneCollectionName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the current scene collection
     */
    private String sceneCollectionName;
  }
}
