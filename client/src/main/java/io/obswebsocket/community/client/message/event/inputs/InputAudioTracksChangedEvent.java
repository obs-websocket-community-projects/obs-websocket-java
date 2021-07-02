package io.obswebsocket.community.client.message.event.inputs;

import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputAudioTracksChangedEvent extends InputEvent {

  private Data eventData;

  protected InputAudioTracksChangedEvent() {
    super(Type.InputAudioTracksChanged, Category.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends InputEvent.Data {

    private List<Integer> inputAudioTracks;
  }
}
