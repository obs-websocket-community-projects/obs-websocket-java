package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class StreamStarted extends Event {
    static {
        Event.registerEventType(Type.StreamStarted, StreamStarted.class);
    }

    protected StreamStarted() {
        super(Type.StreamStarted);
    }
}
