package net.twasi.obsremotejava.requests.ListProfiles;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class ListProfilesRequest extends RequestBase {
    public ListProfilesRequest(OBSCommunicator com) {
        super(RequestType.ListProfiles);

        com.messageTypes.put(getMessageId(), ListProfilesResponse.class);
    }
}
