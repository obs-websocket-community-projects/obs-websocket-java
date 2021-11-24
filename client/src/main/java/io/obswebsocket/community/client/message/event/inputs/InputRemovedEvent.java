package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputRemovedEvent extends InputEvent {

  @SerializedName("d")
  private Data messageData;

  protected InputRemovedEvent() {
    super(Type.InputRemoved, Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends InputEvent.Data {

    protected InputEvent.SpecificData eventData;
  }
}
