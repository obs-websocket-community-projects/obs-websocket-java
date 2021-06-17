package net.twasi.obsremotejava.requests.SetSourceFilterVisibility;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class SetSourceFilterVisibilityRequest extends RequestBase {

    private final String sourceName;
    private final String filterName;
    private final boolean filterEnabled;

    public SetSourceFilterVisibilityRequest(OBSCommunicator com, String sourceName, String filterName, boolean filterEnabled) {
        super(RequestType.SetSourceFilterVisibility);
        this.sourceName = sourceName;
        this.filterName = filterName;
        this.filterEnabled = filterEnabled;

        // com.messageTypes.put(getMessageId(), SetSourceFilterVisibilityResponse.class);
    }
}
