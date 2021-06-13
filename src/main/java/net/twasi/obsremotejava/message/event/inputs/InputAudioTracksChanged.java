package net.twasi.obsremotejava.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class InputAudioTracksChanged extends Input {
    private Data eventData;

    protected InputAudioTracksChanged() {
        super(Type.InputAudioTracksChanged, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends Input.Data {
        private List<Integer> inputAudioTracks;
    }
}
