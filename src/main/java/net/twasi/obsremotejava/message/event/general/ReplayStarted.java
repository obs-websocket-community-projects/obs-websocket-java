package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class ReplayStarted extends Event {
    protected ReplayStarted() {
        super(Type.ReplayStarted);
    }
}
