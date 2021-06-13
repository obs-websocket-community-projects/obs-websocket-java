package net.twasi.obsremotejava.requests.RestartMedia;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class RestartMediaRequest extends RequestBase {
    private String sourceName;

    public RestartMediaRequest(OBSCommunicator com, String sourceName) {
        super(RequestType.RestartMedia);

        this.sourceName = sourceName;

        com.messageTypes.put(getMessageId(), RestartMediaResponse.class);
    }
}
