package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputMuteStateChangedEvent extends InputEvent {

  @SerializedName("d")
  private Data messageData;

  protected InputMuteStateChangedEvent() {
    super(Type.InputMuteStateChanged, Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {

    private Boolean inputMuted;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends InputEvent.Data {

    protected SpecificData eventData;
  }
}
