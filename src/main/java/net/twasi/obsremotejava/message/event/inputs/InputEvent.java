package net.twasi.obsremotejava.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString
abstract class InputEvent extends Event {
    protected InputEvent(Event.Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    protected static class Data {
        private String inputName;
    }
}
