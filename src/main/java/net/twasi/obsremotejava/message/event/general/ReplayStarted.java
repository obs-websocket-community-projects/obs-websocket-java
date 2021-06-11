package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class ReplayStarted extends Event {
    static {
        Event.registerEventType(Type.ReplayStarted, ReplayStarted.class);
    }

    protected ReplayStarted() {
        super(Type.ReplayStarted);
    }
}
