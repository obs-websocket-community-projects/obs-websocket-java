package net.twasi.obsremotejava.message;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageDeserializer implements JsonDeserializer<Message> {
    @Override
    public Message deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Message message = null;

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("messageType")) {
                Message.Type messageType = Message.Type.valueOf(jsonObject.get("messageType").getAsString());

                if (Message.MESSAGE_REGISTRY.containsKey(messageType)) {
                    message = context.deserialize(jsonElement, Message.MESSAGE_REGISTRY.get(messageType));
                }
            }
        }

        return message;
    }
}
