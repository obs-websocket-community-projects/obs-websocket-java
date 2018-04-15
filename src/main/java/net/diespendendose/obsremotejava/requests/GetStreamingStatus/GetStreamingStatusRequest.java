package net.diespendendose.obsremotejava.requests.GetStreamingStatus;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetStreamingStatusRequest extends BaseRequest {
    public GetStreamingStatusRequest(OBSCommunicator com) {
        super(RequestType.GetStreamingStatus);

        com.messageTypes.put(getMessageId(), GetStreamingStatusResponse.class);
    }
}
