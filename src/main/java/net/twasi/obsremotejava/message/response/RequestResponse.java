package net.twasi.obsremotejava.message.response;

import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.request.Request;

import java.util.HashMap;

public abstract class RequestResponse extends Message {
    protected Request.Type requestType;
    protected String requestId;
    protected Status requestStatus;

    public RequestResponse(Request.Type requestType) {
        super(Type.RequestResponse);

        this.requestType = requestType;
    }

    public Request.Type getRequestType() {
        return this.requestType;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public Status getRequestStatus() {
        return this.requestStatus;
    }

    public static class Status {
        protected Boolean result;
        protected Integer code;
        protected String comment;

        public Boolean getResult() {
            return this.result;
        }

        public Integer getCode() {
            return this.code;
        }
        public String getComment() {
            return this.comment;
        }
    }
}
