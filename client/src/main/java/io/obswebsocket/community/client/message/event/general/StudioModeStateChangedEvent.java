package io.obswebsocket.community.client.message.event.general;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StudioModeStateChangedEvent extends Event {

  @SerializedName("d")
  private Data messageData;

  protected StudioModeStateChangedEvent() {
    super(Type.StudioModeStateChanged, Intent.General);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private Boolean studioModeEnabled;
  }

  @Getter
  @ToString
  public static class Data extends Event.Data {

    protected SpecificData eventData;
  }
}
