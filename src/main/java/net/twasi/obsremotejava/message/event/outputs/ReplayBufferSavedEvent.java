package net.twasi.obsremotejava.message.event.outputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString
public class ReplayBufferSavedEvent extends Event {
    private Data eventData;

    protected ReplayBufferSavedEvent() {
        super(Type.ReplayBufferSaved, Category.Outputs);
    }

    @Getter
    @ToString
    public static class Data {
        private String savedReplayPath;
    }
}
