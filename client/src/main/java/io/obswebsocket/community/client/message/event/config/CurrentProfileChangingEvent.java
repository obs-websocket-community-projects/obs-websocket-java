package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The current profile has begun changing.
 *
 * This class is generated, do not edit!
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the current profile
     */
    @NonNull
    private String profileName;
  }
}
