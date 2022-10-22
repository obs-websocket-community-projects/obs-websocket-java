// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * An input has been created.
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

  /**
   * Name of the input
   *
   * @return the inputName
   */
  public String getInputName() {
    return getMessageData().getEventData().getInputName();
  }

  /**
   * The kind of the input
   *
   * @return the inputKind
   */
  public String getInputKind() {
    return getMessageData().getEventData().getInputKind();
  }

  /**
   * The unversioned kind of input (aka no `_v2` stuff)
   *
   * @return the unversionedInputKind
   */
  public String getUnversionedInputKind() {
    return getMessageData().getEventData().getUnversionedInputKind();
  }

  /**
   * The settings configured to the input when it was created
   *
   * @return the inputSettings
   */
  public JsonObject getInputSettings() {
    return getMessageData().getEventData().getInputSettings();
  }

  /**
   * The default settings for the input
   *
   * @return the defaultInputSettings
   */
  public JsonObject getDefaultInputSettings() {
    return getMessageData().getEventData().getDefaultInputSettings();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    private String inputName;

    /**
     * The kind of the input
     */
    private String inputKind;

    /**
     * The unversioned kind of input (aka no `_v2` stuff)
     */
    private String unversionedInputKind;

    /**
     * The settings configured to the input when it was created
     */
    private JsonObject inputSettings;

    /**
     * The default settings for the input
     */
    private JsonObject defaultInputSettings;
  }
}
