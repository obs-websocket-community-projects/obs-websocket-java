package net.twasi.obsremotejava.message.response;

import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.request.Request;

import java.util.HashMap;

public abstract class RequestResponse extends Message {
    public static HashMap<Request.Type, Class<? extends RequestResponse>> REQUEST_RESPONSE_REGISTRY = new HashMap<>();

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

    public static void registerRequestResponseType(Request.Type requestType, Class<? extends RequestResponse> clazz) {
        RequestResponse.REQUEST_RESPONSE_REGISTRY.put(requestType, clazz);
    }
}
