package net.diespendendose.obsremotejava.requests.StartReplayBuffer;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class StartReplayBufferRequest extends BaseRequest {
    public StartReplayBufferRequest(OBSCommunicator com) {
        super(RequestType.StartReplayBuffer);

        com.messageTypes.put(getMessageId(), StartReplayBufferResponse.class);
    }
}
