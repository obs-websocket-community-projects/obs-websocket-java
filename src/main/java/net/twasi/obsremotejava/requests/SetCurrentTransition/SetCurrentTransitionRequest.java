package net.twasi.obsremotejava.requests.SetCurrentTransition;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class SetCurrentTransitionRequest extends BaseRequest {
    @SerializedName("transition-name")
    private String transition;

    public SetCurrentTransitionRequest(OBSCommunicator com, String transition) {
        super(RequestType.SetCurrentTransition);

        this.transition = transition;

        com.messageTypes.put(getMessageId(), SetCurrentTransitionResponse.class);
    }

    public String getTransition() {
        return transition;
    }
}
