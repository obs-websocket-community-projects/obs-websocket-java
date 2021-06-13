package net.twasi.obsremotejava.requests.SetSourceSettings;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

import java.util.Map;

public class SetSourceSettingsRequest extends RequestBase {
    private String sourceName;
    private Map<String, Object> sourceSettings;

    public SetSourceSettingsRequest(OBSCommunicator com, String sourceName, Map<String, Object> settings) {
        super(RequestType.SetSourceSettings);

        this.sourceName = sourceName;
        this.sourceSettings = settings;

        com.messageTypes.put(getMessageId(), SetSourceSettingsResponse.class);
    }
}
