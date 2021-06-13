package net.twasi.obsremotejava.message.response;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import net.twasi.obsremotejava.message.request.Request;

public class RequestResponseDeserializer implements JsonDeserializer<RequestResponse> {
    @Override
    public RequestResponse deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        RequestResponse requestResponse = null;

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
                    requestResponse = context.deserialize(jsonElement, eventType.getRequestResponseClass());
                }
            }
        }

        return requestResponse;
    }
}
