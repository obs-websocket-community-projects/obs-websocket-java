package net.diespendendose.obsremotejava.requests.StopReplayBuffer;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class StopReplayBufferRequest extends BaseRequest {
    public StopReplayBufferRequest(OBSCommunicator com) {
        super(RequestType.StopReplayBuffer);

        com.messageTypes.put(getMessageId(), StopReplayBufferResponse.class);
    }
}
