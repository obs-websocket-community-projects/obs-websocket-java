// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The sync offset of an input has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputAudioSyncOffsetChangedEvent extends Event<InputAudioSyncOffsetChangedEvent.SpecificData> {
  protected InputAudioSyncOffsetChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioSyncOffsetChangedEvent(InputAudioSyncOffsetChangedEvent.SpecificData data) {
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
   * New sync offset in milliseconds
   *
   * @return the inputAudioSyncOffset
   */
  public Number getInputAudioSyncOffset() {
    return getMessageData().getEventData().getInputAudioSyncOffset();
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
     * New sync offset in milliseconds
     */
    private Number inputAudioSyncOffset;
  }
}
