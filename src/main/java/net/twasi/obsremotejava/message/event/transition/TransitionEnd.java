package net.twasi.obsremotejava.message.event.transition;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.message.event.Event;

public class TransitionEnd extends Event {
    private Data eventData;

    protected TransitionEnd() {
        super(Type.TransitionEnd);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
        private String name;
        private String type;
        @SerializedName("to-scene")
        private String toScene;
        private Integer duration;

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getToScene() {
            return toScene;
        }

        public Integer getDuration() {
            return duration;
        }
    }
}
