package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ReplayBufferSavedEvent extends Event<ReplayBufferSavedEvent.SpecificData> {
  protected ReplayBufferSavedEvent() {
    super(Intent.Outputs);
  }

  protected ReplayBufferSavedEvent(ReplayBufferSavedEvent.SpecificData specificData) {
    super(Intent.Outputs, specificData);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {
    private String savedReplayPath;
  }
}
