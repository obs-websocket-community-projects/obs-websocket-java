package net.twasi.obsremotejava.model;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
public class Filter {
    private String filterName;
    private Boolean filterEnabled;
    private Integer filterIndex;
    private String filterKind;
    private JsonObject filterSettings;
}
