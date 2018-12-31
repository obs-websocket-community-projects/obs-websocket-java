package net.twasi.obsremotejava.requests;

import com.google.gson.annotations.SerializedName;

public class BaseRequest {
    @SerializedName("request-type")
    private RequestType requestType;

    @SerializedName("message-id")
    private String messageId;

    private static int lastId = 0;

    public BaseRequest(RequestType type) {
        lastId++;
        messageId = String.valueOf(lastId);
        this.requestType = type;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getMessageId() {
        return messageId;
    }
}
