// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * An input's show state has changed.
 *
 * When an input is showing, it means it's being shown by the preview or a dialog.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputShowStateChangedEvent extends Event<InputShowStateChangedEvent.SpecificData> {
  protected InputShowStateChangedEvent() {
    super(Intent.InputShowStateChanged);
  }

  protected InputShowStateChangedEvent(InputShowStateChangedEvent.SpecificData data) {
    super(Intent.InputShowStateChanged, data);
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
   * Whether the input is showing
   *
   * @return the videoShowing
   */
  public Boolean getVideoShowing() {
    return getMessageData().getEventData().getVideoShowing();
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
     * Whether the input is showing
     */
    private Boolean videoShowing;
  }
}
