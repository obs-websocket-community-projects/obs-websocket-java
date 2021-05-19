package net.twasi.obsremotejava.requests.GetSourceFilters;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSourceFiltersRequest extends BaseRequest {
    private final String sourceName;

    public GetSourceFiltersRequest(OBSCommunicator com, String sourceName) {
        super(RequestType.GetSourceFilters);

        this.sourceName = sourceName;

        com.messageTypes.put(getMessageId(), GetSourceFiltersResponse.class);
    }
}
