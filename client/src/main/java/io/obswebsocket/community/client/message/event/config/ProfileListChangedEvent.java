package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * The profile list has changed.
 * <p>
 * This class is generated, do not edit!
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * Updated list of profiles
     */
    @NonNull
    @Singular
    private List<String> profiles;
  }
}
