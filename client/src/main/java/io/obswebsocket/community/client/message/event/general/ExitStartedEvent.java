package io.obswebsocket.community.client.message.event.general;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ExitStartedEvent extends Event {

  @SerializedName("d")
  private Data messageData;

  protected ExitStartedEvent() {
    super(Type.ExitStarted, Intent.General);
  }
}
