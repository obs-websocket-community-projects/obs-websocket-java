package io.obswebsocket.community.client.message.event;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.obswebsocket.community.client.message.event.Event.Intent;
import java.lang.reflect.Type;
import java.util.Arrays;

public class EventIntentSerialization implements JsonDeserializer<Event.Intent>,
    JsonSerializer<Event.Intent> {

  @Override
  public Event.Intent deserialize(JsonElement jsonElement, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    int rawIntent = jsonElement.getAsInt();
    return Arrays.stream(Intent.values()).filter(intent -> intent.getValue() == rawIntent)
        .findFirst().orElse(null);
  }

  @Override
  public JsonElement serialize(Event.Intent src, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(src.getValue());
  }
}
