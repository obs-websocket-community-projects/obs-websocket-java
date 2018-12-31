package net.twasi.obsremotejava.requests.StartStreaming;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class StartStreamingRequest extends BaseRequest {

    public StartStreamingRequest(OBSCommunicator com) {
        super(RequestType.StartStreaming);

        com.messageTypes.put(getMessageId(), StartStreamingResponse.class);
    }
}
