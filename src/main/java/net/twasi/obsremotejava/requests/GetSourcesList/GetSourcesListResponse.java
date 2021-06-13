package net.twasi.obsremotejava.requests.GetSourcesList;

import java.util.List;
import net.twasi.obsremotejava.objects.Source;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetSourcesListResponse extends ResponseBase {
    private List<Source> sources;

    public List<Source> getSources() {
        return sources;
    }
}
