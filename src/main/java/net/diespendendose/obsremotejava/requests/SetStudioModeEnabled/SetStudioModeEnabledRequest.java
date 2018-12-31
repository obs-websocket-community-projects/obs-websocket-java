package net.diespendendose.obsremotejava.requests.SetStudioModeEnabled;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class SetStudioModeEnabledRequest extends BaseRequest {

    public SetStudioModeEnabledRequest(OBSCommunicator com, boolean enabled) {
        super(enabled ? RequestType.EnableStudioMode : RequestType.DisableStudioMode);

        com.messageTypes.put(getMessageId(), SetStudioModeEnabledResponse.class);
    }

}
