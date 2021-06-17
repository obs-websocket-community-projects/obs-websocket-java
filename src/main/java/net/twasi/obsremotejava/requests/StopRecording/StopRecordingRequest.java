package net.twasi.obsremotejava.requests.StopRecording;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class StopRecordingRequest extends RequestBase {
    public StopRecordingRequest(OBSCommunicator com) {
        super(RequestType.StopRecording);

        // com.messageTypes.put(getMessageId(), StopRecordingResponse.class);
    }
}
