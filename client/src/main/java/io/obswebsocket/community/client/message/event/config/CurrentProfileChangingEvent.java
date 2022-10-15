package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentProfileChangingEvent extends Event<CurrentProfileChangingEvent.SpecificData> {

  protected CurrentProfileChangingEvent() {
    super(Intent.Config);
  }

  protected CurrentProfileChangingEvent(SpecificData data) {
    super(Intent.Config, data);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PACKAGE)
  public static class SpecificData {

    private String profileName;
  }
}
