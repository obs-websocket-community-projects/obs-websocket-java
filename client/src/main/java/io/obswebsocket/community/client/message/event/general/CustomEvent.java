package io.obswebsocket.community.client.message.event.general;

import com.google.gson.JsonObject;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CustomEvent extends Event<JsonObject> {
  protected CustomEvent() {
    super(Intent.General);
  }
}
