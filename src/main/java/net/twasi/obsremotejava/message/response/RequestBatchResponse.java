package net.twasi.obsremotejava.message.response;

import java.util.List;
import net.twasi.obsremotejava.message.Message;

public abstract class RequestBatchResponse extends Message {
    protected String requestId;
    protected List<RequestResponse> results;

    public RequestBatchResponse() {
        super(Type.RequestBatchResponse);
    }
}
