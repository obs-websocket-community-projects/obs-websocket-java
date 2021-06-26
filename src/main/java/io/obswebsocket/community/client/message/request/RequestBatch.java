package io.obswebsocket.community.client.message.request;

import io.obswebsocket.community.client.message.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class RequestBatch extends Message {
    protected String requestId;
    protected Boolean haltOnFailure;
    protected List<Request> requests;

    @Builder
    public RequestBatch(
            Boolean haltOnFailure,
            List<Request> requests
    ) {
        super(Type.RequestBatch);

        this.requestId = UUID.randomUUID().toString();
        this.haltOnFailure = haltOnFailure;
        this.requests = requests;
    }
}
