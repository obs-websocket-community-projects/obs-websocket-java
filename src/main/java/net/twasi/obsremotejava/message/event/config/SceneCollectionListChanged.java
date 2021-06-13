package net.twasi.obsremotejava.message.event.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.objects.SceneCollection;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class SceneCollectionListChanged extends Event {
    private Data eventData;

    protected SceneCollectionListChanged() {
        super(Type.SceneCollectionListChanged, Category.Config);
    }

    @Getter
    @ToString
    public static class Data {
        private List<SceneCollection> sceneCollections;
    }
}
