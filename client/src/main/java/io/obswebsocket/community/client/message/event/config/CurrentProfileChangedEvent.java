package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentProfileChangedEvent extends Event<CurrentProfileChangedEvent.SpecificData> {

  protected CurrentProfileChangedEvent() {
    super(Intent.Config);
  }

  protected CurrentProfileChangedEvent(SpecificData data) {
    super(Intent.Config, data);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {

    private String profileName;
  }
}
