// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
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

  /**
   * Name of the affected input
   *
   * @return the inputName
   */
  public String getInputName() {
    return getMessageData().getEventData().getInputName();
  }

  /**
   * New audio balance value of the input
   *
   * @return the inputAudioBalance
   */
  public Number getInputAudioBalance() {
    return getMessageData().getEventData().getInputAudioBalance();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the affected input
     */
    private String inputName;

    /**
     * New audio balance value of the input
     */
    private Number inputAudioBalance;
  }
}
