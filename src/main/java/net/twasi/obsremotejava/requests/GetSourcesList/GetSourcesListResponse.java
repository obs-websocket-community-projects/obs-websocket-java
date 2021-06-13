package net.twasi.obsremotejava.requests.GetSourcesList;

import net.twasi.obsremotejava.objects.Source;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class GetSourcesListResponse extends ResponseBase {
    private List<Source> sources;

    public List<Source> getSources() {
        return sources;
    }
}
