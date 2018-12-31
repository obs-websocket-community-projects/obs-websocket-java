package net.twasi.obsremotejava.requests.SaveReplayBuffer;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class SaveReplayBufferRequest extends BaseRequest {
    public SaveReplayBufferRequest(OBSCommunicator com) {
        super(RequestType.SaveReplayBuffer);

        com.messageTypes.put(getMessageId(), SaveReplayBufferResponse.class);
    }
}
