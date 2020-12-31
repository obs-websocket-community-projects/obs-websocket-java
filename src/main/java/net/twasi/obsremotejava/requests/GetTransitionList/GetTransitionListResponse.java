package net.twasi.obsremotejava.requests.GetTransitionList;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.objects.Transition;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class GetTransitionListResponse extends ResponseBase {
    @SerializedName("current-transition")
    private String currentTransition;

    private List<Transition> transitions;

    public String getCurrentTransition() {
        return currentTransition;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}
