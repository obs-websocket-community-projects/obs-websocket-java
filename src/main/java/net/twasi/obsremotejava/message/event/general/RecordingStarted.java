package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class RecordingStarted extends Event {
    protected RecordingStarted() {
        super(Type.RecordingStarted);
    }
}
