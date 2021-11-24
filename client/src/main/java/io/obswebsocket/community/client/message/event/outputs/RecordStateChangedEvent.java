package io.obswebsocket.community.client.message.event.outputs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RecordStateChangedEvent extends OutputStateChangedEvent {

  @SerializedName("d")
  private Data messageData;

  protected RecordStateChangedEvent() {
    super(Type.RecordStateChanged, Intent.Outputs);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends OutputStateChangedEvent.Data {

    protected OutputStateChangedEvent.SpecificData eventData;
  }
}
