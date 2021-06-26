package io.obswebsocket.community.client.message.response;

import com.google.gson.*;

import java.lang.reflect.Type;
import io.obswebsocket.community.client.message.request.Request;

public class RequestResponseSerialization implements JsonDeserializer<RequestResponse>, JsonSerializer<RequestResponse> {
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

    @Override
    public JsonElement serialize(RequestResponse src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src);
    }
}
