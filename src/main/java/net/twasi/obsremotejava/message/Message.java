package net.twasi.obsremotejava.message;

import java.util.HashMap;

public abstract class Message {
    public static HashMap<Type, Class<? extends Message>> MESSAGE_REGISTRY = new HashMap<>();

    protected Type messageType;

    public Message(Type messageType) {
        this.messageType = messageType;
    }

    public Type getMessageType() {
        return this.messageType;
    }

    public enum Type {
        Hello,
        Identify,
        Identified,
        Reidentify,
        Request,
        RequestResponse,
        RequestBatch,
        RequestBatchResponse,
        Event,
    }

    public static void registerMessageType(Type messageType, Class<? extends Message> clazz) {
        Message.MESSAGE_REGISTRY.put(messageType, clazz);
    }
}
