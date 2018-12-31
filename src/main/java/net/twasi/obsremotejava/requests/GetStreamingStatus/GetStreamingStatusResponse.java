package net.twasi.obsremotejava.requests.GetStreamingStatus;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetStreamingStatusResponse extends ResponseBase {
    private boolean streaming;
    private boolean recording;
    @SerializedName("stream-timecode")
    private String streamTimecode;
    @SerializedName("rec-timecode")
    private String recTimecode;

    public boolean isStreaming() {
        return streaming;
    }

    public boolean isRecording() {
        return recording;
    }

    public String getStreamTimecode() {
        return streamTimecode;
    }

    public String getRecTimecode() {
        return recTimecode;
    }
}
