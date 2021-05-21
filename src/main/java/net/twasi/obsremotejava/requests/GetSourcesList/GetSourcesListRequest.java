package net.twasi.obsremotejava.requests.GetSourcesList;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSourcesListRequest extends RequestBase {
    public GetSourcesListRequest(OBSCommunicator com) {
        super(RequestType.GetSourcesList);
        com.messageTypes.put(getMessageId(), GetSourcesListResponse.class);
    }
}
