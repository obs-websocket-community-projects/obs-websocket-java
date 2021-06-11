package net.twasi.obsremotejava.message.event.transition;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.message.event.Event;

public class SwitchTransition extends Event {
    static {
        Event.registerEventType(Type.SwitchTransition, SwitchTransition.class);
    }

    private Data eventData;

    protected SwitchTransition() {
        super(Type.SwitchTransition);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
        @SerializedName("transition-name")
        private String transitionName;

        public String getTransitionName() {
            return transitionName;
        }
    }
}
