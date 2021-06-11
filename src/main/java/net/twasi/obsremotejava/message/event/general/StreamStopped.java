package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class StreamStopped extends Event {
    static {
        Event.registerEventType(Type.StreamStopped, StreamStopped.class);
    }

    protected StreamStopped() {
        super(Type.StreamStopped);
    }
}
