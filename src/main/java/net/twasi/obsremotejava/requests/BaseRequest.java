package net.twasi.obsremotejava.requests;

import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseRequest {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

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
