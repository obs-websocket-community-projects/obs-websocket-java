package io.obswebsocket.community.client.message.response.mediaInputs;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetMediaInputStatusResponse extends RequestResponse {
    private Data responseData;

    public GetMediaInputStatusResponse() {
        super(Request.Type.GetMediaInputStatus);
    }

    @Getter
    @ToString
    public static class Data {
        private MediaState mediaState;
        private Long mediaDuration; // optional
        private Long mediaTimestamp; // optional
    }

    public enum MediaState {
        @SerializedName("none")
        NONE,
        @SerializedName("playing")
        PLAYING,
        @SerializedName("opening")
        OPENING,
        @SerializedName("buffering")
        BUFFERING,
        @SerializedName("paused")
        PAUSED,
        @SerializedName("stopped")
        STOPPED,
        @SerializedName("ended")
        ENDED,
        @SerializedName("error")
        ERROR,
        @SerializedName("unknown")
        UNKNOWN
    }
}