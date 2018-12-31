package net.twasi.obsremotejava.requests.GetStudioModeEnabled;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetStudioModeEnabledRequest extends BaseRequest {
    public GetStudioModeEnabledRequest(OBSCommunicator com) {
        super(RequestType.GetStudioModeStatus);

        com.messageTypes.put(getMessageId(), GetStudioModeEnabledResponse.class);
    }
}
