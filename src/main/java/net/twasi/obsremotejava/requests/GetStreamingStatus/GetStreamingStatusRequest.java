package net.twasi.obsremotejava.requests.GetStreamingStatus;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetStreamingStatusRequest extends RequestBase {
    public GetStreamingStatusRequest(OBSCommunicator com) {
        super(RequestType.GetStreamingStatus);

        // com.messageTypes.put(getMessageId(), GetStreamingStatusResponse.class);
    }
}
