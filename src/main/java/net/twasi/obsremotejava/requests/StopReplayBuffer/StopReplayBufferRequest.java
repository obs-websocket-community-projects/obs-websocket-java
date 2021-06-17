package net.twasi.obsremotejava.requests.StopReplayBuffer;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class StopReplayBufferRequest extends RequestBase {
    public StopReplayBufferRequest(OBSCommunicator com) {
        super(RequestType.StopReplayBuffer);

        // com.messageTypes.put(getMessageId(), StopReplayBufferResponse.class);
    }
}
