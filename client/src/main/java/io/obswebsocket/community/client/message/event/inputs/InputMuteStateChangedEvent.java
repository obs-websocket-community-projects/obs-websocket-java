// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
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

  /**
   * Name of the input
   *
   * @return the inputName
   */
  public String getInputName() {
    return getMessageData().getEventData().getInputName();
  }

  /**
   * Whether the input is muted
   *
   * @return the inputMuted
   */
  public Boolean getInputMuted() {
    return getMessageData().getEventData().getInputMuted();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    private String inputName;

    /**
     * Whether the input is muted
     */
    private Boolean inputMuted;
  }
}
