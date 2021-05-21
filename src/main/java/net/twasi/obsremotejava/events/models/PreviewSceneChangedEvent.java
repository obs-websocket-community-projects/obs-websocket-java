package net.twasi.obsremotejava.events.models;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.events.EventBase;
import net.twasi.obsremotejava.objects.Source;

import java.util.List;

public class PreviewSceneChangedEvent extends EventBase {
    @SerializedName("scene-name")
    private String sceneName;
    private List<Source> sources;

    public String getSceneName() {
        return sceneName;
    }

    public List<Source> getSources() {
        return sources;
    }
}
