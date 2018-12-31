package net.twasi.obsremotejava.requests.SetTransitionDuration;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class SetTransitionDurationRequest extends BaseRequest {
    private int duration;

    public SetTransitionDurationRequest(OBSCommunicator com, int duration) {
        super(RequestType.SetTransitionDuration);

        this.duration = duration;

        com.messageTypes.put(getMessageId(), SetTransitionDurationResponse.class);
    }
}
