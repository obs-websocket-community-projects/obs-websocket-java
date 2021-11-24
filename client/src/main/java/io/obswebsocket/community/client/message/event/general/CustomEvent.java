package io.obswebsocket.community.client.message.event.general;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CustomEvent extends Event {

  @SerializedName("d")
  private Data messageData;

  protected CustomEvent() {
    super(Type.CustomEvent, Intent.General);
  }

  @Getter
  @ToString
  public static class Data extends Event.Data {

    protected JsonObject eventData;
  }
}
