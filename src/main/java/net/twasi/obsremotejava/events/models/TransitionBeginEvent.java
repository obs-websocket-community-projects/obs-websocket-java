package net.twasi.obsremotejava.events.models;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.events.EventBase;

public class TransitionBeginEvent extends EventBase {
    private String name;
    private String type;

    @SerializedName("from-scene")
    private String fromScene;

    @SerializedName("to-scene")
    private String toScene;

    private Integer duration;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFromScene() {
        return fromScene;
    }

    public String getToScene() {
        return toScene;
    }

    public Integer getDuration() {
        return duration;
    }
}
