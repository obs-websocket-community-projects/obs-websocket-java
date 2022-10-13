package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ReplayBufferSavedEvent extends Event<ReplayBufferSavedEvent.SpecificData> {
  protected ReplayBufferSavedEvent() {
    super(Intent.Outputs);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private String savedReplayPath;
  }
}
