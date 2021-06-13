package net.twasi.obsremotejava.message.request;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class RequestDeserializer implements JsonDeserializer<Request> {
    @Override
    public Request deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Request request = null;

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("requestType")) {
                Request.Type eventType = null;
                try {
                    eventType = Request.Type.valueOf(jsonObject.get("requestType").getAsString());
                } catch (IllegalArgumentException illegalArgumentException) {
                    // unknown RequestType
                }

                if (eventType != null) {
                    request = context.deserialize(jsonElement, eventType.getRequestClass());
                }
            }
        }

        return request;
    }
}
