package net.diespendendose.obsremotejava.requests.GetSceneList;

import net.diespendendose.obsremotejava.objects.Scene;
import net.diespendendose.obsremotejava.requests.ResponseBase;

import java.util.List;

public class GetSceneListResponse extends ResponseBase {
    private List<Scene> scenes;

    public List<Scene> getScenes() {
        return scenes;
    }
}
