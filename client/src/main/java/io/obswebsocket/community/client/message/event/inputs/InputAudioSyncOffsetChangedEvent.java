package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputAudioSyncOffsetChangedEvent extends Event<InputAudioSyncOffsetChangedEvent.SpecificData> {
  protected InputAudioSyncOffsetChangedEvent() {
    super(Intent.Inputs);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private Long inputAudioSyncOffset;
  }
}
