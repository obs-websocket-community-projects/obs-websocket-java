// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The current profile has begun changing.
 */
@Getter
@ToString(
    callSuper = true
)
public class CurrentProfileChangingEvent extends Event<CurrentProfileChangingEvent.SpecificData> {
  protected CurrentProfileChangingEvent() {
    super(Intent.Config);
  }

  protected CurrentProfileChangingEvent(CurrentProfileChangingEvent.SpecificData data) {
    super(Intent.Config, data);
  }

  /**
   * Name of the current profile
   *
   * @return the profileName
   */
  public String getProfileName() {
    return getMessageData().getEventData().getProfileName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the current profile
     */
    private String profileName;
  }
}
