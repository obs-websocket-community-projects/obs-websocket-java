package net.twasi.obsremotejava.requests.SetStudioModeEnabled;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class SetStudioModeEnabledRequest extends BaseRequest {

    public SetStudioModeEnabledRequest(OBSCommunicator com, boolean enabled) {
        super(enabled ? RequestType.EnableStudioMode : RequestType.DisableStudioMode);

        com.messageTypes.put(getMessageId(), SetStudioModeEnabledResponse.class);
    }

}
