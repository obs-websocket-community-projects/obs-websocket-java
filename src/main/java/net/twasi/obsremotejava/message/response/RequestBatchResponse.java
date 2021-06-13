package net.twasi.obsremotejava.message.response;

import java.util.List;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;

@Getter
@ToString(callSuper = true)
public abstract class RequestBatchResponse extends Message {
    protected String requestId;
    protected List<RequestResponse> results;

    public RequestBatchResponse() {
        super(Type.RequestBatchResponse);
    }
}
