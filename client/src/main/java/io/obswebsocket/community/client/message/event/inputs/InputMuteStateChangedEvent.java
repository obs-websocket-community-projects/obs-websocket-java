// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * An input's mute state has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputMuteStateChangedEvent extends Event<InputMuteStateChangedEvent.SpecificData> {
  protected InputMuteStateChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputMuteStateChangedEvent(InputMuteStateChangedEvent.SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    @NonNull
    private String inputName;

    /**
     * Whether the input is muted
     */
    @NonNull
    private Boolean inputMuted;
  }
}
