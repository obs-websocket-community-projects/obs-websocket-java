package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public class MediaStarted extends Media {
    static {
        Event.registerEventType(Type.MediaStarted, MediaStarted.class);
    }

    protected MediaStarted() {
        super(Type.MediaStarted);
    }
}
