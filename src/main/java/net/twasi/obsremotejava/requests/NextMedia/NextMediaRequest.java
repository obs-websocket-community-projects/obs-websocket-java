package net.twasi.obsremotejava.requests.NextMedia;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class NextMediaRequest extends BaseRequest {
    private String sourceName;

    public NextMediaRequest(OBSCommunicator com, String sourceName) {
        super(RequestType.NextMedia);

        this.sourceName = sourceName;

        com.messageTypes.put(getMessageId(), NextMediaResponse.class);
    }
}
