package io.obswebsocket.community.client.message.event.highvolume;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputActiveStateChangedEvent extends InputStateChangedEvent {

  @SerializedName("d")
  private Data messageData;

  protected InputActiveStateChangedEvent() {
    super(Type.InputActiveStateChanged, Intent.InputActiveStateChanged);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputStateChangedEvent.SpecificData {

    private Boolean videoActive;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends InputStateChangedEvent.Data {

    protected SpecificData eventData;
  }
}
