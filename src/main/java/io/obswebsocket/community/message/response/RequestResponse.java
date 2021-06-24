package io.obswebsocket.community.message.response;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.Message;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public abstract class RequestResponse extends Message {
    protected Request.Type requestType;
    protected String requestId;
    protected Status requestStatus;

    protected RequestResponse(Request.Type requestType) {
        super(Type.RequestResponse);

        this.requestType = requestType;
    }

    @Getter
    @ToString
    public static class Status {
        protected Boolean result;
        protected Integer code;
        protected String comment;
    }
}
