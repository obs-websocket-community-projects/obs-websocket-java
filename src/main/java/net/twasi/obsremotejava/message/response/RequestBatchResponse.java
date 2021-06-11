package net.twasi.obsremotejava.message.response;

import net.twasi.obsremotejava.message.Message;

import java.util.List;

public abstract class RequestBatchResponse extends Message {
    static {
        Message.registerMessageType(Type.RequestBatchResponse, RequestBatchResponse.class);
    }

    protected String requestId;
    protected List<RequestResponse> results;

    public RequestBatchResponse() {
        super(Type.RequestBatchResponse);
    }
}
