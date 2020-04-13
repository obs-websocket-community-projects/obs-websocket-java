package net.twasi.obsremotejava.events.responses;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.objects.Source;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class SwitchScenesResponse extends ResponseBase {
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
