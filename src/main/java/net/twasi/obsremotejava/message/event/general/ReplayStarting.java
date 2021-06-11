package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class ReplayStarting extends Event {
    static {
        Event.registerEventType(Type.ReplayStarting, ReplayStarting.class);
    }

    protected ReplayStarting() {
        super(Type.ReplayStarting);
    }
}
