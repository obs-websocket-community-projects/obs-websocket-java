package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class ReplayStopping extends Event {
    static {
        Event.registerEventType(Type.ReplayStopping, ReplayStopping.class);
    }

    protected ReplayStopping() {
        super(Type.ReplayStopping);
    }
}
