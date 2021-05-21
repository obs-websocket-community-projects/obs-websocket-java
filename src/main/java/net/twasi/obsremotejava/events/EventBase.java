package net.twasi.obsremotejava.events;

import com.google.gson.annotations.SerializedName;

public abstract class EventBase {
    @SerializedName("update-type")
    private EventType eventType;
    @SerializedName("stream-timecode")
    private EventType streamTimecode;
    @SerializedName("rec-timecode")
    private EventType recTimecode;

    public EventType getEventType() {
        return eventType;
    }

    public EventType getStreamTimecode() {
        return streamTimecode;
    }

    public EventType getRecTimecode() {
        return recTimecode;
    }
}
