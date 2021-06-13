package net.twasi.obsremotejava.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputPlaybackEnded extends MediaInput {
    protected MediaInputPlaybackEnded() {
        super(Type.MediaInputPlaybackEnded, Category.MediaInputs);
    }
}
