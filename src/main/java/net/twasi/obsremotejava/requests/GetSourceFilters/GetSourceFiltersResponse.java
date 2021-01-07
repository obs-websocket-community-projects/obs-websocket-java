package net.twasi.obsremotejava.requests.GetSourceFilters;

import net.twasi.obsremotejava.objects.SourceFilterInfo;
import net.twasi.obsremotejava.requests.GetSourceSettings.GetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class GetSourceFiltersResponse extends ResponseBase {

    List<SourceFilterInfo> filters;

    public List<SourceFilterInfo> getFilters() {
        return filters;
    }
}
