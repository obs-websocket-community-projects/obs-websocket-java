package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputCreatedEvent extends InputEvent {

  @SerializedName("d")
  private Data messageData;

  protected InputCreatedEvent() {
    super(Type.InputCreated, Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {

    private String inputKind;
    private JsonObject inputSettings;
    private JsonObject defaultInputSettings;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends InputEvent.Data {

    protected SpecificData eventData;
  }
}
