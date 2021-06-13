package net.twasi.obsremotejava.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString
public abstract class InputEvent extends Event {
    private Data eventData;

    protected InputEvent(Event.Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    public static class Data {
        private String inputName;
    }
}
