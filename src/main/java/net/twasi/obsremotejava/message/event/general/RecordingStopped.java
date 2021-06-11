package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class RecordingStopped extends Event {
    static {
        Event.registerEventType(Type.RecordingStopped, RecordingStopped.class);
    }

    protected RecordingStopped() {
        super(Type.RecordingStopped);
    }
}
