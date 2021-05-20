package net.twasi.obsremotejava.requests.GetSourcesList;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSourcesListRequest extends BaseRequest {
    public GetSourcesListRequest(OBSCommunicator com) {
        super(RequestType.GetSourcesList);
        com.messageTypes.put(getMessageId(), GetSourcesListResponse.class);
    }
}
