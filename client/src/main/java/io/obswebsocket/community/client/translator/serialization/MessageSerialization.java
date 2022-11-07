package io.obswebsocket.community.client.translator.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.Message.OperationCode;
import java.lang.reflect.Type;

public class MessageSerialization implements JsonDeserializer<Message>, JsonSerializer<Message> {

  @Override
  public Message deserialize(JsonElement jsonElement, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    Message message = null;

    if (jsonElement.isJsonObject()) {
      JsonObject jsonObject = jsonElement.getAsJsonObject();
      if (jsonObject.has("op")) {
        OperationCode messageOperationCode = null;
        try {
          messageOperationCode = OperationCode.fromRawCode(jsonObject.get("op").getAsLong());
        } catch (IllegalArgumentException illegalArgumentException) {
          // unknown OperationCode
        }

        if (messageOperationCode != null) {
          message = context.deserialize(jsonElement, messageOperationCode.getMessageClass());
        }
      }
    }

    return message;
  }

  @Override
  public JsonElement serialize(Message src, Type typeOfSrc, JsonSerializationContext context) {
    return context.serialize(src);
  }
}
