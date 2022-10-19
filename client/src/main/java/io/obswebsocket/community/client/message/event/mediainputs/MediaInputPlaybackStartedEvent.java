package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A media input has started playing.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class MediaInputPlaybackStartedEvent extends Event<MediaInputPlaybackStartedEvent.SpecificData> {
  protected MediaInputPlaybackStartedEvent() {
    super(Intent.MediaInputs);
  }

  protected MediaInputPlaybackStartedEvent(MediaInputPlaybackStartedEvent.SpecificData data) {
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
  }
}
