package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentProfileChangedEvent extends Event<CurrentProfileChangedEvent.SpecificData> {
  protected CurrentProfileChangedEvent() {
    super(Intent.Config);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private String currentProfileName;
  }
}
