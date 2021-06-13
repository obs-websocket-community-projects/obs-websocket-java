package net.twasi.obsremotejava.requests.GetSpecialSources;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetSpecialSourcesResponse extends ResponseBase {
    @SerializedName("desktop-1")
    private String desktop1;
    @SerializedName("desktop-2")
    private String desktop2;
    @SerializedName("mic-1")
    private String mic1;
    @SerializedName("mic-2")
    private String mic2;
    @SerializedName("mic-3")
    private String mic3;

    public String getDesktop1() {
        return desktop1;
    }

    public String getDesktop2() {
        return desktop2;
    }

    public String getMic1() {
        return mic1;
    }

    public String getMic2() {
        return mic2;
    }

    public String getMic3() {
        return mic3;
    }
}
