// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The name of an input has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputNameChangedEvent extends Event<InputNameChangedEvent.SpecificData> {
  protected InputNameChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputNameChangedEvent(InputNameChangedEvent.SpecificData data) {
    super(Intent.Inputs, data);
  }

  /**
   * Old name of the input
   *
   * @return the oldInputName
   */
  public String getOldInputName() {
    return getMessageData().getEventData().getOldInputName();
  }

  /**
   * New name of the input
   *
   * @return the inputName
   */
  public String getInputName() {
    return getMessageData().getEventData().getInputName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Old name of the input
     */
    private String oldInputName;

    /**
     * New name of the input
     */
    private String inputName;
  }
}
