package net.twasi.obsremotejava.requests.StopReplayBuffer;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class StopReplayBufferRequest extends BaseRequest {
    public StopReplayBufferRequest(OBSCommunicator com) {
        super(RequestType.StopReplayBuffer);

        com.messageTypes.put(getMessageId(), StopReplayBufferResponse.class);
    }
}
