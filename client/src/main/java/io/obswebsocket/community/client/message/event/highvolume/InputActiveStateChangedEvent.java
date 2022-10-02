package io.obswebsocket.community.client.message.event.highvolume;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputActiveStateChangedEvent extends InputStateChangedEvent<InputActiveStateChangedEvent.SpecificData> {
  protected InputActiveStateChangedEvent() {
    super(Intent.InputActiveStateChanged);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputStateChangedEvent.SpecificData {
    private Boolean videoActive;
  }
}
