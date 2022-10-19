package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The replay buffer has been saved.
 * <p>
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class ReplayBufferSavedEvent extends Event<ReplayBufferSavedEvent.SpecificData> {

  protected ReplayBufferSavedEvent() {
    super(Intent.Outputs);
  }

  protected ReplayBufferSavedEvent(ReplayBufferSavedEvent.SpecificData data) {
    super(Intent.Outputs, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * Path of the saved replay file
     */
    @NonNull
    private String savedReplayPath;
  }
}
