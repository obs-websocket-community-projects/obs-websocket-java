package net.twasi.obsremotejava.model;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Filter {
    private boolean enabled;
    private String type;
    private String name;
    private JsonObject settings;
}
