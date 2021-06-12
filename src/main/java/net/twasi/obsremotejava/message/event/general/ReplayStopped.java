package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class ReplayStopped extends Event {
    protected ReplayStopped() {
        super(Type.ReplayStopped);
    }
}
