package net.diespendendose.obsremotejava.requests.StartStreaming;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class StartStreamingRequest extends BaseRequest {

    public StartStreamingRequest(OBSCommunicator com) {
        super(RequestType.StartStreaming);

        com.messageTypes.put(getMessageId(), StartStreamingResponse.class);
    }
}
