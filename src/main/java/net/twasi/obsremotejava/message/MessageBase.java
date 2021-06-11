package net.twasi.obsremotejava.message;

public abstract class MessageBase {
    protected Type messageType;

    public MessageBase(Type type) {
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
