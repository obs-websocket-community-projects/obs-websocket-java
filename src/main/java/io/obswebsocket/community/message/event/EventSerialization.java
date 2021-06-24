package io.obswebsocket.community.message.event;

import com.google.gson.*;

import java.lang.reflect.Type;

public class EventSerialization implements JsonDeserializer<Event>, JsonSerializer<Event> {
    @Override
    public Event deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Event event = null;

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("eventType")) {
                Event.Type eventType = null;
                try {
                    eventType = Event.Type.valueOf(jsonObject.get("eventType").getAsString());
                } catch (IllegalArgumentException illegalArgumentException) {
                    // unknown EventType
                }

                if (eventType != null) {
                    event = context.deserialize(jsonElement, eventType.getEventClass());
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
