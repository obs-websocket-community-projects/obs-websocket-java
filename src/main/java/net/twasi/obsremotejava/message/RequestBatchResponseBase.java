package net.twasi.obsremotejava.message;

import java.util.List;

public abstract class RequestBatchResponseBase extends MessageBase {
    protected String requestId;
    protected List<RequestResponseBase> results;

    public RequestBatchResponseBase() {
        super(Type.RequestBatchResponse);
    }
}
