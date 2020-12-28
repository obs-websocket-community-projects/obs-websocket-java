package net.twasi.obsremotejava.events;

import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseEvent {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    private EventType eventType;

    public EventType getEventType() {
        return eventType;
    }

    @SerializedName("update-type")
    public void setUpdateType(String updateType) {
        log.debug(updateType);
        this.eventType = EventType.valueOf(updateType);
    }
}
