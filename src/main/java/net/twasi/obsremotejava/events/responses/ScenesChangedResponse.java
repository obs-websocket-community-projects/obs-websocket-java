package net.twasi.obsremotejava.events.responses;

import net.twasi.obsremotejava.objects.Scene;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class ScenesChangedResponse extends ResponseBase {
    private List<Scene> scenes;

    public List<Scene> getScenes() {
        return scenes;
    }
}
