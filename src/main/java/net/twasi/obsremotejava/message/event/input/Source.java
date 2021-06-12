package net.twasi.obsremotejava.message.event.input;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString
public abstract class Source extends Event {
    private Data eventData;

    protected Source(Event.Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    public static class Data {
        private String inputName;
    }
}
