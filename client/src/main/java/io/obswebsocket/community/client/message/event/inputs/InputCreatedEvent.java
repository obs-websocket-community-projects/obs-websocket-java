package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.JsonObject;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputCreatedEvent extends InputEvent<InputCreatedEvent.SpecificData> {
  protected InputCreatedEvent() {
    super(Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {
    private String inputKind;
    private JsonObject inputSettings;
    private JsonObject defaultInputSettings;
  }
}
