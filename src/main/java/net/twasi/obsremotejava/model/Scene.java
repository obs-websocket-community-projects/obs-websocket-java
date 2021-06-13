package net.twasi.obsremotejava.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Scene {
    private String name;
    private List<Source> sources;

    public List<Source> getSourcesIncludingGroupChildren() {
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
