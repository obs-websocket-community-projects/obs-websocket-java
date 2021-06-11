package net.twasi.obsremotejava.message;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;

public class MessageDeserializer implements JsonDeserializer<MessageBase> {
    private HashMap<MessageBase.Type, Class<? extends MessageBase>> typeRegistry = new HashMap<>();

    public void registerMessageType(MessageBase.Type type, Class<? extends MessageBase> clazz) {
        this.typeRegistry.put(type, clazz);
    }

    @Override
    public MessageBase deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        MessageBase message = null;

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("messageType")) {
                MessageBase.Type messageType = MessageBase.Type.valueOf(jsonObject.get("messageType").getAsString());

                if (this.typeRegistry.containsKey(messageType)) {
                    message = context.deserialize(jsonElement, this.typeRegistry.get(messageType));
                }
            }
        }

        return message;
    }
}
