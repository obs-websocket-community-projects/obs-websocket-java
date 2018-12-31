package net.twasi.obsremotejava.requests.GetTransitionDuration;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetTransitionDurationResponse extends ResponseBase {
    @SerializedName("transition-duration")
    private int transitionDuration;

    public int getTransitionDuration() {
        return transitionDuration;
    }
}
