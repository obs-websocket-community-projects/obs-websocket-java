// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The name of an input has changed.
 */
@Getter
@ToString(
    callSuper = true
)
public class InputNameChangedEvent extends Event<InputNameChangedEvent.SpecificData> {
  protected InputNameChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputNameChangedEvent(InputNameChangedEvent.SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Old name of the input
     */
    @NonNull
    private String oldInputName;

    /**
     * New name of the input
     */
    @NonNull
    private String inputName;
  }
}
