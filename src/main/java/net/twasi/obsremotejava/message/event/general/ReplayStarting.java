package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class ReplayStarting extends Event {
    protected ReplayStarting() {
        super(Type.ReplayStarting);
    }
}
