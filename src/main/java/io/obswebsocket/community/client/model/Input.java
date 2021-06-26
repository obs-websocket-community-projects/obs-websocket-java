package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Input {
    private String inputName;
    private String inputKind;
    private String unversionedInputKind;

    @Getter
    @ToString
    public enum MonitorType {
        @SerializedName("none")
        NONE,
        @SerializedName("monitorOnly")
        MONITOR_ONLY,
        @SerializedName("monitorAndOutput")
        MONITOR_AND_OUTPUT
    }
}
