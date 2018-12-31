package net.twasi.obsremotejava.requests.GetSceneList;

import net.twasi.obsremotejava.objects.Scene;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class GetSceneListResponse extends ResponseBase {
    private List<Scene> scenes;

    public List<Scene> getScenes() {
        return scenes;
    }
}
