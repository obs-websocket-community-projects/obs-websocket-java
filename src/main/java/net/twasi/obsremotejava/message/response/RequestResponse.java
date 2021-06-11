package net.twasi.obsremotejava.message.response;

import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.request.Request;

public abstract class RequestResponse extends Message {
    static {
        Message.registerMessageType(Type.RequestResponse, RequestResponse.class);
    }

    protected Request.Type requestType;
    protected String requestId;
    protected Status requestStatus;

    public RequestResponse(Request.Type requestType) {
        super(Type.RequestResponse);

        this.requestType = requestType;
    }

    public static class Status {
        protected Boolean result;
        protected Integer code;
        protected String comment;
    }
}
