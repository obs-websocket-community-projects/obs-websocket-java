package net.twasi.obsremotejava.message.event.scenes;

import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.objects.Scene;

import java.util.List;

public class ScenesChanged extends Event {
    private Data eventData;

    protected ScenesChanged() {
        super(Type.ScenesChanged);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
        private List<Scene> scenes;

        public List<Scene> getScenes() {
            return this.scenes;
        }
    }
}
