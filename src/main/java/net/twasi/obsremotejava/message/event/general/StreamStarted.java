package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class StreamStarted extends Event {
    protected StreamStarted() {
        super(Type.StreamStarted);
    }
}
