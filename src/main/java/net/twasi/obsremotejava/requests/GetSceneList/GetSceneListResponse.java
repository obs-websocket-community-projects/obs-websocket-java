package net.twasi.obsremotejava.requests.GetSceneList;

import java.util.List;
import net.twasi.obsremotejava.objects.Scene;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetSceneListResponse extends ResponseBase {
    private List<Scene> scenes;

    public List<Scene> getScenes() {
        return scenes;
    }
}
