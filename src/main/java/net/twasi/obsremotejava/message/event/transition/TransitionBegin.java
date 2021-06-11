package net.twasi.obsremotejava.message.event.transition;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.message.event.Event;

public class TransitionBegin extends Event {
    static {
        Event.registerEventType(Type.TransitionBegin, TransitionBegin.class);
    }

    private Data eventData;

    protected TransitionBegin() {
        super(Type.TransitionBegin);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
        private String name;
        private String type;
        @SerializedName("from-scene")
        private String fromScene;
        @SerializedName("to-scene")
        private String toScene;
        private Integer duration;

        public String getName() {
            return this.name;
        }

        public String getType() {
            return this.type;
        }

        public String getFromScene() {
            return this.fromScene;
        }

        public String getToScene() {
            return this.toScene;
        }

        public Integer getDuration() {
            return this.duration;
        }
    }
}
