package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public class MediaRestarted extends Media {
    static {
        Event.registerEventType(Type.MediaRestarted, MediaRestarted.class);
    }

    protected MediaRestarted() {
        super(Type.MediaRestarted);
    }
}
