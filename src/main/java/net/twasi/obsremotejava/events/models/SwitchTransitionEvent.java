package net.twasi.obsremotejava.events.models;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.events.EventBase;

public class SwitchTransitionEvent extends EventBase {
    @SerializedName("transition-name")
    private String transitionName;

    public String getTransitionName() {
        return transitionName;
    }
}
