package net.twasi.obsremotejava.requests.GetSourceFilterInfo;

import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSourceFilterInfoRequest extends BaseRequest {
    private final String sourceName;
    private final String filterName;

    public GetSourceFilterInfoRequest(String sourceName, String filterName) {
        super(RequestType.GetSourceFilterInfo);
        this.sourceName = sourceName;
        this.filterName = filterName;
    }

}
