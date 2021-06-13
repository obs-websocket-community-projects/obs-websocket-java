package net.twasi.obsremotejava.message.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;

import java.util.List;
import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class RequestBatch extends Message {
    protected String requestId;
    protected Boolean haltOnFailure;
    protected List<? extends Request> requests;

    @Builder
    public RequestBatch(Boolean haltOnFailure, List<? extends Request> requests) {
        super(Type.RequestBatch);

        this.requestId = UUID.randomUUID().toString();
        this.haltOnFailure = haltOnFailure;
        this.requests = requests;
    }
}
