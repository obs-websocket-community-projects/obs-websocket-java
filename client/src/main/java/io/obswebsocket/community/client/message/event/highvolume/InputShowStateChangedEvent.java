package io.obswebsocket.community.client.message.event.highvolume;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputShowStateChangedEvent extends InputStateChangedEvent<InputShowStateChangedEvent.SpecificData> {
  protected InputShowStateChangedEvent() {
    super(Intent.InputShowStateChanged);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputStateChangedEvent.SpecificData {
    private Boolean videoShowing;
  }
}
