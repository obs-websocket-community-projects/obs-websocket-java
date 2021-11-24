package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputAudioSyncOffsetChangedEvent extends Event {

  @SerializedName("d")
  private Data messageData;

  protected InputAudioSyncOffsetChangedEvent() {
    super(Type.InputAudioSyncOffsetChanged, Intent.Inputs);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private Long inputAudioSyncOffset;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends Event.Data {

    protected SpecificData eventData;
  }
}
