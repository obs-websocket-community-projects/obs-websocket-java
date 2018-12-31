package net.diespendendose.obsremotejava.requests.SaveReplayBuffer;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class SaveReplayBufferRequest extends BaseRequest {
    public SaveReplayBufferRequest(OBSCommunicator com) {
        super(RequestType.SaveReplayBuffer);

        com.messageTypes.put(getMessageId(), SaveReplayBufferResponse.class);
    }
}
