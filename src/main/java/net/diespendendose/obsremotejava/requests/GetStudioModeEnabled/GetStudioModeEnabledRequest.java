package net.diespendendose.obsremotejava.requests.GetStudioModeEnabled;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetStudioModeEnabledRequest extends BaseRequest {
    public GetStudioModeEnabledRequest(OBSCommunicator com) {
        super(RequestType.GetStudioModeStatus);

        com.messageTypes.put(getMessageId(), GetStudioModeEnabledResponse.class);
    }
}
