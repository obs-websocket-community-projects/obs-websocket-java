package net.diespendendose.obsremotejava.requests.SetTransitionDuration;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class SetTransitionDurationRequest extends BaseRequest {
    private int duration;

    public SetTransitionDurationRequest(OBSCommunicator com, int duration) {
        super(RequestType.SetTransitionDuration);

        this.duration = duration;

        com.messageTypes.put(getMessageId(), SetTransitionDurationResponse.class);
    }
}
