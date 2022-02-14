package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReplayBufferSavedEvent extends Event {

  private Data eventData;

  protected ReplayBufferSavedEvent() {
    super(Type.ReplayBufferSaved, Category.Outputs);
  }

  @Getter
  @ToString
  public static class Data {

    private String savedReplayPath;
  }
}
