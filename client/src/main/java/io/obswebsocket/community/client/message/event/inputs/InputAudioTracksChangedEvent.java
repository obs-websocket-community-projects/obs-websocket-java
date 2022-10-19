package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.model.AudioTracks;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputAudioTracksChangedEvent extends
    InputEvent<InputAudioTracksChangedEvent.SpecificData> {

  protected InputAudioTracksChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioTracksChangedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private AudioTracks inputAudioTracks;
  }
}
