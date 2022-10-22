// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A media input has finished playing.
 */
@Getter
@ToString(
    callSuper = true
)
public class MediaInputPlaybackEndedEvent extends Event<MediaInputPlaybackEndedEvent.SpecificData> {
  protected MediaInputPlaybackEndedEvent() {
    super(Intent.MediaInputs);
  }

  protected MediaInputPlaybackEndedEvent(MediaInputPlaybackEndedEvent.SpecificData data) {
    super(Intent.MediaInputs, data);
  }

  /**
   * Name of the input
   *
   * @return the inputName
   */
  public String getInputName() {
    return getMessageData().getEventData().getInputName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    private String inputName;
  }
}
