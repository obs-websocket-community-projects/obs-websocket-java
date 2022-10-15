package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputCreatedEvent extends InputEvent<InputCreatedEvent.SpecificData> {

  protected InputCreatedEvent() {
    super(Intent.Inputs);
  }

  protected InputCreatedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private String inputKind;
    private String unversionedInputKind;
    private JsonObject inputSettings;
    private JsonObject defaultInputSettings;
  }
}
