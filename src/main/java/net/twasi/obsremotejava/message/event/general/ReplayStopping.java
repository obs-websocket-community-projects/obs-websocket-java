package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class ReplayStopping extends Event {
    protected ReplayStopping() {
        super(Type.ReplayStopping);
    }
}
