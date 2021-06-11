package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public class MediaEnded extends Media {
    static {
        Event.registerEventType(Type.MediaEnded, MediaEnded.class);
    }

    protected MediaEnded() {
        super(Type.MediaEnded);
    }
}
