package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import java.util.List;
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

    private List<String> profiles;
  }
}
