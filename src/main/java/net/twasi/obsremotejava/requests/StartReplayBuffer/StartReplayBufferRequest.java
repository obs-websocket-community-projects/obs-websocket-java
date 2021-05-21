package net.twasi.obsremotejava.requests.StartReplayBuffer;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class StartReplayBufferRequest extends RequestBase {
    public StartReplayBufferRequest(OBSCommunicator com) {
        super(RequestType.StartReplayBuffer);

        com.messageTypes.put(getMessageId(), StartReplayBufferResponse.class);
    }
}
