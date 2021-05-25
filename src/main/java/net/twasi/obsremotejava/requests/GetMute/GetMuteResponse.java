package net.twasi.obsremotejava.requests.GetMute;

import net.twasi.obsremotejava.requests.ResponseBase;

public class GetMuteResponse extends ResponseBase {
    private String source;
    private boolean mute;

    public String getSource() {
        return source;
    }

    public Boolean getMute() {
        return mute;
    }
}
