package net.twasi.obsremotejava.requests;

import com.google.gson.annotations.SerializedName;

public abstract class ResponseBase {
    @SerializedName("message-id")
    private String messageId;
    private String status;
    private String error;

    public String getMessageId() {
        return messageId;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return ""
          + "messageId='" + messageId + '\''
          + ", status='" + status + '\''
          + ", error='" + error + "', ";
    }
}
