package io.obswebsocket.community.client.message.request;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class RequestSerialization implements JsonDeserializer<Request>, JsonSerializer<Request> {

  @Override
  public Request deserialize(JsonElement jsonElement, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    Request request = null;

    if (jsonElement.isJsonObject()) {
      JsonObject jsonObject = jsonElement.getAsJsonObject();
      if (jsonObject.has("requestType")) {
        Request.Type requestType = null;
        try {
          requestType = Request.Type.valueOf(jsonObject.get("requestType").getAsString());
        } catch (IllegalArgumentException illegalArgumentException) {
          // unknown RequestType
        }

        if (requestType != null) {
          request = context.deserialize(jsonElement, requestType.getRequestClass());
        }
      }
    }

    return request;
  }

  @Override
  public JsonElement serialize(Request src, Type typeOfSrc, JsonSerializationContext context) {
    return context.serialize(src);
  }
}
