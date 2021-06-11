package net.twasi.obsremotejava.message.request;

import net.twasi.obsremotejava.message.Message;

import java.util.List;
import java.util.UUID;

public abstract class RequestBatch extends Message {
    static {
        Message.registerMessageType(Type.RequestBatch, RequestBatch.class);
    }

    protected String requestId;
    protected Boolean haltOnFailure;
    protected List<Request> requests;

    public RequestBatch() {
        super(Type.RequestBatch);

        this.requestId = UUID.randomUUID().toString();
    }
}
