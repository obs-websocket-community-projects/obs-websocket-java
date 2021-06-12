package net.twasi.obsremotejava.message.event.general;

import net.twasi.obsremotejava.message.event.Event;

public class RecordingStopped extends Event {
    protected RecordingStopped() {
        super(Type.RecordingStopped);
    }
}
