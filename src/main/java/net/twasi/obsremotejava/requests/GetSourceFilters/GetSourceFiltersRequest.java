package net.twasi.obsremotejava.requests.GetSourceFilters;

import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSourceFiltersRequest extends BaseRequest {
    private final String sourceName;

    public GetSourceFiltersRequest(String sourceName) {
        super(RequestType.GetSourceFilters);
        this.sourceName = sourceName;
    }
}
