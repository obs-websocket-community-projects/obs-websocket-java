// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.MediaInputAction;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * An action has been performed on an input.
 */
@Getter
@ToString(
    callSuper = true
)
public class MediaInputActionTriggeredEvent extends Event<MediaInputActionTriggeredEvent.SpecificData> {
  protected MediaInputActionTriggeredEvent() {
    super(Intent.MediaInputs);
  }

  protected MediaInputActionTriggeredEvent(MediaInputActionTriggeredEvent.SpecificData data) {
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

  /**
   * Action performed on the input. See `ObsMediaInputAction` enum
   *
   * @return the mediaAction
   */
  public MediaInputAction getMediaAction() {
    return getMessageData().getEventData().getMediaAction();
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
     * Action performed on the input. See `ObsMediaInputAction` enum
     */
    private MediaInputAction mediaAction;
  }
}
