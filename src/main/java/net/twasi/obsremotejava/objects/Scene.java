package net.twasi.obsremotejava.objects;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private String name;
    private List<Source> sources;

    public String getName() {
        return name;
    }

    public List<Source> getSources() {
        return sources;
    }

    public List<Source> getAllSources() {
        List<Source> allSources = new ArrayList<>();
        this.sources.forEach(source -> {
            allSources.add(source);
            if (source.getGroupChildren() != null && source.getGroupChildren().size() > 0) {
                allSources.addAll(source.getGroupChildren());
            }
        });

        return allSources;
    }
}
