package net.twasi.obsremotejava.requests.GetSpecialSources;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSpecialSourcesRequest extends BaseRequest {
    public GetSpecialSourcesRequest(OBSCommunicator com) {
        super(RequestType.GetSpecialSources);

        com.messageTypes.put(getMessageId(), GetSpecialSourcesResponse.class);
    }
}
