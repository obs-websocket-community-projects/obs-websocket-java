package io.obswebsocket.community.client.message.event.highvolume;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputShowStateChangedEvent extends InputStateChangedEvent {

  @SerializedName("d")
  private Data messageData;

  protected InputShowStateChangedEvent() {
    super(Type.InputShowStateChanged, Intent.InputShowStateChanged);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputStateChangedEvent.SpecificData {

    private Boolean videoShowing;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends InputStateChangedEvent.Data {

    protected SpecificData eventData;
  }
}
