package net.twasi.obsremotejava.message;

import java.util.List;

public abstract class RequestBatchResponse extends Message {
    protected String requestId;
    protected List<RequestResponse> results;

    public RequestBatchResponse() {
        super(Type.RequestBatchResponse);
    }
}
