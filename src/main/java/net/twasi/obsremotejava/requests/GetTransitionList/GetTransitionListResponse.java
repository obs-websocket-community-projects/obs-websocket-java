package net.twasi.obsremotejava.requests.GetTransitionList;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import net.twasi.obsremotejava.objects.Transition;
import net.twasi.obsremotejava.requests.ResponseBase;

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
