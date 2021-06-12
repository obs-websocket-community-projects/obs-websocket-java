package net.twasi.obsremotejava.message.event.scene;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.objects.Source;

import java.util.List;

public class PreviewSceneChanged extends Event {
    private Data eventData;

    protected PreviewSceneChanged() {
        super(Type.PreviewSceneChanged);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
        @SerializedName("scene-name")
        private String sceneName;
        private List<Source> sources;

        public String getSceneName() {
            return this.sceneName;
        }

        public List<Source> getSources() {
            return this.sources;
        }
    }
}
