package net.twasi.obsremotejava.message.request;

import java.util.List;
import java.util.UUID;
import net.twasi.obsremotejava.message.Message;

public abstract class RequestBatch extends Message {
    protected String requestId;
    protected Boolean haltOnFailure;
    protected List<Request> requests;

    public RequestBatch() {
        super(Type.RequestBatch);

        this.requestId = UUID.randomUUID().toString();
    }
}
