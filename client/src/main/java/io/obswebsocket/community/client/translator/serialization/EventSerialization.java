package io.obswebsocket.community.client.translator.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.EventType;
import java.lang.reflect.Type;

public class EventSerialization implements JsonDeserializer<Event>, JsonSerializer<Event> {

  @Override
  public Event deserialize(JsonElement jsonElement, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    Event event = null;

    if (jsonElement.isJsonObject()) {
      JsonObject jsonObject = jsonElement.getAsJsonObject();

      if (jsonObject.has("d") && jsonObject.get("d").isJsonObject()) {
        JsonObject jsonEventData = jsonObject.getAsJsonObject("d");

        if (jsonEventData.has("eventType")) {
          EventType eventType = null;
          try {
            eventType = EventType.valueOf(jsonEventData.get("eventType").getAsString());
          } catch (IllegalArgumentException illegalArgumentException) {
            // unknown EventType
          }

          if (eventType != null) {
            event = context.deserialize(jsonElement, eventType.getEventClass());
          }
        }
      }
    }

    return event;
  }

  @Override
  public JsonElement serialize(Event src, Type typeOfSrc, JsonSerializationContext context) {
    return context.serialize(src);
  }
}
