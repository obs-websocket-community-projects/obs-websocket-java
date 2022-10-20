// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The audio tracks of an input have changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputAudioTracksChangedEvent extends Event<InputAudioTracksChangedEvent.SpecificData> {
  protected InputAudioTracksChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioTracksChangedEvent(InputAudioTracksChangedEvent.SpecificData data) {
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
     * Object of audio tracks along with their associated enable states
     */
    @NonNull
    private Input.AudioTracks inputAudioTracks;
  }
}
