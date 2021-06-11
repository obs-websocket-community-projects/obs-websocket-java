package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class ReplayStopped extends Event {
    static {
        Event.registerEventType(Type.ReplayStopped, ReplayStopped.class);
    }

    protected ReplayStopped() {
        super(Type.ReplayStopped);
    }
}
