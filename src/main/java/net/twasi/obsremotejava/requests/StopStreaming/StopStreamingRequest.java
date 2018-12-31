package net.twasi.obsremotejava.requests.StopStreaming;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class StopStreamingRequest extends BaseRequest {
    public StopStreamingRequest(OBSCommunicator com) {
        super (RequestType.StopStreaming);

        com.messageTypes.put(getMessageId(), StopStreamingResponse.class);
    }
}
