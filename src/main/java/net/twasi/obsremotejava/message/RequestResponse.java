package net.twasi.obsremotejava.message;

public abstract class RequestResponse extends Message {
    protected Request.Type requestType;
    protected String requestId;
    protected Status requestStatus;

    public RequestResponse() {
        super(Type.RequestResponse);
    }

    public static class Status {
        protected Boolean result;
        protected Integer code;
        protected String comment;
    }
}
