package io.obswebsocket.community.client.message.event.mediainputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class MediaInputActionTriggeredEvent extends MediaInputEvent {
    private Data eventData;

    protected MediaInputActionTriggeredEvent() {
        super(Type.MediaInputActionTriggered, Category.MediaInputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends MediaInputEvent.Data {
        private String mediaAction;
    }
}
