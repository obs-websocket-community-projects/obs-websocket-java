package net.twasi.obsremotejava.objects;

import java.util.List;

public class Source {
    private double cy;
    private double cx;
    private long alignment;
    private String name;
    private int id;
    private boolean render;
    private boolean muted;
    private boolean locked;
    private int source_cx;
    private int source_cy;
    private String type;
    private double volume;
    private double x;
    private double y;
    private String parentGroupName;
    private List<Source> groupChildren;

    public double getCY() {
        return cy;
    }

    public double getCX() {
        return cx;
    }

    public long getAlignment() {
        return alignment;
    }

    public String getName() {
        return name;
    }

    public boolean isRender() {
        return render;
    }

    public int getSourceCX() {
        return source_cx;
    }

    public int getSourceCY() {
        return source_cy;
    }

    public String getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public List<Source> getGroupChildren() {
        return groupChildren;
    }
}
