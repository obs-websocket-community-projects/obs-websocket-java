package net.twasi.obsremotejava.message;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;

public class MessageDeserializer implements JsonDeserializer<Message> {
    private HashMap<Message.Type, Class<? extends Message>> typeRegistry = new HashMap<>();

    public void registerMessageType(Message.Type type, Class<? extends Message> clazz) {
        this.typeRegistry.put(type, clazz);
    }

    @Override
    public Message deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Message message = null;

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("messageType")) {
                Message.Type messageType = Message.Type.valueOf(jsonObject.get("messageType").getAsString());

                if (this.typeRegistry.containsKey(messageType)) {
                    message = context.deserialize(jsonElement, this.typeRegistry.get(messageType));
                }
            }
        }

        return message;
    }
}
