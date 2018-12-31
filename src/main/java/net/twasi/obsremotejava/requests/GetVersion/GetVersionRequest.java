package net.twasi.obsremotejava.requests.GetVersion;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetVersionRequest extends BaseRequest {
    public GetVersionRequest(OBSCommunicator com) {
        super(RequestType.GetVersion);
        com.messageTypes.put(getMessageId(), GetVersionResponse.class);
    }
}
