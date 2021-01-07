package net.twasi.obsremotejava.objects;

import java.util.Collection;
import java.util.Map;

public class SourceFilterSettings {
    private Collection<Map<String,String>> map;

    public Collection<Map<String, String>> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "SourceFilterSettings{" +
                map +
                '}';
    }
}
