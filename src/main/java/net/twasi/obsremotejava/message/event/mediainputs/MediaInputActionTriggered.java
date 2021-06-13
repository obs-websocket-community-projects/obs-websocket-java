package net.twasi.obsremotejava.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputActionTriggered extends MediaInput {
    private Data eventData;

    protected MediaInputActionTriggered() {
        super(Type.MediaInputActionTriggered, Category.MediaInputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends MediaInput.Data {
        private String mediaAction;
    }
}
