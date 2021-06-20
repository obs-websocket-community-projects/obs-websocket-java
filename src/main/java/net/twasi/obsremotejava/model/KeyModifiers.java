package net.twasi.obsremotejava.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class KeyModifiers {
    private final boolean shift;
    private final boolean alt;
    private final boolean control;
    private final boolean command;
}
