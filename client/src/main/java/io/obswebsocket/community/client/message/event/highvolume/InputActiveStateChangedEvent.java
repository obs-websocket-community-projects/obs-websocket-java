package io.obswebsocket.community.client.message.event.highvolume;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputActiveStateChangedEvent extends
    InputStateChangedEvent<InputActiveStateChangedEvent.SpecificData> {

  protected InputActiveStateChangedEvent() {
    super(Intent.InputActiveStateChanged);
  }

  protected InputActiveStateChangedEvent(InputActiveStateChangedEvent.SpecificData data) {
    super(Intent.InputActiveStateChanged, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputStateChangedEvent.SpecificData {

    private Boolean videoActive;
  }
}
