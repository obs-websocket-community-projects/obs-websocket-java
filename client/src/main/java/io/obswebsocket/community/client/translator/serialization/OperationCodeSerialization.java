package io.obswebsocket.community.client.translator.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.obswebsocket.community.client.message.Message.OperationCode;
import java.lang.reflect.Type;

public class OperationCodeSerialization implements JsonDeserializer<OperationCode>, JsonSerializer<OperationCode>  {

  @Override
  public OperationCode deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    return OperationCode.fromRawCode(json.getAsLong());
  }

  @Override
  public JsonElement serialize(OperationCode src, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(src.getRawCode());
  }
}
