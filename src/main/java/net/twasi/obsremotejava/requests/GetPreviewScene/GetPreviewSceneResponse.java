package net.twasi.obsremotejava.requests.GetPreviewScene;

import java.util.List;
import net.twasi.obsremotejava.model.Source;
import net.twasi.obsremotejava.requests.ResponseBase;

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
