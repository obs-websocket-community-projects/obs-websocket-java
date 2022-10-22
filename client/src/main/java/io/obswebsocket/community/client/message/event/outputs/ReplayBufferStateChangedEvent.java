// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The state of the replay buffer output has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class ReplayBufferStateChangedEvent extends Event<ReplayBufferStateChangedEvent.SpecificData> {
  protected ReplayBufferStateChangedEvent() {
    super(Intent.Outputs);
  }

  protected ReplayBufferStateChangedEvent(ReplayBufferStateChangedEvent.SpecificData data) {
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
