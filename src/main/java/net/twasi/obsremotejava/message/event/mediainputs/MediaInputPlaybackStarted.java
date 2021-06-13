package net.twasi.obsremotejava.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputPlaybackStarted extends MediaInput {
    protected MediaInputPlaybackStarted() {
        super(Type.MediaInputPlaybackStarted, Category.MediaInputs);
    }
}
