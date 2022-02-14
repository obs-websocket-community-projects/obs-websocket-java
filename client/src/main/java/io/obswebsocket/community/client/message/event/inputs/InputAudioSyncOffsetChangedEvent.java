package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputAudioSyncOffsetChangedEvent extends Event {

  private Data eventData;

  protected InputAudioSyncOffsetChangedEvent() {
    super(Type.InputAudioSyncOffsetChanged, Category.Inputs);
  }

  @Getter
  @ToString
  public static class Data {

    private Long inputAudioSyncOffset;
  }
}
