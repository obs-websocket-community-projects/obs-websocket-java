// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the output is active
     */
    @NonNull
    private Boolean outputActive;

    /**
     * The specific state of the output
     */
    @NonNull
    private String outputState;
  }
}
