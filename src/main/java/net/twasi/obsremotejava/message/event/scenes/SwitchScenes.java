package net.twasi.obsremotejava.message.event.scenes;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.objects.Source;

import java.util.List;

public class SwitchScenes extends Event {
    private Data eventData;

    protected SwitchScenes() {
        super(Type.SwitchScenes);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
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
}
