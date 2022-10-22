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
 * The profile list has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class ProfileListChangedEvent extends Event<ProfileListChangedEvent.SpecificData> {
  protected ProfileListChangedEvent() {
    super(Intent.Config);
  }

  protected ProfileListChangedEvent(ProfileListChangedEvent.SpecificData data) {
    super(Intent.Config, data);
  }

  /**
   * Updated list of profiles
   *
   * @return the profiles
   */
  public List<String> getProfiles() {
    return getMessageData().getEventData().getProfiles();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Updated list of profiles
     */
    @Singular
    private List<String> profiles;
  }
}
