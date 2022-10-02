package io.obswebsocket.community.client.message.event.general;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StudioModeStateChangedEvent extends Event<StudioModeStateChangedEvent.SpecificData> {
  protected StudioModeStateChangedEvent() {
    super(Intent.General);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private Boolean studioModeEnabled;
  }
}
