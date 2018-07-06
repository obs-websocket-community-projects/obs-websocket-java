package net.diespendendose.obsremotejava.requests.GetTransitionDuration;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetTransitionDurationRequest extends BaseRequest {
    public GetTransitionDurationRequest(OBSCommunicator com) {
        super(RequestType.GetTransitionDuration);

        com.messageTypes.put(getMessageId(), GetTransitionDurationResponse.class);
    }
}
