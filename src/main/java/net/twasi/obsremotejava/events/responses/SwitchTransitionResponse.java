package net.twasi.obsremotejava.events.responses;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.requests.ResponseBase;

public class SwitchTransitionResponse extends ResponseBase {
    @SerializedName("transition-name")
    private String transitionName;

    public String getTransitionName() {
        return transitionName;
    }
}
