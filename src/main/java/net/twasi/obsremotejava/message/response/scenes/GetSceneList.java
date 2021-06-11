package net.twasi.obsremotejava.message.response.scenes;

import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.objects.Scene;

import java.util.List;

public class GetSceneList extends RequestResponse {
    private List<Scene> scenes;

    public GetSceneList() {
        super(Request.Type.GetSceneList);
    }

    public List<Scene> getScenes() {
        return scenes;
    }
}
