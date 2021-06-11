package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public class MediaNext extends Media {
    static {
        Event.registerEventType(Type.MediaNext, MediaNext.class);
    }

    protected MediaNext() {
        super(Type.MediaNext);
    }
}
