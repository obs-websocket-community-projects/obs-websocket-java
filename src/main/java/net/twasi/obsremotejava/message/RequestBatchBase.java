package net.twasi.obsremotejava.message;

import java.util.List;
import java.util.UUID;

public abstract class RequestBatchBase extends MessageBase {
    protected String requestId;
    protected Boolean haltOnFailure;
    protected List<RequestBase> requests;

    public RequestBatchBase() {
        super(Type.RequestBatch);

        this.requestId = UUID.randomUUID().toString();
    }
}
