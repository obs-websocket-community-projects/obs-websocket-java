package net.twasi.obsremotejava.message.response;

import net.twasi.obsremotejava.message.Message;

import java.util.List;

public abstract class RequestBatchResponse extends Message {
    protected String requestId;
    protected List<RequestResponse> results;

    public RequestBatchResponse() {
        super(Type.RequestBatchResponse);
    }
}
