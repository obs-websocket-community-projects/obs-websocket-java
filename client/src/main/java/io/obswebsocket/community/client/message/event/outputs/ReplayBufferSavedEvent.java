// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The replay buffer has been saved.
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

  /**
   * Path of the saved replay file
   *
   * @return the savedReplayPath
   */
  public String getSavedReplayPath() {
    return getMessageData().getEventData().getSavedReplayPath();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Path of the saved replay file
     */
    private String savedReplayPath;
  }
}
