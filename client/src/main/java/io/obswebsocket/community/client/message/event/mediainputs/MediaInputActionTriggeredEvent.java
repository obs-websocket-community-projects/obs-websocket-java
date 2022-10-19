package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * An action has been performed on an input.
 *
 * This class is generated, do not edit!
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
     * Action performed on the input. See `ObsMediaInputAction` enum
     */
    @NonNull
    private String mediaAction;
  }
}
