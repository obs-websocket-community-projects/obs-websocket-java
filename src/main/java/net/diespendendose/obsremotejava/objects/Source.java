package net.diespendendose.obsremotejava.objects;

import java.util.List;

public class Source {
    private String name;
    private List<Source> sources;

    public String getName() {
        return name;
    }

    public List<Source> getSources() {
        return sources;
    }
}
