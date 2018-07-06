package net.diespendendose.obsremotejava.requests.SetMute;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class SetMuteRequest extends BaseRequest {
    private boolean mute;
    private String source;

    public SetMuteRequest(OBSCommunicator com, String source, boolean mute) {
        super(RequestType.SetMute);

        this.mute = mute;
        this.source = source;

        com.messageTypes.put(getMessageId(), SetMuteResponse.class);
    }

}
