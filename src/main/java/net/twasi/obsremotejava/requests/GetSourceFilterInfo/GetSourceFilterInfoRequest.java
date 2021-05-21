package net.twasi.obsremotejava.requests.GetSourceFilterInfo;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSourceFilterInfoRequest extends RequestBase {
    private final String sourceName;
    private final String filterName;

    public GetSourceFilterInfoRequest(OBSCommunicator com, String sourceName, String filterName) {
        super(RequestType.GetSourceFilterInfo);

        this.sourceName = sourceName;
        this.filterName = filterName;

        com.messageTypes.put(getMessageId(), GetSourceFilterInfoResponse.class);
    }
}
