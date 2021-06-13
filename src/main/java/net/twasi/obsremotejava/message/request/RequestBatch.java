package net.twasi.obsremotejava.message.request;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;

@Getter
@ToString(callSuper = true)
public abstract class RequestBatch extends Message {
    protected String requestId;
    protected Boolean haltOnFailure;
    protected List<Request> requests;

    public RequestBatch() {
        super(Type.RequestBatch);

        this.requestId = UUID.randomUUID().toString();
    }
}
