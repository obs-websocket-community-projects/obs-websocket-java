package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public class MediaStopped extends Media {
    static {
        Event.registerEventType(Type.MediaStopped, MediaStopped.class);
    }

    protected MediaStopped() {
        super(Type.MediaStopped);
    }
}
