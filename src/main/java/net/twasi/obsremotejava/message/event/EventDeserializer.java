package net.twasi.obsremotejava.message.event;

import com.google.gson.*;
import net.twasi.obsremotejava.message.Message;

import java.lang.reflect.Type;

public class EventDeserializer implements JsonDeserializer<Event> {
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
                    event = context.deserialize(jsonElement, eventType.getClazz());
                }
            }
        }

        return event;
    }
}
