package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputVolumeChangedEvent extends InputEvent {

  @SerializedName("d")
  private Data messageData;

  protected InputVolumeChangedEvent() {
    super(Type.InputVolumeChanged, Intent.Inputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends InputEvent.SpecificData {

    private float inputVolumeMul;
    private float inputVolumeDb;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends InputEvent.Data {

    protected SpecificData eventData;
  }
}
