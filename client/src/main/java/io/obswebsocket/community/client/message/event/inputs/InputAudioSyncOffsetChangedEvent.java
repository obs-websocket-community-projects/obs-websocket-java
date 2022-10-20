// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    @NonNull
    private String inputName;

    /**
     * New sync offset in milliseconds
     */
    @NonNull
    private Number inputAudioSyncOffset;
  }
}
