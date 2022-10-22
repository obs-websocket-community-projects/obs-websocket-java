// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
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

  /**
   * Name of the input
   *
   * @return the inputName
   */
  public String getInputName() {
    return getMessageData().getEventData().getInputName();
  }

  /**
   * Object of audio tracks along with their associated enable states
   *
   * @return the inputAudioTracks
   */
  public Input.AudioTracks getInputAudioTracks() {
    return getMessageData().getEventData().getInputAudioTracks();
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
     * Object of audio tracks along with their associated enable states
     */
    private Input.AudioTracks inputAudioTracks;
  }
}
