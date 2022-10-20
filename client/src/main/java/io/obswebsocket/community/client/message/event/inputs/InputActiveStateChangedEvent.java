// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * An input's active state has changed.
 *
 * When an input is active, it means it's being shown by the program feed.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputActiveStateChangedEvent extends Event<InputActiveStateChangedEvent.SpecificData> {
  protected InputActiveStateChangedEvent() {
    super(Intent.InputActiveStateChanged);
  }

  protected InputActiveStateChangedEvent(InputActiveStateChangedEvent.SpecificData data) {
    super(Intent.InputActiveStateChanged, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    @NonNull
    private String inputName;

    /**
     * Whether the input is active
     */
    @NonNull
    private Boolean videoActive;
  }
}
