// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Custom event emitted by `BroadcastCustomEvent`.
 */
@Getter
@ToString(
    callSuper = true
)
public class CustomEventEvent extends Event<CustomEventEvent.SpecificData> {
  protected CustomEventEvent() {
    super(Intent.General);
  }

  protected CustomEventEvent(CustomEventEvent.SpecificData data) {
    super(Intent.General, data);
  }

  /**
   * Custom event data
   *
   * @return the eventData
   */
  public JsonObject getEventData() {
    return getMessageData().getEventData().getEventData();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Custom event data
     */
    private JsonObject eventData;
  }
}
