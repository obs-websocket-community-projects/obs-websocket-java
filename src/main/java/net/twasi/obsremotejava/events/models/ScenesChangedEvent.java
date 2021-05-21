package net.twasi.obsremotejava.events.models;

import net.twasi.obsremotejava.events.EventBase;
import net.twasi.obsremotejava.objects.Scene;

import java.util.List;

public class ScenesChangedEvent extends EventBase {
    private List<Scene> scenes;

    public List<Scene> getScenes() {
        return scenes;
    }
}
