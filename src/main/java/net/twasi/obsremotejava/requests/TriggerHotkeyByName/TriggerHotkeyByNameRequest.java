package net.twasi.obsremotejava.requests.TriggerHotkeyByName;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class TriggerHotkeyByNameRequest extends RequestBase {
    private String hotkeyName;

    public TriggerHotkeyByNameRequest(OBSCommunicator com, String hotkeyName) {
        super(RequestType.TriggerHotkeyByName);

        this.hotkeyName = hotkeyName;

        com.messageTypes.put(getMessageId(), TriggerHotkeyByNameResponse.class);
    }
}
