package net.twasi.obsremotejava.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

public abstract class InputMonitor {
    @Getter
    @ToString
    public enum Type {
        @SerializedName("none")
        NONE,
        @SerializedName("monitorOnly")
        MONITOR_ONLY,
        @SerializedName("monitorAndOutput")
        MONITOR_AND_OUTPUT
    }
}
