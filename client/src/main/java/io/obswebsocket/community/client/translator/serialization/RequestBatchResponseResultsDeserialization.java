package io.obswebsocket.community.client.translator.serialization;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.message.response.RequestResponse.Data;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RequestBatchResponseResultsDeserialization implements JsonDeserializer<List<Data>> {

  @Override
  public List<Data> deserialize(JsonElement jsonElement, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    List<Data> requestResponse = null;

    if (jsonElement.isJsonArray()) {
      JsonArray jsonArr = jsonElement.getAsJsonArray();
      requestResponse = new ArrayList<>();

      for (int i = 0; i < jsonArr.size(); i++) {
        JsonElement arrElement = jsonArr.get(i);
        if (!arrElement.isJsonObject()) {
          continue;
        }

        JsonObject messageData = arrElement.getAsJsonObject();
        if (messageData.has("requestType")) {
          RequestType requestType = null;
          try {
            requestType = RequestType.valueOf(messageData.get("requestType").getAsString());
          } catch (IllegalArgumentException illegalArgumentException) {
            // unknown RequestType
          }

          if (requestType != null) {
            try {
              Type dataType = getSuperTypeParam(requestType.getRequestResponseClass());
              Type typeToken = TypeToken.getParameterized(Data.class, dataType).getType();
              Data data = context.deserialize(arrElement, typeToken);
              requestResponse.add(data);
            } catch (Throwable t) {
              throw new JsonParseException(t);
            }
          }
        }
      }
    }
    return requestResponse;
  }

  private java.lang.reflect.Type getSuperTypeParam(Class<?> cls) {
    java.lang.reflect.Type parent = cls.getGenericSuperclass();
    if (parent instanceof ParameterizedType
        && ((ParameterizedType) parent).getActualTypeArguments().length > 0) {
      return ((ParameterizedType) parent).getActualTypeArguments()[0];
    }
    if (parent instanceof Class) {
      return getSuperTypeParam((Class<?>) parent);
    }
    return null;
  }
}
