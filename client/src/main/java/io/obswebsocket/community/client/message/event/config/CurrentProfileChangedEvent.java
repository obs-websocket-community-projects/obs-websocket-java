// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The current profile has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class CurrentProfileChangedEvent extends Event<CurrentProfileChangedEvent.SpecificData> {
  protected CurrentProfileChangedEvent() {
    super(Intent.Config);
  }

  protected CurrentProfileChangedEvent(CurrentProfileChangedEvent.SpecificData data) {
    super(Intent.Config, data);
  }

  /**
   * Name of the new profile
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
     * Name of the new profile
     */
    private String profileName;
  }
}
