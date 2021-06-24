package io.obswebsocket.community.message;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageSerialization implements JsonDeserializer<Message>, JsonSerializer<Message> {
    @Override
    public Message deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
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
