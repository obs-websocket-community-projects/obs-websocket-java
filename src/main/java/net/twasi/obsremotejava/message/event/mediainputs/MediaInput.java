package net.twasi.obsremotejava.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
public abstract class MediaInput extends Event {
    private Data eventData;

    protected MediaInput(Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    public static class Data {
        private String inputName;
    }
}
