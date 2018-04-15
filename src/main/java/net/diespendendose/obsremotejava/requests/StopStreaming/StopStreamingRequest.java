package net.diespendendose.obsremotejava.requests.StopStreaming;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class StopStreamingRequest extends BaseRequest {
    public StopStreamingRequest(OBSCommunicator com) {
        super (RequestType.StopStreaming);

        com.messageTypes.put(getMessageId(), StopStreamingResponse.class);
    }
}
