package net.twasi.obsremotejava.requests.SaveReplayBuffer;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class SaveReplayBufferRequest extends RequestBase {
    public SaveReplayBufferRequest(OBSCommunicator com) {
        super(RequestType.SaveReplayBuffer);

        // com.messageTypes.put(getMessageId(), SaveReplayBufferResponse.class);
    }
}
