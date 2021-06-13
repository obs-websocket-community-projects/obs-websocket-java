package net.twasi.obsremotejava.message.response.scenes;

import java.util.List;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.objects.Scene;

public class GetSceneList extends RequestResponse {
    private List<Scene> scenes;

    public GetSceneList() {
        super(Request.Type.GetSceneList);
    }

    public List<Scene> getScenes() {
        return scenes;
    }
}
