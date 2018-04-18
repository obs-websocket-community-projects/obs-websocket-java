package net.diespendendose.obsremotejava.requests.ListProfiles;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class ListProfilesRequest extends BaseRequest {
    public ListProfilesRequest(OBSCommunicator com) {
        super(RequestType.ListProfiles);

        com.messageTypes.put(getMessageId(), ListProfilesResponse.class);
    }
}
