package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class StreamStopped extends Event {
    protected StreamStopped() {
        super(Type.StreamStopped);
    }
}