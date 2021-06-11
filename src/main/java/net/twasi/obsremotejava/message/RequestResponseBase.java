package net.twasi.obsremotejava.message;

public abstract class RequestResponseBase extends MessageBase {
    protected RequestType requestType;
    protected String requestId;
    protected Status requestStatus;

    public RequestResponseBase() {
        super(Type.RequestResponse);
    }

    public static class Status {
        protected Boolean result;
        protected Integer code;
        protected String comment;
    }
}
