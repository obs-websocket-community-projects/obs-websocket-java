package net.twasi.obsremotejava.requests.SetSourceFilterVisibility;

import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class SetSourceFilterVisibilityRequest extends BaseRequest {

    private final String sourceName;
    private final String filterName;
    private final boolean filterEnabled;

    public SetSourceFilterVisibilityRequest(String sourceName, String filterName, boolean filterEnabled) {
        super(RequestType.SetSourceFilterVisibility);
        this.sourceName = sourceName;
        this.filterName = filterName;
        this.filterEnabled = filterEnabled;
    }

}
