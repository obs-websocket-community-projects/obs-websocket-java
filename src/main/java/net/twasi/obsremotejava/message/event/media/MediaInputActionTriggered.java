package net.twasi.obsremotejava.message.event.media;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MediaInputActionTriggered extends Media {
    private Data eventData;

    protected MediaInputActionTriggered() {
        super(Type.MediaInputActionTriggered, Category.MediaInputs);
    }

    @Getter
    @ToString
    public static class Data extends Media.Data {
        private String mediaAction;
    }
}
