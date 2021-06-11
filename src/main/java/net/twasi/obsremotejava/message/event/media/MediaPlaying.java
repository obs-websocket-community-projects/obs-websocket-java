package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public class MediaPlaying extends Media {
    static {
        Event.registerEventType(Type.MediaPlaying, MediaPlaying.class);
    }

    protected MediaPlaying() {
        super(Type.MediaPlaying);
    }
}
