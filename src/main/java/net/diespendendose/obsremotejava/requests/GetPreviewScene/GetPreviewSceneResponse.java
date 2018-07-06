package net.diespendendose.obsremotejava.requests.GetPreviewScene;

import net.diespendendose.obsremotejava.objects.Source;
import net.diespendendose.obsremotejava.requests.ResponseBase;

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
