package net.twasi.obsremotejava.message.request;

import com.google.gson.*;
import net.twasi.obsremotejava.message.event.Event;

import java.lang.reflect.Type;

public class RequestDeserializer implements JsonDeserializer<Request> {
    @Override
    public Request deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Request request = null;

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("requestType")) {
                Request.Type eventType = Request.Type.valueOf(jsonObject.get("requestType").getAsString());

                if (Request.REQUEST_REGISTRY.containsKey(eventType)) {
                    request = context.deserialize(jsonElement, Request.REQUEST_REGISTRY.get(eventType));
                }
            }
        }

        return request;
    }
}
