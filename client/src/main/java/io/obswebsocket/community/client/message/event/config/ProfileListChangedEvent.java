package io.obswebsocket.community.client.message.event.config;

import java.util.List;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Profile;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ProfileListChangedEvent extends Event<ProfileListChangedEvent.SpecificData> {
  protected ProfileListChangedEvent() {
    super(Intent.Config);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private List<Profile> profiles;
  }
}
