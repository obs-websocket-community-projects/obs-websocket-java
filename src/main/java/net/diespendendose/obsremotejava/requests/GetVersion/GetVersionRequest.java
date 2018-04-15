package net.diespendendose.obsremotejava.requests.GetVersion;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetVersionRequest extends BaseRequest {
    public GetVersionRequest(OBSCommunicator com) {
        super(RequestType.GetVersion);
        com.messageTypes.put(getMessageId(), GetVersionResponse.class);
    }
}
