package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The state of the record output has changed.
 * <p>
 * This class is generated, do not edit!
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

    /**
     * File name for the saved recording, if record stopped. `null` otherwise
     */
    @NonNull
    private String outputPath;
  }
}
