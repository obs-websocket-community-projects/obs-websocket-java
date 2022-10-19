package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import java.lang.String;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * An input has been removed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class InputRemovedEvent extends Event<InputRemovedEvent.SpecificData> {
  protected InputRemovedEvent() {
    super(Intent.Inputs);
  }

  protected InputRemovedEvent(InputRemovedEvent.SpecificData data) {
    super(Intent.Inputs, data);
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
  }
}
