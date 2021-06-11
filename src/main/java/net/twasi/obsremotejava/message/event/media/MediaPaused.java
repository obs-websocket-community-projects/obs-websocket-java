package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public class MediaPaused extends Media {
    static {
        Event.registerEventType(Type.MediaPaused, MediaPaused.class);
    }

    protected MediaPaused() {
        super(Type.MediaPaused);
    }
}
