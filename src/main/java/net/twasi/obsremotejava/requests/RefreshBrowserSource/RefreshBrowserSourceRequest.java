package net.twasi.obsremotejava.requests.RefreshBrowserSource;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class RefreshBrowserSourceRequest extends BaseRequest {
    private String sourceName;

    public RefreshBrowserSourceRequest(OBSCommunicator com, String sourceName) {
        super(RequestType.RefreshBrowserSource);

        this.sourceName = sourceName;

        com.messageTypes.put(getMessageId(), RefreshBrowserSourceResponse.class);
    }
}
