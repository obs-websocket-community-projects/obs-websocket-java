package io.obswebsocket.community.client.message;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class MessageSerialization implements JsonDeserializer<Message>, JsonSerializer<Message> {

  @Override
  public Message deserialize(JsonElement jsonElement, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    Message message = null;

    if (jsonElement.isJsonObject()) {
      JsonObject jsonObject = jsonElement.getAsJsonObject();
      if (jsonObject.has("messageType")) {
        Message.Type messageType = null;
        try {
          messageType = Message.Type.valueOf(jsonObject.get("messageType").getAsString());
        } catch (IllegalArgumentException illegalArgumentException) {
          // unknown MessageType
        }

        if (messageType != null) {
          message = context.deserialize(jsonElement, messageType.getMessageClass());
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
