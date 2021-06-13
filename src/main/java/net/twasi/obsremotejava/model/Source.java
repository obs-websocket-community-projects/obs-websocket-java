package net.twasi.obsremotejava.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
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
}
