package net.twasi.obsremotejava.message.response;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public abstract class RequestResponse extends Message {
    protected Request.Type requestType;
    protected String requestId;
    protected Status requestStatus;

    public RequestResponse(Request.Type requestType) {
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
