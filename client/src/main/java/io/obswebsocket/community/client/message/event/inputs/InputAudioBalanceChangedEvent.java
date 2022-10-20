// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The audio balance value of an input has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputAudioBalanceChangedEvent extends Event<InputAudioBalanceChangedEvent.SpecificData> {
  protected InputAudioBalanceChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioBalanceChangedEvent(InputAudioBalanceChangedEvent.SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the affected input
     */
    @NonNull
    private String inputName;

    /**
     * New audio balance value of the input
     */
    @NonNull
    private Number inputAudioBalance;
  }
}
