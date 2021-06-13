package net.twasi.obsremotejava.requests.GetSourceFilters;

import java.util.List;
import net.twasi.obsremotejava.objects.Filter;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetSourceFiltersResponse extends ResponseBase {
    List<Filter> filters;

    public List<Filter> getFilters() {
        return filters;
    }
}
