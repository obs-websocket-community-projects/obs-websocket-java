package io.obswebsocket.community.client.message.event.ui;

import io.obswebsocket.community.client.message.event.Event;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StudioModeStateChangedEvent extends Event<StudioModeStateChangedEvent.SpecificData> {
  protected StudioModeStateChangedEvent() {
    super(Intent.UI);
  }

  protected StudioModeStateChangedEvent(StudioModeStateChangedEvent.SpecificData data) {
    super(Intent.UI, data);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {
    private Boolean studioModeEnabled;
  }
}
