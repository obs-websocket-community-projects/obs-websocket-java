package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputNameChangedEvent extends InputEvent {

  @SerializedName("d")
  private Data messageData;

  protected InputNameChangedEvent() {
    super(Type.InputNameChanged, Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {

    private String oldInputName;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends InputEvent.Data {

    protected SpecificData eventData;
  }
}
