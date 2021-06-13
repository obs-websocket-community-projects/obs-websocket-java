package net.twasi.obsremotejava.message.event.general;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
public class CustomEvent extends Event {
    private JsonObject eventData;

    protected CustomEvent() {
        super(Type.CustomEvent, Category.General);
    }
}
