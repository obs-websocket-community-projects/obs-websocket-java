package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * An input has been created.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class InputCreatedEvent extends Event<InputCreatedEvent.SpecificData> {
  protected InputCreatedEvent() {
    super(Intent.Inputs);
  }

  protected InputCreatedEvent(InputCreatedEvent.SpecificData data) {
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

    /**
     * The kind of the input
     */
    @NonNull
    private String inputKind;

    /**
     * The unversioned kind of input (aka no `_v2` stuff)
     */
    @NonNull
    private String unversionedInputKind;

    /**
     * The settings configured to the input when it was created
     */
    @NonNull
    private JsonObject inputSettings;

    /**
     * The default settings for the input
     */
    @NonNull
    private JsonObject defaultInputSettings;
  }
}
