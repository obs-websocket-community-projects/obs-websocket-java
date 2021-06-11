package net.twasi.obsremotejava.message.event;

import com.google.gson.*;

import java.lang.reflect.Type;

public class EventDeserializer implements JsonDeserializer<Event> {
    @Override
    public Event deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Event event = null;

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("eventType")) {
                Event.Type eventType = Event.Type.valueOf(jsonObject.get("eventType").getAsString());

                if (Event.EVENT_REGISTRY.containsKey(eventType)) {
                    event = context.deserialize(jsonElement, Event.EVENT_REGISTRY.get(eventType));
                }
            }
        }

        return event;
    }
}
