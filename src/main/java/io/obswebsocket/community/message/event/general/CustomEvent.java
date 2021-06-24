package io.obswebsocket.community.message.event.general;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.event.Event;

@Getter
@ToString(callSuper = true)
public class CustomEvent extends Event {
    private JsonObject eventData;

    @Builder
    protected CustomEvent(JsonObject eventData) {
        super(Type.CustomEvent, Category.General);
        this.eventData = eventData;
    }
}
