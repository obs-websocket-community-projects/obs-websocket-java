// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * An input's active state has changed.
 *
 * When an input is active, it means it's being shown by the program feed.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputActiveStateChangedEvent extends Event<InputActiveStateChangedEvent.SpecificData> {
  protected InputActiveStateChangedEvent() {
    super(Intent.InputActiveStateChanged);
  }

  protected InputActiveStateChangedEvent(InputActiveStateChangedEvent.SpecificData data) {
    super(Intent.InputActiveStateChanged, data);
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
   * Whether the input is active
   *
   * @return the videoActive
   */
  public Boolean getVideoActive() {
    return getMessageData().getEventData().getVideoActive();
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
     * Whether the input is active
     */
    private Boolean videoActive;
  }
}
