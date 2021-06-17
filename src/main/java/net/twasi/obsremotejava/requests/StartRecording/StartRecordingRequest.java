package net.twasi.obsremotejava.requests.StartRecording;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class StartRecordingRequest extends RequestBase {

    public StartRecordingRequest(OBSCommunicator com) {
        super(RequestType.StartRecording);

        // com.messageTypes.put(getMessageId(), StartRecordingResponse.class);
    }
}
