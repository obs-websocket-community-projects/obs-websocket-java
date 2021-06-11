package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class RecordingStarted extends Event {
    static {
        Event.registerEventType(Type.RecordingStarted, RecordingStarted.class);
    }

    protected RecordingStarted() {
        super(Type.RecordingStarted);
    }
}
