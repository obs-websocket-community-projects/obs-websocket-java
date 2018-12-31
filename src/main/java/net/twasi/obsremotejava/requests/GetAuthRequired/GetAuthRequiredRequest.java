package net.twasi.obsremotejava.requests.GetAuthRequired;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetAuthRequiredRequest extends BaseRequest {

    public GetAuthRequiredRequest(OBSCommunicator com) {
        super(RequestType.GetAuthRequired);
        com.messageTypes.put(getMessageId(), GetAuthRequiredResponse.class);
    }
}