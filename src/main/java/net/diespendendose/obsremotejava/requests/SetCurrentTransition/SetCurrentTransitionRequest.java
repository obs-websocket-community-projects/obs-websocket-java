package net.diespendendose.obsremotejava.requests.SetCurrentTransition;

import com.google.gson.annotations.SerializedName;
import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

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
