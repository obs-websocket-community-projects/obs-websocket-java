// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The state of the record output has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class RecordStateChangedEvent extends Event<RecordStateChangedEvent.SpecificData> {
  protected RecordStateChangedEvent() {
    super(Intent.Outputs);
  }

  protected RecordStateChangedEvent(RecordStateChangedEvent.SpecificData data) {
    super(Intent.Outputs, data);
  }

  /**
   * Whether the output is active
   *
   * @return the outputActive
   */
  public Boolean getOutputActive() {
    return getMessageData().getEventData().getOutputActive();
  }

  /**
   * The specific state of the output
   *
   * @return the outputState
   */
  public String getOutputState() {
    return getMessageData().getEventData().getOutputState();
  }

  /**
   * File name for the saved recording, if record stopped. `null` otherwise
   *
   * @return the outputPath
   */
  public String getOutputPath() {
    return getMessageData().getEventData().getOutputPath();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the output is active
     */
    private Boolean outputActive;

    /**
     * The specific state of the output
     */
    private String outputState;

    /**
     * File name for the saved recording, if record stopped. `null` otherwise
     */
    private String outputPath;
  }
}
