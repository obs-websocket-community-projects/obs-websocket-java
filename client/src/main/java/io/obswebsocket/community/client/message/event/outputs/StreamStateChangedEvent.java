package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The state of the stream output has changed.
 *
 * This class is generated, do not edit!
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
