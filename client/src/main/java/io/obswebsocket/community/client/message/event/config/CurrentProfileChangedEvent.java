package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The current profile has changed.
 *
 * This class is generated, do not edit!
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the new profile
     */
    @NonNull
    private String profileName;
  }
}
