package net.twasi.obsremotejava.requests.GetMute;

import net.twasi.obsremotejava.requests.ResponseBase;

public class GetMuteResponse extends ResponseBase {
    private String source;
    private boolean muted;

    public String getSource() {
        return source;
    }

    public Boolean isMuted() {
        return muted;
    }
}
