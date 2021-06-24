package io.obswebsocket.community.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class InputAudioTracksChangedEvent extends InputEvent {
    private Data eventData;

    protected InputAudioTracksChangedEvent() {
        super(Type.InputAudioTracksChanged, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends InputEvent.Data {
        private List<Integer> inputAudioTracks;
    }
}
