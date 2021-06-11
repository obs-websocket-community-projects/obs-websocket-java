package net.twasi.obsremotejava.message;

import java.util.UUID;

public abstract class RequestBase extends MessageBase {
    protected RequestType requestType;
    protected String requestId;

    public RequestBase(RequestType type) {
        super(Type.Request);

        this.requestType = type;
        this.requestId = UUID.randomUUID().toString();
    }
}
