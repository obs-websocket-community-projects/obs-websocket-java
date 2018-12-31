package net.twasi.obsremotejava.requests.GetCurrentProfile;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetCurrentProfileRequest extends BaseRequest {
    public GetCurrentProfileRequest(OBSCommunicator com) {
        super(RequestType.GetCurrentProfile);

        com.messageTypes.put(getMessageId(), GetCurrentProfileResponse.class);
    }
}
