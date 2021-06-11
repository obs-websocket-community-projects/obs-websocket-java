package net.twasi.obsremotejava.message;

public abstract class Message {
    protected Type messageType;

    public Message(Type type) {
        this.messageType = type;
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
}
