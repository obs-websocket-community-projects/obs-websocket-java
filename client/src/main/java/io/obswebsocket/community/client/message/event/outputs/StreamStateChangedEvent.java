// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The state of the stream output has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class StreamStateChangedEvent extends Event<StreamStateChangedEvent.SpecificData> {
  protected StreamStateChangedEvent() {
    super(Intent.Outputs);
  }

  protected StreamStateChangedEvent(StreamStateChangedEvent.SpecificData data) {
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
  }
}
