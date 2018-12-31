package net.twasi.obsremotejava.requests.GetPreviewScene;

import net.twasi.obsremotejava.objects.Source;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class GetPreviewSceneResponse extends ResponseBase {
    private List<Source> sources;
    private String name;

    public List<Source> getSources() {
        return sources;
    }

    public String getName() {
        return name;
    }
}
