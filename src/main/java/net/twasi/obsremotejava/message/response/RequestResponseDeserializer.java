package net.twasi.obsremotejava.message.response;

import com.google.gson.*;
import net.twasi.obsremotejava.message.request.Request;

import java.lang.reflect.Type;

public class RequestResponseDeserializer implements JsonDeserializer<RequestResponse> {
    @Override
    public RequestResponse deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        RequestResponse requestResponse = null;

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("requestType")) {
                Request.Type eventType = Request.Type.valueOf(jsonObject.get("requestType").getAsString());

                if (RequestResponse.REQUEST_RESPONSE_REGISTRY.containsKey(eventType)) {
                    requestResponse = context.deserialize(jsonElement, RequestResponse.REQUEST_RESPONSE_REGISTRY.get(eventType));
                }
            }
        }

        return requestResponse;
    }
}
