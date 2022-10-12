package io.obswebsocket.community.client.message.event.inputs;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputAudioTracksChangedEvent extends InputEvent<InputAudioTracksChangedEvent.SpecificData> {
  protected InputAudioTracksChangedEvent() {
    super(Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {
    private List<Integer> inputAudioTracks;
  }
}
