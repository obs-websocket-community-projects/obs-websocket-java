package net.diespendendose.obsremotejava.requests.GetCurrentProfile;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetCurrentProfileRequest extends BaseRequest {
    public GetCurrentProfileRequest(OBSCommunicator com) {
        super(RequestType.GetCurrentProfile);

        com.messageTypes.put(getMessageId(), GetCurrentProfileResponse.class);
    }
}
